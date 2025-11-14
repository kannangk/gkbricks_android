package com.gk.bricks.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gk.bricks.ProductionMainActivity
import com.gk.bricks.datasource.SharedPrefDelegate
import com.gk.bricks.datasource.firebase.FirebaseInterface
import com.gk.bricks.managers.HotspotManager
import com.gk.bricks.util.AppSingleton
import com.gk.bricks.util.AppSingleton.isWifiCabinStatus
import com.gk.bricks.util.AppSingleton.isWifiServerStatus
import com.gk.bricks.util.AppSingleton.lopReceivedData
import com.gk.bricks.util.AppSingleton.socketReceivedData
import com.gk.bricks.util.Constants
import com.gk.bricks.util.Constants.LOCAL_IP_REACHABLE_TIME
import com.gk.bricks.util.WiFiServerStatus
import com.gk.bricks.util.WifiConnectionData
import com.gk.bricks.util.getExceptionString
import com.gk.bricks.util.saveExceptionsToFile
import com.gk.bricks.wifi.WifiLopInterface
import com.gk.bricks.wifi.WifiServerInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.InetAddress
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val app: Application,
    private val wifiServerInterface: WifiServerInterface,
    private val firebaseDatabase: FirebaseInterface,
    private val wifiLopInterface: WifiLopInterface,
    private val dataSource: SharedPrefDelegate,
    private val hotspotManager: HotspotManager
) : BaseViewModel(app) {

    companion object {
        const val TAG = "MainViewModel"
    }

    var isAllPermissionsGranted = MutableLiveData<Boolean>()
    private val cabinReceivedData = MutableLiveData<ByteArray>()
    private val cabinReceivedText = MutableLiveData<String>()
    private var isReadingCabinData: Boolean = false


    fun enableHotspot(context: ProductionMainActivity) {
        Log.d(TAG, "enableHotspot: ${isHotspotEnabled()}")
        if (!isHotspotEnabled()) {
            hotspotManager.enableHotspot(context)
            startHotspotRunnable()
        }
    }

    fun disableHotspot(context: ProductionMainActivity) {
        Log.d(TAG, "enableHotspot: ${isHotspotEnabled()}")
        if (isHotspotEnabled()) {
            hotspotManager.disableHotspot(context)
        }
    }

    fun hotspotManager(): HotspotManager {
        return hotspotManager
    }

    fun isHotspotEnabled(): Boolean {
        return hotspotManager.isHotspotEnabled()
    }

    fun listenToWifiServerConnection() {
        wifiServerInterface.listenToWifiConnection {
            Log.d(TAG, "wifiServerInterface: $it")
            isWifiServerStatus.postValue(it)
        }
    }

    fun startHotspotRunnable() {
        hotspotManager.startHotspotRunnable()
    }

    fun removeHotspotRunnable() {
        hotspotManager.removeHotspotRunnable()
    }

    fun isHotspotHandlerRunning(): Boolean {
        return hotspotManager.isHotspotHandlerRunning()
    }


    fun readDataFromCabin() {
        GlobalScope.launch(IO) {
            try {
                AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.SERVER_CONNECTING)
                val ipAddress = InetAddress.getByName(WifiConnectionData.getCabinIp())
                Log.d(TAG, "NIBAV_WIFI_SHAFT_IP: $ipAddress")
                val isReachable = ipAddress.isReachable(LOCAL_IP_REACHABLE_TIME)
                if (isReachable) {
                    Log.d(TAG, "NIBAV_WIFI_SHAFT_IP available")
                    wifiServerInterface.openWifiAccessory({ dataBytes ->
                        socketReceivedData.postValue(dataBytes)
                    }, { dataText ->
                        cabinReceivedText.postValue(dataText)
                    })
                } else {
                    Log.d(TAG, "NIBAV_WIFI_SHAFT_IP not reachable")
                    isWifiServerStatus.postValue(WiFiServerStatus.NOT_REACHABLE)
                }
            } catch (e: IOException) {
                Log.d(TAG, "NIBAV_WIFI_SHAFT_IP Connect Error: ${e.message}")
                val value = getExceptionString(object {}, e)
                saveExceptionsToFile(app.baseContext, value)
                e.printStackTrace()
                isWifiServerStatus.postValue(WiFiServerStatus.NOT_REACHABLE)
            }
        }
    }

    fun listenToWifiLopConnection(isConnected: (Boolean) -> Unit) {
        wifiLopInterface.listenToWifiConnection { isConnected ->
            Log.d("wifiLop-Interface", "WiFi Connection State: $isConnected")
            isConnected(isConnected)
        }
    }

    fun openWifiAccessory(cabinStatus: (WiFiServerStatus) -> Unit) {
        viewModelScope.launch {
            AppSingleton.wifiConnectionStatus.postValue(WiFiServerStatus.CABIN_CONNECTING)
            try {
                wifiLopInterface.openWifiAccessory { status ->
                    isWifiCabinStatus.postValue(status)
                    Log.d("wifiLop-Interface", "WiFi Server Status: $status")
                    cabinStatus(status)
                }
            } catch (e: Exception) {
                Log.d(TAG, "openWifiAccessory: catch Exception ${e.message}")
            }

        }
    }

    fun startReadLopData(isReading: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            wifiLopInterface.startReadLopData { data ->
                val hexString = data.joinToString(" ") { byte -> "0x%02X".format(byte) }
                Log.d("wifiLop-Interface", "startReadLopData: $hexString")
                if (data.size == Constants.UDB_RECEIVER_BYTE && data[0] == Constants.LOP_RECEIVE_VAL) {
                    if (data[1].toInt() == 2) {
                        Log.d("wifiLop-Interface", "startReadLopData: true")
                        lopReceivedData.postValue(data)
                        isReading(true, hexString)
                        isReadingCabinData = true
                        WifiConnectionData.CABIN_IP =
                            "${data[2].toInt() and 0xff}.${data[3].toInt() and 0xff}.${data[4].toInt() and 0xff}.${data[5].toInt() and 0xff}"
                    } else {
                        isReading(false, null)
                    }
                } else {
                    isReading(false, null)
                }
            }
        }
    }

    fun destroyWifiAccessory() {
        viewModelScope.launch {
            wifiLopInterface.destroyWifiAccessory(true)
        }
    }


}