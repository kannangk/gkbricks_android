package com.gk.bricks.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0011J\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/gk/bricks/viewmodel/BaseViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_navigationCommands", "Lcom/gk/bricks/viewmodel/SingleLiveEvent;", "Lcom/elite/x300/base/primarynav/NavigationCommand;", "_pageProgressCommands", "", "navigationCommands", "Landroidx/lifecycle/LiveData;", "getNavigationCommands", "()Landroidx/lifecycle/LiveData;", "pageProgressCommands", "getPageProgressCommands", "navigate", "", "deepLinkUri", "Landroid/net/Uri;", "directions", "Landroidx/navigation/NavDirections;", "destinationId", "", "navigateBack", "navigateBackTo", "isInclusive", "app_debug"})
public abstract class BaseViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.gk.bricks.viewmodel.SingleLiveEvent<java.lang.Boolean> _pageProgressCommands = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gk.bricks.viewmodel.SingleLiveEvent<com.elite.x300.base.primarynav.NavigationCommand> _navigationCommands = null;
    
    public BaseViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getPageProgressCommands() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.elite.x300.base.primarynav.NavigationCommand> getNavigationCommands() {
        return null;
    }
    
    public final void navigate(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavDirections directions) {
    }
    
    public final void navigate(int destinationId) {
    }
    
    public final void navigateBack() {
    }
    
    public final void navigateBackTo(int destinationId, boolean isInclusive) {
    }
    
    public final void navigate(@org.jetbrains.annotations.NotNull()
    android.net.Uri deepLinkUri) {
    }
}