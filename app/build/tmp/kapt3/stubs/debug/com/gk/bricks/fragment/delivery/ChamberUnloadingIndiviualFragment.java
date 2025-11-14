package com.gk.bricks.fragment.delivery;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006)"}, d2 = {"Lcom/gk/bricks/fragment/delivery/ChamberUnloadingIndiviualFragment;", "Lcom/gk/bricks/fragment/BaseFragment;", "()V", "binding", "Lcom/gk/bricks/databinding/FragmentChamberUnloadingIndividualDataBinding;", "bricksChamberLoading", "Lcom/gk/bricks/model/parse/BricksChamberLoading;", "bricksUnloadingLogList", "", "Lcom/gk/bricks/model/parse/BricksUnloadingLogs;", "chamberId", "", "chamberUnloadingLogAdapter", "Lcom/gk/bricks/adapter/ChamberUnloadingLogAdapter;", "mContext", "Landroid/content/Context;", "mainNavViewModel", "Lcom/gk/bricks/viewmodel/MainNavViewModel;", "getMainNavViewModel", "()Lcom/gk/bricks/viewmodel/MainNavViewModel;", "mainNavViewModel$delegate", "Lkotlin/Lazy;", "loadProfileImageFromS3", "", "url", "ivView", "Landroid/widget/ImageView;", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "showProfilePopupWithAnimation", "view", "updateProductionList", "app_debug"})
public final class ChamberUnloadingIndiviualFragment extends com.gk.bricks.fragment.BaseFragment {
    private android.content.Context mContext;
    private com.gk.bricks.databinding.FragmentChamberUnloadingIndividualDataBinding binding;
    private com.gk.bricks.adapter.ChamberUnloadingLogAdapter chamberUnloadingLogAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.gk.bricks.model.parse.BricksChamberLoading bricksChamberLoading;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.gk.bricks.model.parse.BricksUnloadingLogs> bricksUnloadingLogList = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String chamberId = "";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainNavViewModel$delegate = null;
    
    public ChamberUnloadingIndiviualFragment() {
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
    
    private final void updateProductionList() {
    }
    
    private final void loadProfileImageFromS3(java.lang.String url, android.widget.ImageView ivView) {
    }
    
    private final void showProfilePopupWithAnimation(android.view.View view, java.lang.String url) {
    }
}