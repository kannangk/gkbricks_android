package com.gk.bricks.util

import androidx.lifecycle.MutableLiveData

object AppSingleton {

    val sendSocketQuery = MutableLiveData<ByteArray>()
    val wifiConnectionStatus = MutableLiveData<WiFiServerStatus>()
    val onBatteryCharging = MutableLiveData<Int?>()
    val onTickTime = MutableLiveData(false)
    val isHotspotEnable = MutableLiveData(false)
    val onBatteryChargingStop = MutableLiveData<Int?>()
    val isWifiServerStatus = MutableLiveData(WiFiServerStatus.NOT_CONNECTED)
    val isWifiCabinStatus = MutableLiveData(WiFiServerStatus.NOT_CONNECTED)
    val lopReceivedData = MutableLiveData<ByteArray>()
    val socketReceivedData = MutableLiveData<ByteArray>()
    val simSignalStrength = MutableLiveData<Int?>()
}

