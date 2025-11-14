package com.gk.bricks.wifi

import com.gk.bricks.util.WiFiServerStatus

interface WifiLopInterface {
    suspend fun resumeWifiAccessory(isWifiServerConnected: (WiFiServerStatus) -> Unit)

    suspend fun openWifiAccessory(isWifiServerConnected: (WiFiServerStatus) -> Unit)

    fun listenToWifiConnection(isConnected: (Boolean) -> Unit)

    suspend fun startReadLopData(onDataReceived: (ByteArray) -> Unit)

    suspend fun destroyWifiAccessory(bConfig: Boolean)
}