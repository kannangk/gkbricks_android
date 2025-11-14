package com.gk.bricks.api

data class EmployeeAddRequest(
    val sessionToken: String,
    val companyName: String,
    val empId: String,
    val empName: String,
    val empSalary: Int,
    val empAdvance: Int,
    val empPhoto: String,
    val empSex: String,
    val workDate: String
)

data class EmployeePayRequest(
    val sessionToken: String,
    val companyName: String,
    val empId: String,
    val paidSalary: Int,
    val paidDate: String,
)

data class ChamberLoadingLogRequest(
    val sessionToken: String,
    val chamberId: String,
    val companyName: String,
    val bricksCount: Int,
    val paidAmount: Int,
    val paidDate: String
)

data class VendorPaymentRequest(
    val sessionToken: String,
    val vendorId: String,
    val companyName: String,
    val paidAmount: Int,
    val vendorType: String,
    val paidDate: String,
    val documentOne: String
)

data class VendorLoadLogRequest(
    val sessionToken: String,
    val vendorId: String,
    val companyName: String,
    val vendorType: String,
    val paidDate: String,
    val loadCount: Int,
    val loadAmount: Int,
    val loadName: String,
    val documentOne: String,
    val documentTwo: String,
    val documentThree: String,
)


data class CustomerLoadLogRequest(
    val sessionToken: String,
    val chamberId: String,
    val companyName: String,
    val customerId: String,
    val customerName: String,
    val bricksType: String,
    val paidDate: String,
    val bricksCount: Int,
    val paidAmount: Int,
    val documentOne: String,
    val documentTwo: String,
    val documentThree: String,
)

data class ApiResponse(
    val status: Boolean,
    val message: String
)

