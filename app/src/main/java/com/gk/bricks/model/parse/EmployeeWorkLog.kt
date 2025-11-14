package com.gk.bricks.model.parse

import com.parse.ParseClassName
import com.parse.ParseObject
import java.util.Date

@ParseClassName("employeeWorkLog")
class EmployeeWorkLog : ParseObject() {
    companion object {
        val KEY_COMPANY_NAME: String = "companyName"
        val KEY_EMP_ID: String = "empId"
        val KEY_EMP_SALARY = "empSalary"
        val KEY_WORK_DATE = "workingDate"
        val KEY_EMP_NAME = "empName"
        val KEY_IS_PAID = "isPaid"
        val KEY_IS_PAYABLE = "isPayable"
        val KEY_TOTAL_PAID_AMOUNT = "totalPaidAmount"
        val KEY_PREVIOUS_ADVANCE_AMOUNT = "previousAdvanceAmount"
        val KEY_AFTER_ADVANCE_AMOUNT = "afterAdvanceAmount"
        val KEY_TOTAL_WORKING_SALARY = "totalWorkingSalary"
        val KEY_UPDATE_FROM: String = "updateFrom"
    }


    var companyName: String
        get() = getString(KEY_COMPANY_NAME) ?: ""
        set(value) = put(KEY_COMPANY_NAME, value)

    var empId
        get() = getString(KEY_EMP_ID) ?: ""
        set(value) = put(KEY_EMP_ID, value)

    var workDate
        get() = getDate(KEY_WORK_DATE) ?: Date()
        set(value) = put(KEY_WORK_DATE, value)

    var empSalary: Int
        get() = getInt(KEY_EMP_SALARY)
        set(value) = put(KEY_EMP_SALARY, value)

    var previousAdvanceAmount: Int
        get() = getInt(KEY_PREVIOUS_ADVANCE_AMOUNT)
        set(value) = put(KEY_PREVIOUS_ADVANCE_AMOUNT, value)

    var afterAdvanceAmount: Int
        get() = getInt(KEY_AFTER_ADVANCE_AMOUNT)
        set(value) = put(KEY_AFTER_ADVANCE_AMOUNT, value)

    var totalWorkingSalary: Int
        get() = getInt(KEY_TOTAL_WORKING_SALARY)
        set(value) = put(KEY_TOTAL_WORKING_SALARY, value)

    var totalPaidAmount: Int
        get() = getInt(KEY_TOTAL_PAID_AMOUNT)
        set(value) = put(KEY_TOTAL_PAID_AMOUNT, value)

    var empName
        get() = getString(KEY_EMP_NAME) ?: ""
        set(value) = put(KEY_EMP_NAME, value)

    var isPaid: Boolean
        get() = getBoolean(KEY_IS_PAID)
        set(value) = put(KEY_IS_PAID, value)

    var isPayable: Boolean
        get() = getBoolean(KEY_IS_PAYABLE)
        set(value) = put(KEY_IS_PAYABLE, value)

    var updateFrom
        get() = getString(KEY_UPDATE_FROM) ?: ""
        set(value) = put(KEY_UPDATE_FROM, value)

    var totalAmount = 0


}