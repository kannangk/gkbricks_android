package com.gk.bricks.util

import android.util.Log
import java.net.Inet4Address
import java.net.NetworkInterface

class WifiConnectionData {

    companion object{

        var CABIN_IP = "192.168.1.100"



        fun getCabinLocalIp(): String {
            return "http://$CABIN_IP:5050/"
        }


        fun getCabinWebSocketUrl(): String {
            return "ws://$CABIN_IP:5050/ws"
        }



        fun getCabinIp(): String {
            return CABIN_IP
        }

        private fun getIpv4HostAddress(): String {
            try {
                val interfaces = NetworkInterface.getNetworkInterfaces()
                while (interfaces.hasMoreElements()) {
                    val networkInterface = interfaces.nextElement()
                    if (!networkInterface.isLoopback && networkInterface.isUp) {
                        val addresses = networkInterface.inetAddresses
                        while (addresses.hasMoreElements()) {
                            val address = addresses.nextElement()
                            if (!address.isLoopbackAddress && address is Inet4Address) {
                                val ip = address.hostAddress
                                if (ip.startsWith("192.") || ip.startsWith("10.")) {
                                    Log.d("getIpv4HostAddress", "Wi-Fi IP found: $ip")
                                    return ip.substringBeforeLast(".") // Return subnet part only
                                }
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("getIpv4HostAddress", "Error: ${e.message}")
            }
            return "192.168.1" // Default fallback
        }



    }



}