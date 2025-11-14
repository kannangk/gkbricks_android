package com.gk.bricks.managers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/gk/bricks/managers/HotspotManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "hotspotHandler", "Landroid/os/Handler;", "hotspotRunnable", "Ljava/lang/Runnable;", "hotspotStateListener", "Lcom/gk/bricks/managers/HotspotStateListener;", "isHotspotHandlerRunning", "", "disableHotspot", "", "enableHotspot", "isHotspotEnabled", "removeHotspotRunnable", "setHotspotStateListener", "listener", "startHotspotRunnable", "Companion", "app_debug"})
public final class HotspotManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "HotspotManager";
    private boolean isHotspotHandlerRunning = false;
    @org.jetbrains.annotations.Nullable()
    private com.gk.bricks.managers.HotspotStateListener hotspotStateListener;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler hotspotHandler = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable hotspotRunnable = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.managers.HotspotManager.Companion Companion = null;
    
    public HotspotManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void setHotspotStateListener(@org.jetbrains.annotations.NotNull()
    com.gk.bricks.managers.HotspotStateListener listener) {
    }
    
    public final void startHotspotRunnable() {
    }
    
    public final void removeHotspotRunnable() {
    }
    
    public final boolean isHotspotHandlerRunning() {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"PrivateApi"})
    public final void enableHotspot(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @android.annotation.SuppressLint(value = {"PrivateApi"})
    public final boolean isHotspotEnabled() {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"PrivateApi"})
    public final void disableHotspot(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/gk/bricks/managers/HotspotManager$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}