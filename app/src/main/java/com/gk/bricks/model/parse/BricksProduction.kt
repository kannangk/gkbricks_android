package com.gk.bricks.model.parse

import com.parse.ParseClassName
import com.parse.ParseObject
import java.util.Date

@ParseClassName("bricksProduction")
class BricksProduction : ParseObject() {
    companion object {
        val KEY_COMPANY_NAME: String = "companyName"
        val KEY_WORKING_DATE = "workingDate"
        val KEY_TOTAL_PRODUCTION = "totalProduction"
        val KEY_UPDATE_FROM: String = "updateFrom"
    }


    var companyName: String
        get() = getString(KEY_COMPANY_NAME) ?: ""
        set(value) = put(KEY_COMPANY_NAME, value)

    var workingDate
        get() = getDate(KEY_WORKING_DATE) ?: Date()
        set(value) = put(KEY_WORKING_DATE, value)

    var totalProduction: Int
        get() = getInt(KEY_TOTAL_PRODUCTION)
        set(value) = put(KEY_TOTAL_PRODUCTION, value)

    var updateFrom
        get() = getString(KEY_UPDATE_FROM) ?: ""
        set(value) = put(KEY_UPDATE_FROM, value)

}