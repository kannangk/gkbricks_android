package com.gk.bricks.fragment.employee;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0019\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082 J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0014H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\fH\u0016J\u0012\u0010\'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J$\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00100\u001a\u00020\u0018H\u0002J\u0010\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u000203H\u0002J\u001a\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0006\u00106\u001a\u00020\u0018J\u0010\u00107\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\nH\u0002J\u0006\u00108\u001a\u00020\u0018J\u0018\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010&\u001a\u00020\f2\u0006\u0010!\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00140\u00140\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\n0\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/gk/bricks/fragment/employee/AddLabourFragment;", "Lcom/gk/bricks/fragment/BaseFragment;", "()V", "binding", "Lcom/gk/bricks/databinding/FragmentEmployeeAddBinding;", "cropImage", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/canhub/cropper/CropImageContractOptions;", "kotlin.jvm.PlatformType", "imageUri", "Landroid/net/Uri;", "mContext", "Landroid/content/Context;", "mainNavViewModel", "Lcom/gk/bricks/viewmodel/MainNavViewModel;", "getMainNavViewModel", "()Lcom/gk/bricks/viewmodel/MainNavViewModel;", "mainNavViewModel$delegate", "Lkotlin/Lazy;", "pickImageLauncher", "", "profileUrl", "takePictureLauncher", "captureImage", "", "getApiKey", "id", "", "isDebug", "", "getFileName", "contentResolver", "Landroid/content/ContentResolver;", "uri", "launchCrop", "loadProfileImageFromS3", "url", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveEmpProfile", "onSaveEmployee", "employee", "Lcom/gk/bricks/model/parse/Employee;", "onViewCreated", "view", "openGallery", "saveImageFileToS3", "selectImageSource", "uriToFile", "Ljava/io/File;", "app_debug"})
public final class AddLabourFragment extends com.gk.bricks.fragment.BaseFragment {
    private android.content.Context mContext;
    private com.gk.bricks.databinding.FragmentEmployeeAddBinding binding;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String profileUrl;
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
    
    public AddLabourFragment() {
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
    
    private final void saveImageFileToS3(android.net.Uri uri) {
    }
    
    private final void loadProfileImageFromS3(java.lang.String url) {
    }
    
    private final void onSaveEmpProfile() {
    }
    
    private final void onSaveEmployee(com.gk.bricks.model.parse.Employee employee) {
    }
    
    private final native java.lang.String getApiKey(int id, boolean isDebug) {
        return null;
    }
}