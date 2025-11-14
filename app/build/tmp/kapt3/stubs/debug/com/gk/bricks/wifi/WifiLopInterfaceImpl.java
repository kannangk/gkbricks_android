package com.gk.bricks.wifi;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002J\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u001c\u0010\u001c\u001a\u00020\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J\"\u0010\u001e\u001a\u00020\r2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r0\u000bH\u0096@\u00a2\u0006\u0002\u0010!J\"\u0010\"\u001a\u00020\r2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000bH\u0082@\u00a2\u0006\u0002\u0010!J\"\u0010$\u001a\u00020\r2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r0\u000bH\u0096@\u00a2\u0006\u0002\u0010!J\"\u0010%\u001a\u00020\r2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000bH\u0096@\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/gk/bricks/wifi/WifiLopInterfaceImpl;", "Lcom/gk/bricks/wifi/WifiLopInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dp", "Ljava/net/DatagramPacket;", "group", "Ljava/net/InetAddress;", "kotlin.jvm.PlatformType", "isConnectedCallback", "Lkotlin/Function1;", "", "", "isReadEnabled", "lMsg", "", "readDataSize", "", "receiveLopSocket", "Ljava/net/MulticastSocket;", "closeConnection", "socket", "destroyWifiAccessory", "bConfig", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWifiNetworkInterface", "Ljava/net/NetworkInterface;", "listenToWifiConnection", "isConnected", "openWifiAccessory", "isWifiServerConnected", "Lcom/gk/bricks/util/WiFiServerStatus;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readLopData", "onDataReceived", "resumeWifiAccessory", "startReadLopData", "app_debug"})
public final class WifiLopInterfaceImpl implements com.gk.bricks.wifi.WifiLopInterface {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> isConnectedCallback;
    @org.jetbrains.annotations.Nullable()
    private java.net.MulticastSocket receiveLopSocket;
    private boolean isReadEnabled = false;
    private final int readDataSize = 10;
    @org.jetbrains.annotations.NotNull()
    private final byte[] lMsg = null;
    @org.jetbrains.annotations.NotNull()
    private final java.net.DatagramPacket dp = null;
    private final java.net.InetAddress group = null;
    
    public WifiLopInterfaceImpl(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object resumeWifiAccessory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gk.bricks.util.WiFiServerStatus, kotlin.Unit> isWifiServerConnected, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object openWifiAccessory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gk.bricks.util.WiFiServerStatus, kotlin.Unit> isWifiServerConnected, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.net.NetworkInterface getWifiNetworkInterface() {
        return null;
    }
    
    @java.lang.Override()
    public void listenToWifiConnection(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> isConnected) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object startReadLopData(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super byte[], kotlin.Unit> onDataReceived, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object readLopData(kotlin.jvm.functions.Function1<? super byte[], kotlin.Unit> onDataReceived, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object destroyWifiAccessory(boolean bConfig, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void closeConnection(java.net.MulticastSocket socket) {
    }
}