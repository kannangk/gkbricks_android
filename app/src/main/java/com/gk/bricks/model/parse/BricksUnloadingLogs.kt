package com.gk.bricks.model.parse

import com.parse.ParseClassName
import com.parse.ParseObject
import java.util.Date

@ParseClassName("bricksUnloadingLogs")
class BricksUnloadingLogs : ParseObject() {
    companion object {
        val KEY_COMPANY_NAME: String = "companyName"
        val KEY_CHAMBER_ID: String = "chamberId"
        val KEY_WORK_DATE = "workingDate"
        val KEY_CUSTOMER_ID: String = "customerId"
        val KEY_CUSTOMER_NAME: String = "customerName"
        val KEY_BRICKS_COUNT = "bricksCount"
        val KEY_BRICKS_TYPE = "bricksType"
        val KEY_DOCUMENT_ONE = "documentOne"
        val KEY_DOCUMENT_TWO = "documentTwo"
        val KEY_DOCUMENT_THREE = "documentThree"
        val KEY_IS_PAID = "isPaid"
        val KEY_PAID_AMOUNT = "paidAmount"
        val KEY_UPDATE_FROM: String = "updateFrom"
    }


    var companyName: String
        get() = getString(KEY_COMPANY_NAME) ?: ""
        set(value) = put(KEY_COMPANY_NAME, value)

    var chamberId
        get() = getString(KEY_CHAMBER_ID) ?: ""
        set(value) = put(KEY_CHAMBER_ID, value)

    var workDate
        get() = getDate(KEY_WORK_DATE) ?: Date()
        set(value) = put(KEY_WORK_DATE, value)

    var bricksCount: Int
        get() = getInt(KEY_BRICKS_COUNT)
        set(value) = put(KEY_BRICKS_COUNT, value)

    var bricksType
        get() = getString(KEY_BRICKS_TYPE) ?: ""
        set(value) = put(KEY_BRICKS_TYPE, value)

    var customerId
        get() = getString(KEY_CUSTOMER_ID) ?: ""
        set(value) = put(KEY_CUSTOMER_ID, value)

    var customerName
        get() = getString(KEY_CUSTOMER_NAME) ?: ""
        set(value) = put(KEY_CUSTOMER_NAME, value)


    var documentOne
        get() = getString(KEY_DOCUMENT_ONE) ?: ""
        set(value) = put(KEY_DOCUMENT_ONE, value)

    var documentTwo
        get() = getString(KEY_DOCUMENT_TWO) ?: ""
        set(value) = put(KEY_DOCUMENT_TWO, value)

    var documentThree
        get() = getString(KEY_DOCUMENT_THREE) ?: ""
        set(value) = put(KEY_DOCUMENT_THREE, value)

    var paidAmount: Int
        get() = getInt(KEY_PAID_AMOUNT)
        set(value) = put(KEY_PAID_AMOUNT, value)


    var isPaid: Boolean
        get() = getBoolean(KEY_IS_PAID)
        set(value) = put(KEY_IS_PAID, value)

    var updateFrom
        get() = getString(KEY_UPDATE_FROM) ?: ""
        set(value) = put(KEY_UPDATE_FROM, value)

    var totalAmount = 0


}