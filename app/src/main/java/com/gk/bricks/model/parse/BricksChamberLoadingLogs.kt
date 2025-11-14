package com.gk.bricks.model.parse

import com.parse.ParseClassName
import com.parse.ParseObject
import java.util.Date

@ParseClassName("bricksChamberLoadingLogs")
class BricksChamberLoadingLogs : ParseObject() {
    companion object {
        val KEY_CHAMBER_ID: String = "chamberId"
        val KEY_COMPANY_NAME: String = "companyName"
        val KEY_PAID_DATE = "paidDate"
        val KEY_LOADED_BRICKS = "loadedBricks"
        val KEY_PAID_AMOUNT = "paidAmount"
        val KEY_UPDATE_FROM: String = "updateFrom"
    }


    var companyName: String
        get() = getString(KEY_COMPANY_NAME) ?: ""
        set(value) = put(KEY_COMPANY_NAME, value)

    var chamberId
        get() = getString(KEY_CHAMBER_ID) ?: ""
        set(value) = put(KEY_CHAMBER_ID, value)

    var paidDate
        get() = getDate(KEY_PAID_DATE) ?: Date()
        set(value) = put(KEY_PAID_DATE, value)

    var loadedBricks: Int
        get() = getInt(KEY_LOADED_BRICKS)
        set(value) = put(KEY_LOADED_BRICKS, value)

    var paidAmount: Int
        get() = getInt(KEY_PAID_AMOUNT)
        set(value) = put(KEY_PAID_AMOUNT, value)

    var updateFrom
        get() = getString(KEY_UPDATE_FROM) ?: ""
        set(value) = put(KEY_UPDATE_FROM, value)

    var totalPaidAmount = 0


}