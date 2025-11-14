package com.gk.bricks.wifi;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH&J0\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\fH&\u00a8\u0006\u0013"}, d2 = {"Lcom/gk/bricks/wifi/WifiServerInterface;", "", "destroyWifiAccessory", "", "bConfig", "", "listenToWifiConnection", "status", "Lkotlin/Function1;", "Lcom/gk/bricks/util/WiFiServerStatus;", "openWifiAccessory", "onDataReceived", "", "onDataReceivedText", "", "sendWifiData", "buffer", "updateCabinStatus", "cabinStatus", "app_debug"})
public abstract interface WifiServerInterface {
    
    public abstract void listenToWifiConnection(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gk.bricks.util.WiFiServerStatus, kotlin.Unit> status);
    
    public abstract void openWifiAccessory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super byte[], kotlin.Unit> onDataReceived, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDataReceivedText);
    
    public abstract void updateCabinStatus(@org.jetbrains.annotations.NotNull()
    byte[] cabinStatus);
    
    public abstract void sendWifiData(@org.jetbrains.annotations.NotNull()
    byte[] buffer);
    
    public abstract void destroyWifiAccessory(boolean bConfig);
}