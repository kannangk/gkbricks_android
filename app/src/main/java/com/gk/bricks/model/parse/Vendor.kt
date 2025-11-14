package com.gk.bricks.model.parse

import com.parse.ParseClassName
import com.parse.ParseObject

@ParseClassName("vendors")
class Vendor : ParseObject() {
    companion object {
        val KEY_COMPANY_NAME: String = "companyName"
        val KEY_VENDOR_ID: String = "vendorId"
        val KEY_VENDOR_NAME = "vendorName"
        val KEY_VENDOR_BALANCE = "vendorBalance"
        val KEY_VENDOR_PHOTO = "vendorPhoto"
        val KEY_IS_BLOCKED = "isBlocked"
        val KEY_VENDOR_TYPE = "vendorType"
        val KEY_UPDATE_FROM: String = "updateFrom"
    }


    var companyName: String
        get() = getString(KEY_COMPANY_NAME) ?: ""
        set(value) = put(KEY_COMPANY_NAME, value)

    var vendorId
        get() = getString(KEY_VENDOR_ID) ?: ""
        set(value) = put(KEY_VENDOR_ID, value)

    var vendorName
        get() = getString(KEY_VENDOR_NAME) ?: ""
        set(value) = put(KEY_VENDOR_NAME, value)

    var vendorType
        get() = getString(KEY_VENDOR_TYPE) ?: ""
        set(value) = put(KEY_VENDOR_TYPE, value)

    var vendorPhoto: String
        get() = getString(KEY_VENDOR_PHOTO) ?: ""
        set(value) = put(KEY_VENDOR_PHOTO, value)

    var vendorBalance: Int
        get() = getInt(KEY_VENDOR_BALANCE)
        set(value) = put(KEY_VENDOR_BALANCE, value)

    var isBlocked: Boolean
        get() = getBoolean(KEY_IS_BLOCKED)
        set(value) = put(KEY_IS_BLOCKED, value)

    var updateFrom
        get() = getString(KEY_UPDATE_FROM) ?: ""
        set(value) = put(KEY_UPDATE_FROM, value)

    var isUpdated = true


}