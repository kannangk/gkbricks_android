package com.gk.bricks.util

object CabinSendConstants {
    private var sum = 0x33


    fun Int.sendCallBookingPacket(): ByteArray {
        val header = byteArrayOf(0xDE.toByte(), 0xED.toByte())
        val length = 0x03.toByte()
        val deviceId = 0x06.toByte()
        val commandId = 0x01.toByte()
        val data = (this + 1).toByte()
        val checksum = (0xDE + 0xED + length + deviceId + commandId + data + sum).toByte()
        val footer = byteArrayOf(0xAF.toByte(), 0xFE.toByte())
        return header + length + deviceId + commandId + data + checksum + footer
    }




}