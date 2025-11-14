package com.gk.bricks.datasource

interface SharedPrefDelegate {

    fun setWiFiSSID(ssid: String)

    fun getWiFiSSID(): String

    fun setWiFiPwd(pwd: String)

    fun getWiFiPwd(): String

    fun setWiFiIPAddress(ipAddress: String)

    fun getWiFiIPAddress(): String
}