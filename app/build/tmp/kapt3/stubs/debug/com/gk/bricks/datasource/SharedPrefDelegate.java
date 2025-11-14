package com.gk.bricks.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H&\u00a8\u0006\r"}, d2 = {"Lcom/gk/bricks/datasource/SharedPrefDelegate;", "", "getWiFiIPAddress", "", "getWiFiPwd", "getWiFiSSID", "setWiFiIPAddress", "", "ipAddress", "setWiFiPwd", "pwd", "setWiFiSSID", "ssid", "app_debug"})
public abstract interface SharedPrefDelegate {
    
    public abstract void setWiFiSSID(@org.jetbrains.annotations.NotNull()
    java.lang.String ssid);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getWiFiSSID();
    
    public abstract void setWiFiPwd(@org.jetbrains.annotations.NotNull()
    java.lang.String pwd);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getWiFiPwd();
    
    public abstract void setWiFiIPAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String ipAddress);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getWiFiIPAddress();
}