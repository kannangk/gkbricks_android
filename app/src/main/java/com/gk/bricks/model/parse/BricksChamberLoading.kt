package com.gk.bricks.model.parse

import com.parse.ParseClassName
import com.parse.ParseObject
import java.util.Date

@ParseClassName("bricksChamberLoading")
class BricksChamberLoading: ParseObject() {
    companion object {
        val KEY_CHAMBER_ID: String = "chamberId"
        val KEY_COMPANY_NAME: String = "companyName"
        val KEY_CHAMBER_CREATE_DATE = "chamberCreateDate"
        val KEY_TOTAL_BRICKS = "totalBricks"
        val KEY_TOTAL_SURUKKI = "totalSurukki"
        val KEY_TOTAL_PAID_AMOUNT = "totalPaidAmount"
        val KEY_TOTAL_RECEIVED_AMOUNT = "totalReceivedAmount"
        val KEY_TOTAL_TAKEN_BRICKS = "totalTakenBricks"
        val KEY_IS_COMPLETED = "isCompleted"
        val KEY_UPDATE_FROM: String = "updateFrom"
    }


    var companyName: String
        get() = getString(KEY_COMPANY_NAME) ?: ""
        set(value) = put(KEY_COMPANY_NAME, value)

    var chamberId
        get() = getString(KEY_CHAMBER_ID) ?: ""
        set(value) = put(KEY_CHAMBER_ID, value)

    var chamberCreateDate
        get() = getDate(KEY_CHAMBER_CREATE_DATE) ?: Date()
        set(value) = put(KEY_CHAMBER_CREATE_DATE, value)

    var totalBricks: Int
        get() = getInt(KEY_TOTAL_BRICKS)
        set(value) = put(KEY_TOTAL_BRICKS, value)

     var totalSurukki: Int
        get() = getInt(KEY_TOTAL_SURUKKI)
        set(value) = put(KEY_TOTAL_SURUKKI, value)

    var totalPaidAmount: Int
        get() = getInt(KEY_TOTAL_PAID_AMOUNT)
        set(value) = put(KEY_TOTAL_PAID_AMOUNT, value)

     var totalReceivedAmount: Int
        get() = getInt(KEY_TOTAL_RECEIVED_AMOUNT)
        set(value) = put(KEY_TOTAL_RECEIVED_AMOUNT, value)

     var totalTakenBricks: Int
        get() = getInt(KEY_TOTAL_TAKEN_BRICKS)
        set(value) = put(KEY_TOTAL_TAKEN_BRICKS, value)

    var isCompleted: Boolean
        get() = getBoolean(KEY_IS_COMPLETED)
        set(value) = put(KEY_IS_COMPLETED, value)

    var updateFrom
        get() = getString(KEY_UPDATE_FROM) ?: ""
        set(value) = put(KEY_UPDATE_FROM, value)

}