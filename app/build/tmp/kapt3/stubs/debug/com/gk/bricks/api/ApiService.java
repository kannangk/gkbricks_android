package com.gk.bricks.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\nH\'J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\fH\'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u000eH\'J\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0010H\'J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/gk/bricks/api/ApiService;", "", "addCustomerLoadLog", "Lretrofit2/Call;", "Lcom/gk/bricks/api/ApiResponse;", "api_key", "", "request", "Lcom/gk/bricks/api/CustomerLoadLogRequest;", "addEmployee", "Lcom/gk/bricks/api/EmployeeAddRequest;", "paidChamberLoading", "Lcom/gk/bricks/api/ChamberLoadingLogRequest;", "paidSalary", "Lcom/gk/bricks/api/EmployeePayRequest;", "paidVendor", "Lcom/gk/bricks/api/VendorPaymentRequest;", "vendorLoadLog", "Lcom/gk/bricks/api/VendorLoadLogRequest;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "paidSalary")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<com.gk.bricks.api.ApiResponse> paidSalary(@retrofit2.http.Header(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String api_key, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.gk.bricks.api.EmployeePayRequest request);
    
    @retrofit2.http.POST(value = "paidChamberLoading")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<com.gk.bricks.api.ApiResponse> paidChamberLoading(@retrofit2.http.Header(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String api_key, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.gk.bricks.api.ChamberLoadingLogRequest request);
    
    @retrofit2.http.POST(value = "paidVendor")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<com.gk.bricks.api.ApiResponse> paidVendor(@retrofit2.http.Header(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String api_key, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.gk.bricks.api.VendorPaymentRequest request);
    
    @retrofit2.http.POST(value = "vendorLoadLog")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<com.gk.bricks.api.ApiResponse> vendorLoadLog(@retrofit2.http.Header(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String api_key, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.gk.bricks.api.VendorLoadLogRequest request);
    
    @retrofit2.http.POST(value = "addEmployee")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<com.gk.bricks.api.ApiResponse> addEmployee(@retrofit2.http.Header(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String api_key, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.gk.bricks.api.EmployeeAddRequest request);
    
    @retrofit2.http.POST(value = "addCustomerLoadLog")
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<com.gk.bricks.api.ApiResponse> addCustomerLoadLog(@retrofit2.http.Header(value = "api_key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String api_key, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.gk.bricks.api.CustomerLoadLogRequest request);
}