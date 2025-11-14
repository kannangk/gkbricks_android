package com.gk.bricks.fragment.delivery;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0019\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0082 J\u001a\u0010%\u001a\u0004\u0018\u00010\u00162\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020 2\u0006\u0010(\u001a\u00020\fH\u0002J\u0018\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u000eH\u0016J\u0012\u00100\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u000102H\u0016J$\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\u0016H\u0002J\b\u0010>\u001a\u00020 H\u0002J\u001a\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0006\u0010A\u001a\u00020 J \u0010B\u001a\u00020 2\u0006\u0010(\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010C\u001a\u000204H\u0002J\u0006\u0010D\u001a\u00020 J\u001a\u0010E\u001a\u00020 2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 0GJ\u0018\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00160\u00160\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\f0\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lcom/gk/bricks/fragment/delivery/AddVendorLogsFragment;", "Lcom/gk/bricks/fragment/BaseFragment;", "()V", "binding", "Lcom/gk/bricks/databinding/FragmentVendorLogsAddBinding;", "clickedPosition", "", "cropImage", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/canhub/cropper/CropImageContractOptions;", "kotlin.jvm.PlatformType", "imageUri", "Landroid/net/Uri;", "mContext", "Landroid/content/Context;", "mainNavViewModel", "Lcom/gk/bricks/viewmodel/MainNavViewModel;", "getMainNavViewModel", "()Lcom/gk/bricks/viewmodel/MainNavViewModel;", "mainNavViewModel$delegate", "Lkotlin/Lazy;", "pickImageLauncher", "", "profileUrl1", "profileUrl2", "profileUrl3", "selectedLoadName", "takePictureLauncher", "vendorId", "vendorName", "vendorType", "captureImage", "", "getApiKey", "id", "isDebug", "", "getFileName", "contentResolver", "Landroid/content/ContentResolver;", "uri", "launchCrop", "loadProfileImageFromS3", "url", "captureImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveVendor", "vendorPaidLog", "Lcom/gk/bricks/model/parse/VendorPaidLog;", "onSaveVendorLoad", "selectedDate", "onShowDate", "onViewCreated", "view", "openGallery", "saveImageFileToS3", "pbProfile", "selectImageSource", "showDatePicker", "onDateSelected", "Lkotlin/Function1;", "uriToFile", "Ljava/io/File;", "app_debug"})
public final class AddVendorLogsFragment extends com.gk.bricks.fragment.BaseFragment {
    private android.content.Context mContext;
    private com.gk.bricks.databinding.FragmentVendorLogsAddBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profileUrl1 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profileUrl2 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String profileUrl3 = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String vendorType = "FIRE_WOOD";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String vendorId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String vendorName = "";
    private int clickedPosition = 0;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedLoadName;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainNavViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.net.Uri> takePictureLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> pickImageLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<com.canhub.cropper.CropImageContractOptions> cropImage = null;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri imageUri;
    
    public AddVendorLogsFragment() {
        super();
    }
    
    private final com.gk.bricks.viewmodel.MainNavViewModel getMainNavViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void selectImageSource() {
    }
    
    public final void openGallery() {
    }
    
    private final void launchCrop(android.net.Uri uri) {
    }
    
    public final void captureImage() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.io.File uriToFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    private final java.lang.String getFileName(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        return null;
    }
    
    private final void saveImageFileToS3(android.net.Uri uri, androidx.appcompat.widget.AppCompatImageView captureImageView, android.view.View pbProfile) {
    }
    
    private final void loadProfileImageFromS3(java.lang.String url, androidx.appcompat.widget.AppCompatImageView captureImageView) {
    }
    
    private final void onShowDate() {
    }
    
    public final void showDatePicker(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDateSelected) {
    }
    
    private final void onSaveVendorLoad(java.lang.String selectedDate) {
    }
    
    private final void onSaveVendor(com.gk.bricks.model.parse.VendorPaidLog vendorPaidLog) {
    }
    
    private final native java.lang.String getApiKey(int id, boolean isDebug) {
        return null;
    }
}