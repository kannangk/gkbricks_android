package com.gk.bricks.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("paidSalary")
    fun paidSalary(
        @Header("api_key") api_key: String,
        @Body request: EmployeePayRequest
    ): Call<ApiResponse>

    @POST("paidChamberLoading")
    fun paidChamberLoading(
        @Header("api_key") api_key: String,
        @Body request: ChamberLoadingLogRequest
    ): Call<ApiResponse>

    @POST("paidVendor")
    fun paidVendor(
        @Header("api_key") api_key: String,
        @Body request: VendorPaymentRequest
    ): Call<ApiResponse>

    @POST("vendorLoadLog")
    fun vendorLoadLog(
        @Header("api_key") api_key: String,
        @Body request: VendorLoadLogRequest
    ): Call<ApiResponse>

    @POST("addEmployee")
    fun addEmployee(
        @Header("api_key") api_key: String,
        @Body request: EmployeeAddRequest
    ): Call<ApiResponse>
}
