package com.gk.bricks.fragment.delivery;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0082 J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010(\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/gk/bricks/fragment/delivery/ChamberIndiviualFragment;", "Lcom/gk/bricks/fragment/BaseFragment;", "()V", "binding", "Lcom/gk/bricks/databinding/FragmentChamberIndividualDataBinding;", "bricksChamberLoading", "Lcom/gk/bricks/model/parse/BricksChamberLoading;", "chamberBricksLogAdapter", "Lcom/gk/bricks/adapter/ChamberBricksLogAdapter;", "chamberId", "", "mContext", "Landroid/content/Context;", "mainNavViewModel", "Lcom/gk/bricks/viewmodel/MainNavViewModel;", "getMainNavViewModel", "()Lcom/gk/bricks/viewmodel/MainNavViewModel;", "mainNavViewModel$delegate", "Lkotlin/Lazy;", "totalPaidSalary", "", "workLogList", "", "Lcom/gk/bricks/model/parse/BricksChamberLoadingLogs;", "getApiKey", "id", "isDebug", "", "onAttach", "", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateProductionList", "app_debug"})
public final class ChamberIndiviualFragment extends com.gk.bricks.fragment.BaseFragment {
    private android.content.Context mContext;
    private com.gk.bricks.databinding.FragmentChamberIndividualDataBinding binding;
    private com.gk.bricks.adapter.ChamberBricksLogAdapter chamberBricksLogAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.gk.bricks.model.parse.BricksChamberLoading bricksChamberLoading;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.gk.bricks.model.parse.BricksChamberLoadingLogs> workLogList = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String chamberId = "";
    private int totalPaidSalary = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainNavViewModel$delegate = null;
    
    public ChamberIndiviualFragment() {
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
    
    private final native java.lang.String getApiKey(int id, boolean isDebug) {
        return null;
    }
}