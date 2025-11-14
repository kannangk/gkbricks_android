package com.gk.bricks.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/gk/bricks/datasource/SharedPrefDelegateImpl;", "Lcom/gk/bricks/datasource/SharedPrefDelegate;", "authSharedPrefs", "Lcom/gk/bricks/datasource/SharedPreferenceUtils;", "(Lcom/gk/bricks/datasource/SharedPreferenceUtils;)V", "gson", "Lcom/google/gson/Gson;", "getWiFiIPAddress", "", "getWiFiPwd", "getWiFiSSID", "setWiFiIPAddress", "", "ipAddress", "setWiFiPwd", "pwd", "setWiFiSSID", "ssid", "Companion", "app_debug"})
public final class SharedPrefDelegateImpl implements com.gk.bricks.datasource.SharedPrefDelegate {
    @org.jetbrains.annotations.NotNull()
    private final com.gk.bricks.datasource.SharedPreferenceUtils authSharedPrefs = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String WIFI_IP_ADDRESS = "wifi_ip_address";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String REQUIRED_WIFI_SSID = "required_wifi_ssid";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String REQUIRED_WIFI_PWD = "required_wifi_pwd";
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.datasource.SharedPrefDelegateImpl.Companion Companion = null;
    
    public SharedPrefDelegateImpl(@org.jetbrains.annotations.NotNull()
    com.gk.bricks.datasource.SharedPreferenceUtils authSharedPrefs) {
        super();
    }
    
    @java.lang.Override()
    public void setWiFiSSID(@org.jetbrains.annotations.NotNull()
    java.lang.String ssid) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getWiFiSSID() {
        return null;
    }
    
    @java.lang.Override()
    public void setWiFiPwd(@org.jetbrains.annotations.NotNull()
    java.lang.String pwd) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getWiFiPwd() {
        return null;
    }
    
    @java.lang.Override()
    public void setWiFiIPAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String ipAddress) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getWiFiIPAddress() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/gk/bricks/datasource/SharedPrefDelegateImpl$Companion;", "", "()V", "REQUIRED_WIFI_PWD", "", "REQUIRED_WIFI_SSID", "WIFI_IP_ADDRESS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}