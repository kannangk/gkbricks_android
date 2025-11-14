package com.gk.bricks;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0006\u0010\u0017\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0019\u001a\u00020\u00142\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001bJ\u0006\u0010\u001d\u001a\u00020\u0014J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/gk/bricks/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mAdminComponentName", "Landroid/content/ComponentName;", "getMAdminComponentName", "()Landroid/content/ComponentName;", "setMAdminComponentName", "(Landroid/content/ComponentName;)V", "mDevicePolicyManager", "Landroid/app/admin/DevicePolicyManager;", "getMDevicePolicyManager", "()Landroid/app/admin/DevicePolicyManager;", "setMDevicePolicyManager", "(Landroid/app/admin/DevicePolicyManager;)V", "requestInstallPackagesResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "startForResult", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "disableKioskMode", "enableKioskMode", "handleRequiredPermissions", "isAllPermissionsGranted", "Lkotlin/Function1;", "", "requestManageStoragePermissions", "requestOverLayPermission", "requestWriteSettingsPermissions", "showLauncherSelection", "showToast", "message", "", "app_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity {
    public android.content.ComponentName mAdminComponentName;
    public android.app.admin.DevicePolicyManager mDevicePolicyManager;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> startForResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> requestInstallPackagesResult = null;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.ComponentName getMAdminComponentName() {
        return null;
    }
    
    public final void setMAdminComponentName(@org.jetbrains.annotations.NotNull()
    android.content.ComponentName p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.admin.DevicePolicyManager getMDevicePolicyManager() {
        return null;
    }
    
    public final void setMDevicePolicyManager(@org.jetbrains.annotations.NotNull()
    android.app.admin.DevicePolicyManager p0) {
    }
    
    public final void disableKioskMode() {
    }
    
    public final void enableKioskMode() {
    }
    
    private final void requestWriteSettingsPermissions() {
    }
    
    public final void handleRequiredPermissions(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> isAllPermissionsGranted) {
    }
    
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull()
    android.content.Context newBase) {
    }
    
    private final void showLauncherSelection() {
    }
    
    public final void requestManageStoragePermissions() {
    }
    
    private final void requestOverLayPermission() {
    }
    
    public final void showToast(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}