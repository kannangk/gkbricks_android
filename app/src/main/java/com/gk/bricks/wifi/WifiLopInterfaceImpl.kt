package com.gk.bricks.wifi

import android.content.Context
import android.util.Log
import com.gk.bricks.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.*

class WifiLopInterfaceImpl(private val context: Context) : WifiLopInterface {

    private lateinit var isConnectedCallback: (Boolean) -> Unit
    private var receiveLopSocket: MulticastSocket? = null
    private var isReadEnabled = false

    private val readDataSize = 10
    private val lMsg = ByteArray(readDataSize)
    private val dp = DatagramPacket(lMsg, lMsg.size)
    private val group = InetAddress.getByName(Constants.WIFI_SERVER_DEFAULT_STATIC_IP)

    override suspend fun resumeWifiAccessory(isWifiServerConnected: (WiFiServerStatus) -> Unit) {
        withContext(Dispatchers.IO) {
            if (receiveLopSocket == null || receiveLopSocket?.isClosed == true) {
                openWifiAccessory(isWifiServerConnected)
            } else if (isReadEnabled) {
                isWifiServerConnected.invoke(WiFiServerStatus.ALREADY_CONNECTED)
                AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.CABIN_CONNECTED)
            } else {
                Log.d("NIBAV_WIFI_LOP", "Not Connected_resumeWifiAccessory")
                isWifiServerConnected.invoke(WiFiServerStatus.NOT_CONNECTED)
                AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.CABIN_NOT_FOUND)
            }
        }
    }

    override suspend fun openWifiAccessory(isWifiServerConnected: (WiFiServerStatus) -> Unit) {
        withContext(Dispatchers.IO) {
            try {
                isWifiServerConnected(WiFiServerStatus.DISCONNECTING)
                AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.CABIN_DIS_CONNECTING)
                isReadEnabled = false
                isConnectedCallback(false)
                closeConnection(receiveLopSocket)
                val socket = MulticastSocket(Constants.LOP_RECEIVE_PORT)
                socket.soTimeout = Constants.LOP_COMMUNICATION_TIMEOUT

                val networkInterface = getWifiNetworkInterface()
                if (networkInterface == null) {
                    Log.e("Multicast", "Network interface wlan0 not found")
                    isConnectedCallback(false)
                    isWifiServerConnected(WiFiServerStatus.NOT_CONNECTED)
                    AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.CABIN_NOT_FOUND)
                    return@withContext
                }

                socket.joinGroup(InetSocketAddress(group, Constants.LOP_RECEIVE_PORT), networkInterface)

                receiveLopSocket = socket
                isReadEnabled = true
                isConnectedCallback(true)
                isWifiServerConnected(WiFiServerStatus.CONNECTED)
                AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.CONNECTED)

            } catch (e: Exception) {
                Log.e("NIBAV_WIFI_INIT", "Exception: ${e.message}")
                val value = getExceptionString(object {}, e)
                saveExceptionsToFile(context, value)
                isConnectedCallback(false)
                isWifiServerConnected(WiFiServerStatus.NOT_CONNECTED)
                AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.CABIN_NOT_FOUND)
            }
        }
    }

    private fun getWifiNetworkInterface(): NetworkInterface? {
        try {
            val interfaces = NetworkInterface.getNetworkInterfaces()
            for (intf in interfaces) {
                if (!intf.isUp || intf.isLoopback || intf.isVirtual) continue

                val name = intf.name.lowercase()
                if (name.contains("wlan") || name.contains("wifi") || name.contains("eth")) {
                    Log.d("WIFI_INTERFACE", "Found network interface: $name")
                    return intf
                }
            }
        } catch (e: Exception) {
            Log.e("WIFI_INTERFACE", "Exception: ${e.message}")
        }
        return null
    }


    override fun listenToWifiConnection(isConnected: (Boolean) -> Unit) {
        this.isConnectedCallback = isConnected
    }

    override suspend fun startReadLopData(onDataReceived: (ByteArray) -> Unit) {
        withContext(Dispatchers.IO) {
            if (receiveLopSocket != null && !receiveLopSocket!!.isClosed) {
                readLopData(onDataReceived)
            }
        }
    }

    private suspend fun readLopData(onDataReceived: (ByteArray) -> Unit) =
        withContext(Dispatchers.IO) {
            try {
                while (isReadEnabled && receiveLopSocket != null && !receiveLopSocket!!.isClosed) {
                    try {
                        receiveLopSocket?.receive(dp)

                        val readData = dp.data.copyOfRange(dp.offset, dp.offset + dp.length)
                        Log.i("NIBAV_WIFI_LOP_Received", readData.contentToString())
                        onDataReceived(readData)
                    } catch (se: SocketException) {
                        Log.e("UDP_SOCKET", "SocketException: ${se.message}")
                        break
                    } catch (ioe: IOException) {
                        Log.e("UDP_RECEIVE", "IOException: ${ioe.message}")
                    }
                }
            } catch (e: Exception) {
                Log.e("NIBAV_WIFI_RECEIVE", "Exception: ${e.message}")
                val value = getExceptionString(object {}, e)
                saveExceptionsToFile(context, value)
            } finally {
                isReadEnabled = false
                isConnectedCallback(false)
                closeConnection(receiveLopSocket)
            }
        }

    override suspend fun destroyWifiAccessory(bConfig: Boolean) {
        withContext(Dispatchers.IO) {
            isReadEnabled = false
            closeConnection(receiveLopSocket)
            isConnectedCallback(false)
        }
    }

    private fun closeConnection(socket: MulticastSocket?) {
        try {
            socket?.let {
                if (!it.isClosed) {
                    try {
                        val networkInterface = NetworkInterface.getByName("wlan0")
                        it.leaveGroup(InetSocketAddress(group, Constants.LOP_RECEIVE_PORT), networkInterface)
                    } catch (e: Exception) {
                        Log.e("NIBAV_WIFI_LEAVEGROUP", "Error: ${e.message}")
                        val value = getExceptionString(object {}, e)
                        saveExceptionsToFile(context, value)
                    }
                    it.close()
                }
            }
        } catch (e: IOException) {
            Log.e("NIBAV_WIFI_CLOSE", "IOException: ${e.message}")
        }
    }
}
