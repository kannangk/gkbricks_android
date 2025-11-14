package com.gk.bricks.model.parse

import com.parse.ParseClassName
import com.parse.ParseObject
import org.json.JSONObject

@ParseClassName("employee")
class Employee : ParseObject() {
    companion object {
        val KEY_COMPANY_NAME: String = "companyName"
        val KEY_EMP_ID: String = "empId"
        val KEY_EMP_NAME = "empName"
        val KEY_EMP_SEX = "empSex"
        val KEY_EMP_SALARY = "empSalary"
        val KEY_EMP_ADVANCE = "empAdvance"
        val KEY_EMP_PHOTO = "empPhoto"
        val KEY_IS_BLOCKED = "isBlocked"
        val KEY_UPDATE_FROM: String = "updateFrom"
    }


    var companyName: String
        get() = getString(KEY_COMPANY_NAME) ?: ""
        set(value) = put(KEY_COMPANY_NAME, value)

    var empId
        get() = getString(KEY_EMP_ID) ?: ""
        set(value) = put(KEY_EMP_ID, value)

    var empName
        get() = getString(KEY_EMP_NAME) ?: ""
        set(value) = put(KEY_EMP_NAME, value)

    var empSex: String
        get() = getString(KEY_EMP_SEX) ?: ""
        set(value) = put(KEY_EMP_SEX, value)

    var empPhoto: String
        get() = getString(KEY_EMP_PHOTO) ?: ""
        set(value) = put(KEY_EMP_PHOTO, value)

    var empSalary: Int
        get() = getInt(KEY_EMP_SALARY)
        set(value) = put(KEY_EMP_SALARY, value)

    var empAdvance: Int
        get() = getInt(KEY_EMP_ADVANCE)
        set(value) = put(KEY_EMP_ADVANCE, value)

    var isBlocked: Boolean
        get() = getBoolean(KEY_IS_BLOCKED)
        set(value) = put(KEY_IS_BLOCKED, value)

    var updateFrom
        get() = getString(KEY_UPDATE_FROM) ?: ""
        set(value) = put(KEY_UPDATE_FROM, value)

    var isUpdated = true

    fun parseEmployeeFromJson(jsonString: String): Employee {
        val json = JSONObject(jsonString)
        val employee = Employee()

        employee.companyName = json.optString(KEY_COMPANY_NAME, "")
        employee.empId = json.optString(KEY_EMP_ID, "")
        employee.empName = json.optString(KEY_EMP_NAME, "")
        employee.empSex = json.optString(KEY_EMP_SEX, "")
        employee.empPhoto = json.optString(KEY_EMP_PHOTO, "")
        employee.empSalary = json.optInt(KEY_EMP_SALARY, 0)
        employee.empAdvance = json.optInt(KEY_EMP_ADVANCE, 0)
        employee.updateFrom = json.optString(KEY_UPDATE_FROM, "")

        return employee
    }

}