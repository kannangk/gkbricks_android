package com.gk.bricks.model.parse

import com.parse.ParseClassName
import com.parse.ParseObject
import java.util.Date

@ParseClassName("vendorPaidLog")
class VendorPaidLog : ParseObject() {
    companion object {
        val KEY_COMPANY_NAME: String = "companyName"
        val KEY_VENDOR_ID: String = "vendorId"
        val KEY_WORK_DATE = "workingDate"
        val KEY_TOTAL_LOAD_AMOUNT = "totalLoadAmount"
        val KEY_LOAD_COUNT = "loadCount"
        val KEY_VENDOR_TYPE = "vendorType"
        val KEY_LOAD_NAME = "loadName"
        val KEY_DOCUMENT_ONE = "documentOne"
        val KEY_DOCUMENT_TWO = "documentTwo"
        val KEY_DOCUMENT_THREE = "documentThree"
        val KEY_IS_PAID = "isPaid"
        val KEY_PAID_AMOUNT = "paidAmount"
        val KEY_PREVIOUS_REMAINING_AMOUNT = "previousRemainingAmount"
        val KEY_AFTER_REMAINING_AMOUNT = "afterRemainingAmount"
        val KEY_UPDATE_FROM: String = "updateFrom"
    }


    var companyName: String
        get() = getString(KEY_COMPANY_NAME) ?: ""
        set(value) = put(KEY_COMPANY_NAME, value)

    var vendorId
        get() = getString(KEY_VENDOR_ID) ?: ""
        set(value) = put(KEY_VENDOR_ID, value)

    var workDate
        get() = getDate(KEY_WORK_DATE) ?: Date()
        set(value) = put(KEY_WORK_DATE, value)

    var totalLoadAmount: Int
        get() = getInt(KEY_TOTAL_LOAD_AMOUNT)
        set(value) = put(KEY_TOTAL_LOAD_AMOUNT, value)

    var loadCount: Int
        get() = getInt(KEY_LOAD_COUNT)
        set(value) = put(KEY_LOAD_COUNT, value)

    var vendorType
        get() = getString(KEY_VENDOR_TYPE) ?: ""
        set(value) = put(KEY_VENDOR_TYPE, value)

     var loadName
        get() = getString(KEY_LOAD_NAME) ?: ""
        set(value) = put(KEY_LOAD_NAME, value)


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

     var previousRemainingAmount: Int
        get() = getInt(KEY_PREVIOUS_REMAINING_AMOUNT)
        set(value) = put(KEY_PREVIOUS_REMAINING_AMOUNT, value)

    var afterRemainingAmount: Int
        get() = getInt(KEY_AFTER_REMAINING_AMOUNT)
        set(value) = put(KEY_AFTER_REMAINING_AMOUNT, value)

    var isPaid: Boolean
        get() = getBoolean(KEY_IS_PAID)
        set(value) = put(KEY_IS_PAID, value)

    var updateFrom
        get() = getString(KEY_UPDATE_FROM) ?: ""
        set(value) = put(KEY_UPDATE_FROM, value)

    var totalAmount = 0


}