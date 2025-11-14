package com.gk.bricks.wifi

interface WifiServerDataListener {
    fun onReceivedData(byteArray: ByteArray)
}