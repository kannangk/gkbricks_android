package com.gk.bricks;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0016J)\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002\u00a2\u0006\u0002\u0010,J\u0012\u0010-\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020\u0018H\u0014J\b\u00101\u001a\u00020\u0018H\u0014J\b\u00102\u001a\u00020\u0018H\u0014J\b\u00103\u001a\u00020\u0018H\u0014J\u0010\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020\u0018H\u0002J\u0010\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\'H\u0002J\b\u0010:\u001a\u00020\u0018H\u0002J\b\u0010;\u001a\u00020\u0018H\u0002J\b\u0010<\u001a\u00020\u0018H\u0002J\b\u0010=\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2 = {"Lcom/gk/bricks/ProductionMainActivity;", "Lcom/gk/bricks/BaseActivity;", "()V", "backPressedTime", "", "binding", "Lcom/gk/bricks/databinding/ActivityProductionBinding;", "filter", "Landroid/content/IntentFilter;", "isUDPConnected", "", "navOptions", "Landroidx/navigation/NavOptions;", "receiver", "Lcom/gk/bricks/service/BroadcastReceiver;", "telephonyManager", "Landroid/telephony/TelephonyManager;", "timeTickReceiver", "Landroid/content/BroadcastReceiver;", "toast", "Landroid/widget/Toast;", "viewModel", "Lcom/gk/bricks/viewmodel/MainViewModel;", "checkSimRelatedData", "", "connectCabinServer", "getHostFragment", "Landroidx/navigation/fragment/NavHostFragment;", "getNavController", "Landroidx/navigation/NavController;", "hotspotManagerListeners", "initBroadcastReceiver", "initFragmentTransitionAnim", "isLiftConnectedWifiServer", "listenToPermissionResponse", "observe", "onBackPressed", "onBroadcastReceived", "type", "", "i", "", "intent", "Landroid/content/Intent;", "(Ljava/lang/String;Ljava/lang/Integer;Landroid/content/Intent;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "openWifiAccessory", "status", "Lcom/gk/bricks/util/WiFiServerStatus;", "registerReceiver", "setSimUIState", "simState", "setupListeners", "setupTelephonyManager", "udpListeners", "updateBottomNavView", "Companion", "app_debug"})
public final class ProductionMainActivity extends com.gk.bricks.BaseActivity {
    private com.gk.bricks.databinding.ActivityProductionBinding binding;
    private com.gk.bricks.viewmodel.MainViewModel viewModel;
    private android.content.IntentFilter filter;
    private com.gk.bricks.service.BroadcastReceiver receiver;
    private boolean isUDPConnected = false;
    private androidx.navigation.NavOptions navOptions;
    @org.jetbrains.annotations.Nullable()
    private android.telephony.TelephonyManager telephonyManager;
    private long backPressedTime = 0L;
    private android.widget.Toast toast;
    @org.jetbrains.annotations.NotNull()
    private final android.content.BroadcastReceiver timeTickReceiver = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "main_activity";
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.ProductionMainActivity.Companion Companion = null;
    
    public ProductionMainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    private final void initFragmentTransitionAnim() {
    }
    
    private final androidx.navigation.fragment.NavHostFragment getHostFragment() {
        return null;
    }
    
    private final void setupListeners() {
    }
    
    private final void setupTelephonyManager() {
    }
    
    private final void checkSimRelatedData() {
    }
    
    private final androidx.navigation.NavController getNavController() {
        return null;
    }
    
    private final void updateBottomNavView() {
    }
    
    private final void udpListeners() {
    }
    
    private final void openWifiAccessory(com.gk.bricks.util.WiFiServerStatus status) {
    }
    
    private final void initBroadcastReceiver() {
    }
    
    private final void registerReceiver() {
    }
    
    private final void observe() {
    }
    
    private final void hotspotManagerListeners() {
    }
    
    private final boolean isLiftConnectedWifiServer() {
        return false;
    }
    
    private final void listenToPermissionResponse() {
    }
    
    private final void onBroadcastReceived(java.lang.String type, java.lang.Integer i, android.content.Intent intent) {
    }
    
    private final void setSimUIState(java.lang.String simState) {
    }
    
    private final void connectCabinServer() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/gk/bricks/ProductionMainActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}