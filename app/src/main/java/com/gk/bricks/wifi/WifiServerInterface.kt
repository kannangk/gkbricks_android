package com.gk.bricks.wifi

import com.gk.bricks.util.WiFiServerStatus


interface WifiServerInterface {

    fun listenToWifiConnection(status: (WiFiServerStatus) -> Unit)

    fun openWifiAccessory(
        onDataReceived: (ByteArray) -> Unit,
        onDataReceivedText: (String) -> Unit,
    )

    fun updateCabinStatus(cabinStatus: ByteArray)

    fun sendWifiData(buffer: ByteArray)

    fun destroyWifiAccessory(bConfig: Boolean)
}