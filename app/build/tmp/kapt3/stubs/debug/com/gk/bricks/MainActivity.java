package com.gk.bricks;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/gk/bricks/MainActivity;", "Lcom/gk/bricks/BaseActivity;", "()V", "binding", "Lcom/gk/bricks/databinding/ActivityMainBinding;", "isAuthorized", "", "telephonyManager", "Landroid/telephony/TelephonyManager;", "then", "", "viewModel", "Lcom/gk/bricks/viewmodel/MainViewModel;", "checkSimRelatedData", "", "checkUser", "initCheckUser", "listenToPermissionResponse", "observe", "onClickListener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setSimUIState", "simState", "", "setupTelephonyManager", "showLanguagePopup", "signIn", "signUpParse", "Companion", "app_debug"})
public final class MainActivity extends com.gk.bricks.BaseActivity {
    private com.gk.bricks.databinding.ActivityMainBinding binding;
    private com.gk.bricks.viewmodel.MainViewModel viewModel;
    @org.jetbrains.annotations.Nullable()
    private android.telephony.TelephonyManager telephonyManager;
    private long then = 0L;
    private boolean isAuthorized = false;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "init_activity";
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.MainActivity.Companion Companion = null;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void onClickListener() {
    }
    
    private final void initCheckUser() {
    }
    
    private final void checkUser() {
    }
    
    private final void signIn() {
    }
    
    private final void signUpParse() {
    }
    
    private final void showLanguagePopup() {
    }
    
    private final void setupTelephonyManager() {
    }
    
    private final void checkSimRelatedData() {
    }
    
    private final void observe() {
    }
    
    private final void listenToPermissionResponse() {
    }
    
    private final void setSimUIState(java.lang.String simState) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/gk/bricks/MainActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}