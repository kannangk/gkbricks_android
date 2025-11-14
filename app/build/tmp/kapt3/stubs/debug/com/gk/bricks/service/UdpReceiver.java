package com.gk.bricks.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002&\'B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\r\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u0018H\u0082@\u00a2\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\bJ\u0010\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u0010J\u0018\u0010#\u001a\u0004\u0018\u00010\u00182\u0006\u0010\"\u001a\u00020\u0010H\u0082@\u00a2\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/gk/bricks/service/UdpReceiver;", "", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;)V", "dataListener", "Lcom/gk/bricks/service/UdpReceiver$UdpDataListener;", "isReceiving", "", "receiverJob", "Lkotlinx/coroutines/Job;", "udpSocket", "Ljava/net/DatagramSocket;", "getListeningPort", "", "()Ljava/lang/Integer;", "getLocalIpAddress", "", "hasNetworkPermissions", "isNetworkAvailable", "isRunning", "receiveData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendResponse", "message", "targetAddress", "Ljava/net/InetAddress;", "targetPort", "setDataListener", "listener", "startReceiver", "port", "startUdpReceiver", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopReceiver", "Companion", "UdpDataListener", "app_debug"})
public final class UdpReceiver {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LifecycleOwner lifecycleOwner = null;
    @org.jetbrains.annotations.Nullable()
    private java.net.DatagramSocket udpSocket;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job receiverJob;
    private boolean isReceiving = false;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "com.gk.bricks.service.UdpReceiver";
    private static final int BUFFER_SIZE = 1024;
    private static final int DEFAULT_PORT = 8888;
    @org.jetbrains.annotations.Nullable()
    private com.gk.bricks.service.UdpReceiver.UdpDataListener dataListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.service.UdpReceiver.Companion Companion = null;
    
    public UdpReceiver(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super();
    }
    
    public final void setDataListener(@org.jetbrains.annotations.NotNull()
    com.gk.bricks.service.UdpReceiver.UdpDataListener listener) {
    }
    
    /**
     * Start UDP receiver on specified port
     */
    public final void startReceiver(int port) {
    }
    
    /**
     * Stop UDP receiver
     */
    public final void stopReceiver() {
    }
    
    private final java.lang.Object startUdpReceiver(int port, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object receiveData(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Send UDP response back to sender
     */
    public final void sendResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.net.InetAddress targetAddress, int targetPort) {
    }
    
    /**
     * Check if device has network connectivity
     */
    private final boolean isNetworkAvailable() {
        return false;
    }
    
    /**
     * Check if app has required network permissions
     */
    private final boolean hasNetworkPermissions() {
        return false;
    }
    
    /**
     * Get local IP address
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocalIpAddress() {
        return null;
    }
    
    /**
     * Check if receiver is currently running
     */
    public final boolean isRunning() {
        return false;
    }
    
    /**
     * Get current listening port
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getListeningPort() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/gk/bricks/service/UdpReceiver$Companion;", "", "()V", "BUFFER_SIZE", "", "DEFAULT_PORT", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/gk/bricks/service/UdpReceiver$UdpDataListener;", "", "onDataReceived", "", "data", "", "senderAddress", "Ljava/net/InetAddress;", "senderPort", "", "onError", "error", "app_debug"})
    public static abstract interface UdpDataListener {
        
        public abstract void onDataReceived(@org.jetbrains.annotations.NotNull()
        java.lang.String data, @org.jetbrains.annotations.NotNull()
        java.net.InetAddress senderAddress, int senderPort);
        
        public abstract void onError(@org.jetbrains.annotations.NotNull()
        java.lang.String error);
    }
}