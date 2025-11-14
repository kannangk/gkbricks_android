package com.elite.x300.base.primarynav;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/elite/x300/base/primarynav/PrimaryNavViewModel;", "Lcom/gk/bricks/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_primaryNavModelLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/elite/x300/base/primarynav/PrimaryNavModel;", "cachedModelLiveData", "Landroidx/lifecycle/LiveData;", "observer", "Landroidx/lifecycle/Observer;", "primaryNavModelLiveData", "getPrimaryNavModelLiveData", "()Landroidx/lifecycle/LiveData;", "onCleared", "", "requestPrimaryNavModel", "app_debug"})
public final class PrimaryNavViewModel extends com.gk.bricks.viewmodel.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.elite.x300.base.primarynav.PrimaryNavModel> _primaryNavModelLiveData = null;
    private androidx.lifecycle.LiveData<com.elite.x300.base.primarynav.PrimaryNavModel> cachedModelLiveData;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.Observer<com.elite.x300.base.primarynav.PrimaryNavModel> observer = null;
    
    public PrimaryNavViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.elite.x300.base.primarynav.PrimaryNavModel> getPrimaryNavModelLiveData() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void requestPrimaryNavModel() {
    }
}