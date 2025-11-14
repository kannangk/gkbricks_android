package com.gk.bricks.util

object Constants {
    const val BATTERY_CHARGING = "charging"
    const val BATTERY_NOT_CHARGING = "not_charging"
    const val ACTION_CONNECTIVITY_STATE_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE"
    const val WIFI_AP_STATE_CHANGED = "android.net.wifi.WIFI_AP_STATE_CHANGED"
    const val NETWORK_CONNECTED = "network_connected"
    const val NETWORK_DISCONNECTED = "network_disconnected"
    const val VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION"
    const val ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED"
    const val DATE_CHANGE = "date_changed"
    const val TIME_TICKING = "time_ticking"
    const val WIFI_STATE_CHANGE = "wifi_state_change"
    const val S3_BUCKET_URL = "https://gkbricks.s3.ap-south-1.amazonaws.com/"
    const val API_URL = "https://gkbricks.com/api/"
    const val EMP_PROFILE_S3_PATH = "employee/profile/"
    const val VENDOR_PROFILE_S3_PATH = "vendor/profile/";
    const val VENDOR_DOC_S3_PATH = "vendor/documents/";
    const val COMPANY_NAME = "gkbricks_pkm"
    const val UPDATE_FROM = "system"
    const val VENDOR_FIRE_WOOD_TYPE = "FIRE_WOOD"


    val REQUEST_RESET: ByteArray =
        byteArrayOf(0xDE.toByte(), 0x05, 0x01, 0x00, 0x00, 0x00, 0xED.toByte())
    const val SHAFT_RECEIVE_END_VAL: Byte = 0xA5.toByte()
    const val SHAFT_RECEIVE_START_VAL: Byte = 0x5A.toByte()
    const val WEB_SOCKET_CONNECTION_TIME_OUT: Long = 10000L
    const val WEB_SOCKET_READ_TIME_OUT: Int = 3500

    const val WIFI_SERVER_DEFAULT_STATIC_IP: String = "239.1.2.3"
    const val LOP_SEND_PORT: Int = 2020
    const val LOP_RECEIVE_PORT: Int = 2323
    const val LOP_COMMUNICATION_TIMEOUT: Int = 15000
    const val LOP_RECEIVE_VAL: Byte = 0xDE.toByte()
    const val UDB_RECEIVER_BYTE: Int = 10
    const val RECEIVE_IP: Byte = 0x02.toByte()
    const val WIFI_LOP_RECONNECT_DELAY: Long = 5000L
    const val LOCAL_IP_REACHABLE_TIME: Int = 1000

    val FloorList = arrayListOf(
        FloorData(
            floor = "G", floorNum = 0
        ),
        FloorData(
            floor = "1", floorNum = 1
        ),
        FloorData(
            floor = "2", floorNum = 2
        ),
        FloorData(
            floor = "3", floorNum = 3
        ),
        FloorData(
            floor = "4", floorNum = 4
        ),
    )

    data class FloorData(
        val floor: String,
        val floorNum: Int,
        val nextSelectedFloorNum: Int? = null,
        var currentFloor: Int = 0,
    )
}