package com.gk.bricks.datasource

import com.google.gson.Gson
import com.gk.bricks.util.Constants.WIFI_SERVER_DEFAULT_STATIC_IP

class SharedPrefDelegateImpl(private val authSharedPrefs: SharedPreferenceUtils) :
    SharedPrefDelegate {
    private val gson = Gson()

    companion object {
        private const val WIFI_IP_ADDRESS = "wifi_ip_address"
        private const val REQUIRED_WIFI_SSID = "required_wifi_ssid"
        private const val REQUIRED_WIFI_PWD = "required_wifi_pwd"
    }

    override fun setWiFiSSID(ssid: String) {
        authSharedPrefs.saveString(REQUIRED_WIFI_SSID, ssid)
    }

    override fun getWiFiSSID(): String {
        return authSharedPrefs.getString(REQUIRED_WIFI_SSID, "TP_LINK_RND_LIFT")
    }

    override fun setWiFiPwd(pwd: String) {
        authSharedPrefs.saveString(REQUIRED_WIFI_PWD, pwd)
    }

    override fun getWiFiPwd(): String {
        return authSharedPrefs.getString(REQUIRED_WIFI_PWD, "84785879")
    }

    override fun setWiFiIPAddress(ipAddress: String) {
        authSharedPrefs.saveString(WIFI_IP_ADDRESS, ipAddress)
    }

    override fun getWiFiIPAddress(): String {
        return authSharedPrefs.getString(WIFI_IP_ADDRESS, WIFI_SERVER_DEFAULT_STATIC_IP)
    }


}