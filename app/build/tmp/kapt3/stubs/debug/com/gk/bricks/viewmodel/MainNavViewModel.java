package com.gk.bricks.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010 \u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010$\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\'2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u0010)\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-J(\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J(\u00103\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u001b2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u0013\u0012\u0004\u0012\u00020\u000e0\u0012J\u000e\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<J\u0015\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010>\u00a2\u0006\u0002\u0010@J\u0015\u0010A\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010>\u00a2\u0006\u0002\u0010@J\u000e\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\fJ\u001d\u0010D\u001a\u00020\u000e2\b\u0010E\u001a\u0004\u0018\u00010>2\u0006\u0010F\u001a\u00020G\u00a2\u0006\u0002\u0010HJ\u001d\u0010I\u001a\u00020\u000e2\b\u0010E\u001a\u0004\u0018\u00010>2\u0006\u0010F\u001a\u00020G\u00a2\u0006\u0002\u0010HJ\u000e\u0010J\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020<R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006M"}, d2 = {"Lcom/gk/bricks/viewmodel/MainNavViewModel;", "Lcom/gk/bricks/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "wifiServerInterface", "Lcom/gk/bricks/wifi/WifiServerInterface;", "firebaseDatabase", "Lcom/gk/bricks/datasource/firebase/FirebaseInterface;", "hotspotManager", "Lcom/gk/bricks/managers/HotspotManager;", "(Landroid/app/Application;Lcom/gk/bricks/wifi/WifiServerInterface;Lcom/gk/bricks/datasource/firebase/FirebaseInterface;Lcom/gk/bricks/managers/HotspotManager;)V", "serverDataListeners", "Lcom/gk/bricks/util/ServerDataListeners;", "getAllEmployeeList", "", "context", "Landroid/content/Context;", "dataAvailableListener", "Lkotlin/Function1;", "", "Lcom/gk/bricks/model/parse/Employee;", "getAllProductionList", "Lcom/gk/bricks/model/parse/BricksProduction;", "getBricksChamberCompletedList", "Lcom/gk/bricks/model/parse/BricksChamberLoading;", "getBricksChamberLoadingDataFromId", "chamberId", "", "getBricksChamberLoadingList", "getChamberBricksLog", "Lcom/gk/bricks/model/parse/BricksChamberLoadingLogs;", "getChamberFromId", "getChamberUnloadingLog", "Lcom/gk/bricks/model/parse/BricksUnloadingLogs;", "getEmployee", "empId", "getEmployeeList", "getEmployeeWorkLogUsingDate", "date", "Ljava/util/Date;", "Lcom/gk/bricks/model/parse/EmployeeWorkLog;", "getEmployeeWorkLogUsingEmpId", "getSettingList", "Ljava/util/ArrayList;", "Lcom/gk/bricks/util/SettingData;", "Lkotlin/collections/ArrayList;", "getVendorFromId", "vendorId", "Lcom/gk/bricks/model/parse/Vendor;", "getVendorList", "vendorType", "getVendorPaidLog", "Lcom/gk/bricks/model/parse/VendorPaidLog;", "getWifiCurrentStatus", "wifiStatus", "Lcom/gk/bricks/util/WiFiServerStatus;", "isHotspotEnabled", "", "sendWifiData", "byteArray", "", "setBatteryIconStatus", "", "percentage", "(Ljava/lang/Integer;)I", "setBlueBatteryIconStatus", "setOnServerDataListeners", "serverData", "showSimBlueSignalStrength", "level", "signalIV", "Landroid/widget/ImageView;", "(Ljava/lang/Integer;Landroid/widget/ImageView;)V", "showSimSignalStrength", "socketDataObserver", "data", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MainNavViewModel extends com.gk.bricks.viewmodel.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Application app = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gk.bricks.wifi.WifiServerInterface wifiServerInterface = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gk.bricks.datasource.firebase.FirebaseInterface firebaseDatabase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gk.bricks.managers.HotspotManager hotspotManager = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "main_nav_view_model";
    @org.jetbrains.annotations.Nullable()
    private com.gk.bricks.util.ServerDataListeners serverDataListeners;
    @org.jetbrains.annotations.NotNull()
    public static final com.gk.bricks.viewmodel.MainNavViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public MainNavViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.gk.bricks.wifi.WifiServerInterface wifiServerInterface, @org.jetbrains.annotations.NotNull()
    com.gk.bricks.datasource.firebase.FirebaseInterface firebaseDatabase, @org.jetbrains.annotations.NotNull()
    com.gk.bricks.managers.HotspotManager hotspotManager) {
        super(null);
    }
    
    public final void setOnServerDataListeners(@org.jetbrains.annotations.NotNull()
    com.gk.bricks.util.ServerDataListeners serverData) {
    }
    
    public final boolean isHotspotEnabled() {
        return false;
    }
    
    public final void socketDataObserver(@org.jetbrains.annotations.NotNull()
    byte[] data) {
    }
    
    public final void getAllProductionList(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.BricksProduction>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getEmployee(@org.jetbrains.annotations.NotNull()
    java.lang.String empId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.Employee>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getEmployeeList(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.Employee>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getAllEmployeeList(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.Employee>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getEmployeeWorkLogUsingDate(@org.jetbrains.annotations.NotNull()
    java.util.Date date, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.EmployeeWorkLog>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getEmployeeWorkLogUsingEmpId(@org.jetbrains.annotations.NotNull()
    java.lang.String empId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.EmployeeWorkLog>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getBricksChamberLoadingList(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.BricksChamberLoading>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getBricksChamberCompletedList(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.BricksChamberLoading>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getBricksChamberLoadingDataFromId(@org.jetbrains.annotations.NotNull()
    java.lang.String chamberId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.BricksChamberLoading>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getChamberBricksLog(@org.jetbrains.annotations.NotNull()
    java.lang.String chamberId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.BricksChamberLoadingLogs>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getVendorList(@org.jetbrains.annotations.NotNull()
    java.lang.String vendorType, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.Vendor>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getChamberFromId(@org.jetbrains.annotations.NotNull()
    java.lang.String chamberId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.BricksChamberLoading>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getVendorFromId(@org.jetbrains.annotations.NotNull()
    java.lang.String vendorId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.Vendor>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getChamberUnloadingLog(@org.jetbrains.annotations.NotNull()
    java.lang.String chamberId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.BricksUnloadingLogs>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final void getVendorPaidLog(@org.jetbrains.annotations.NotNull()
    java.lang.String vendorId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.parse.VendorPaidLog>, kotlin.Unit> dataAvailableListener) {
    }
    
    public final int setBatteryIconStatus(@org.jetbrains.annotations.Nullable()
    java.lang.Integer percentage) {
        return 0;
    }
    
    public final int setBlueBatteryIconStatus(@org.jetbrains.annotations.Nullable()
    java.lang.Integer percentage) {
        return 0;
    }
    
    public final void sendWifiData(@org.jetbrains.annotations.NotNull()
    byte[] byteArray) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWifiCurrentStatus(@org.jetbrains.annotations.NotNull()
    com.gk.bricks.util.WiFiServerStatus wifiStatus) {
        return null;
    }
    
    public final void showSimSignalStrength(@org.jetbrains.annotations.Nullable()
    java.lang.Integer level, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView signalIV) {
    }
    
    public final void showSimBlueSignalStrength(@org.jetbrains.annotations.Nullable()
    java.lang.Integer level, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView signalIV) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.gk.bricks.util.SettingData> getSettingList() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/gk/bricks/viewmodel/MainNavViewModel$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}