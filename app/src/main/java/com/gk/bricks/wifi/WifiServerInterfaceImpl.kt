package com.gk.bricks.wifi

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.gk.bricks.util.AppSingleton
import com.gk.bricks.util.Constants.SHAFT_RECEIVE_END_VAL
import com.gk.bricks.util.Constants.SHAFT_RECEIVE_START_VAL
import com.gk.bricks.util.Constants.WEB_SOCKET_CONNECTION_TIME_OUT
import com.gk.bricks.util.Constants.WEB_SOCKET_READ_TIME_OUT
import com.gk.bricks.util.WiFiServerStatus
import com.gk.bricks.util.WifiConnectionData
import com.gk.bricks.util.getExceptionString
import com.gk.bricks.util.saveExceptionsToFile
import com.gk.bricks.websocketclient.WebSocketClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URI
import java.net.URISyntaxException


open class WifiServerInterfaceImpl(
    private val context: Context,
) : Activity(), WifiServerInterface {
    private lateinit var currentStatus: (WiFiServerStatus) -> Unit
    private var webSocketClient: WebSocketClient? = null
    private var shaftCount = 6
    private var tempByte: ByteArray = ByteArray(0)
    private var latestByteData = ""
    private var currentCabinStatus = ByteArray(10)
    private var job: Job? = null
    private var i = 0

    companion object{
        const val TAG = "WifiServerInterfaceImpl"
    }

    override fun listenToWifiConnection(status: (WiFiServerStatus) -> Unit) {
        this.currentStatus = status
    }

    private fun stopSending() {
        job?.let {
            if (it.isActive)
                it.cancel()
        }
    }

    private fun sendJob() {
        stopSending()
        Log.d(TAG,"NIBAV_WIFI_SHAFT_sendJob --> STARTED")
        job = GlobalScope.launch(Dispatchers.Default) {
            try {
                var count = 0
                while (true) {
//                    if (ParseDataSingleton.isWifiCabinConnected.value == true)
                    currentCabinStatus[0] = count.toByte()
                    sendWifiData(currentCabinStatus)
                    if (count > 200){
                        count = 0
                    }
                    count ++
                    delay(750)
                }
            } catch (e: Exception) {
                Log.d(TAG, ("NIBAV_WIFI_SHAFT_ERROR1" + e.message) ?: "")
                val value = getExceptionString(object{},e)
                saveExceptionsToFile(context,value)
                e.printStackTrace()
            } finally {
                Log.d(TAG,"NIBAV_WIFI_SHAFT_FINALLY --> STOPPED")

            }
        }

    }

    override fun openWifiAccessory(
        onDataReceived: (ByteArray) -> Unit,
        onDataReceivedText: (String) -> Unit,
    ) {
        GlobalScope.launch(IO) {
            var isFirstMsgReceived = false
            val connectionHandler = Handler(Looper.getMainLooper())
            connectionHandler.postDelayed({
                stopSending()
                Log.d(TAG,"NIBAV_WIFI_SHAFT_ERROR2 --> connectionHandler timeout")
                currentStatus.invoke(WiFiServerStatus.NOT_CONNECTED)
                AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.SERVER_NOT_FOUND)
            }, WEB_SOCKET_CONNECTION_TIME_OUT)

            var lastShaftData = ""
            Log.d(TAG,"NIBAV_WIFI_SHAFT --> CONNECTING")
            currentStatus.invoke(WiFiServerStatus.CONNECTING)
            AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.CONNECTING)
            val uri: URI = try {
                Log.d("NIBAV_WIFI_SHAFT_URL", "${WifiConnectionData.getCabinWebSocketUrl()}")
                URI(WifiConnectionData.getCabinWebSocketUrl())

            } catch (e: URISyntaxException) {
                e.printStackTrace()
                connectionHandler.removeCallbacksAndMessages(null)
                currentStatus.invoke(WiFiServerStatus.NOT_REACHABLE)
                AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.SERVER_NOT_FOUND)
                return@launch
            }
            webSocketClient = object : WebSocketClient(uri) {
                override fun onOpen() {
                    connectionHandler.removeCallbacksAndMessages(null)
                    currentStatus.invoke(WiFiServerStatus.CONNECTED)
                    AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.CONNECTING)
                    Log.d(TAG,"NIBAV_WIFI_SHAFT --> onOpen")
                  //  sendJob()
                }

                override fun onTextReceived(message: String?) {
                    Log.d(TAG,"NIBAV_WIFI_SHAFT_message --> $message")
                    onDataReceivedText.invoke(message ?: "")
                }

                override fun onBinaryReceived(receivedData: ByteArray?) {
                    AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.SERVER_CONNECTED)
                    val hexString = receivedData?.joinToString(", ") { String.format("0x%02X", it) }
                    Log.d(TAG,"NIBAV_WIFI_SHAFT_NEW --> $hexString")
                    if (receivedData != null && receivedData.size == shaftCount
                        && receivedData[0] == SHAFT_RECEIVE_START_VAL
                        && receivedData[receivedData.size -1] == SHAFT_RECEIVE_END_VAL
                        ) {
//                        val latestShaftData = receivedData.contentToString()
//                        if (lastShaftData != latestShaftData) {
                            Log.d(TAG,"NIBAV_WIFI_SHAFT_NEW_PP --> $hexString")
//                            lastShaftData = latestShaftData
                            onDataReceived.invoke(receivedData)
//                        }
                    }

                }

                override fun onPingReceived(data: ByteArray?) {
                    Log.d(TAG,"NIBAV_WIFI_SHAFT --> onPingReceived")
                }

                override fun onPongReceived(data: ByteArray?) {
                    Log.d(TAG,"NIBAV_WIFI_SHAFT --> onPongReceived")

                }

                override fun onException(e: java.lang.Exception) {
                    stopSending()
                    connectionHandler.removeCallbacksAndMessages(null)
                    currentStatus.invoke(WiFiServerStatus.NOT_CONNECTED)
                    AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.SERVER_NOT_FOUND)
                    Log.d(TAG,"NIBAV_WIFI_SHAFT_ERROR3 -->"+ e.message.toString())
                    //Read timed out
                    //Connection reset
                    //Software caused connection abort
                    //close(0, 0, "immediate")
                }

                override fun onCloseReceived(reason: Int, description: String?) {
                    stopSending()
                    connectionHandler.removeCallbacksAndMessages(null)
                    currentStatus.invoke(WiFiServerStatus.NOT_CONNECTED)
                    AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.SERVER_NOT_FOUND)
                    Log.d(TAG,"NIBAV_WIFI_SHAFT --> onCloseReceived")
                }

            }
           try {
               webSocketClient?.setConnectTimeout(4000)
               webSocketClient?.setReadTimeout(WEB_SOCKET_READ_TIME_OUT)
               //webSocketClient?.addHeader("Origin", "http://developer.example.com")
               // webSocketClient?.enableAutomaticReconnection(5000)
               webSocketClient?.connect()
           }catch (e: Exception) {
               Log.d(TAG, "NIBAV_WIFI_SHAFT_ERROR4 -->" + (e.message ?: ""))
               val value = getExceptionString(object{},e)
               saveExceptionsToFile(context,value)
               e.printStackTrace()
           }
        }
    }


    override fun sendWifiData(buffer: ByteArray) {
        GlobalScope.launch(IO) {
            try {
                if (webSocketClient != null) {
                    Log.d(TAG,"sendWifiData: "+buffer.contentToString())
                    webSocketClient?.send(buffer)
                    Log.d(TAG,"NIBAV_WIFI_SEND --> "+buffer.contentToString())
                    AppSingleton.sendSocketQuery.postValue(buffer)
                } else {
                    AppSingleton.sendSocketQuery.postValue(null)
                    Log.d(TAG,"NIBAV_WIFI_SHAFT_SEND_FAILED --> SOCKET_CLOSED")
                    return@launch
                }
            } catch (e: Exception) {
                e.printStackTrace()
                currentStatus.invoke(WiFiServerStatus.NOT_CONNECTED)
                AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.SERVER_NOT_FOUND)
                Log.d(TAG,"NIBAV_WIFI_SHAFT_SEND_FAILED -->"+(e.message ?: ""))
                val value = getExceptionString(object{},e)
                saveExceptionsToFile(context,value)
                e.printStackTrace()
            }
        }
    }

    override fun updateCabinStatus(cabinStatus: ByteArray) {
        this.currentCabinStatus = cabinStatus
        //this.currentCabinStatus[5] = 100.toByte()
    }

    private suspend fun executeMethodAfterDelay(
        startVal1: Byte,
        startVal2: Byte,
        endVal1: Byte,
        endVal2: Byte,
        byteSize: Int,
        readData: ByteArray,
        onDataReceived: (ByteArray) -> Unit,
    ) {
        withContext(IO) {
            try {
                tempByte += readData
                if (tempByte.isNotEmpty() && tempByte[0] != startVal1) {
                    tempByte = ByteArray(0)
                    return@withContext
                }

                if (tempByte.size == byteSize &&
                    tempByte[1] == startVal2 &&
                    tempByte[byteSize - 1] == endVal2 &&
                    tempByte[byteSize - 2] == endVal1
                ) {
                    val tempData = tempByte
                    tempByte = ByteArray(0)
                    val newByteData = tempData.contentToString()
                    if (latestByteData != newByteData) {
                        val data = tempData.copyOfRange(2, byteSize - 3)
                        val checkSumVal = calculateHexSum(data)
                        if ((checkSumVal and 0xFF) == (tempData[byteSize - 3].toInt() and 0xFF)) {
                            latestByteData = newByteData
                            onDataReceived(tempData)
                        }
                    }
                } else if (tempByte.size > byteSize) {
                    tempByte = ByteArray(0)
                }
            } catch (e: Exception) {
                Log.e("ELITE_UART", "executeMethodAfterDelay error", e)
            }
        }
    }

    private fun calculateHexSum(hexValues: ByteArray): Int {
        var sum = 0x33
        for (i in 0 until hexValues.size - 1) {
            sum += hexValues[i]
        }
        return sum
    }


    override fun destroyWifiAccessory(bConfig: Boolean) {
        GlobalScope.launch(IO) {
            if (webSocketClient != null) {
                webSocketClient?.close(0, 0, "immediate")
            }
            currentStatus.invoke(WiFiServerStatus.NOT_CONNECTED)
        }
    }

}
