package com.gk.bricks.wifi;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\tH&J\"\u0010\n\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\tH\u00a6@\u00a2\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\tH\u00a6@\u00a2\u0006\u0002\u0010\rJ\"\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\tH\u00a6@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/gk/bricks/wifi/WifiLopInterface;", "", "destroyWifiAccessory", "", "bConfig", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listenToWifiConnection", "isConnected", "Lkotlin/Function1;", "openWifiAccessory", "isWifiServerConnected", "Lcom/gk/bricks/util/WiFiServerStatus;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeWifiAccessory", "startReadLopData", "onDataReceived", "", "app_debug"})
public abstract interface WifiLopInterface {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object resumeWifiAccessory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gk.bricks.util.WiFiServerStatus, kotlin.Unit> isWifiServerConnected, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object openWifiAccessory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gk.bricks.util.WiFiServerStatus, kotlin.Unit> isWifiServerConnected, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    public abstract void listenToWifiConnection(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> isConnected);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object startReadLopData(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super byte[], kotlin.Unit> onDataReceived, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object destroyWifiAccessory(boolean bConfig, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}