package com.gk.bricks.dialog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/gk/bricks/dialog/DialogAddProductionBricks;", "Landroid/app/Dialog;", "activity", "Landroidx/fragment/app/FragmentActivity;", "currentCount", "", "(Landroidx/fragment/app/FragmentActivity;I)V", "binding", "Lcom/gk/bricks/databinding/DialogAddProductionBricksBinding;", "format", "Ljava/text/SimpleDateFormat;", "selectedDate", "Ljava/util/Date;", "selectedDateProduction", "Lcom/gk/bricks/model/parse/BricksProduction;", "adjustDialogWidth", "", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "default", "", "clickListeners", "dismiss", "fetchProductionCount", "date", "hideKeyBoard", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showKeyboard", "app_debug"})
public final class DialogAddProductionBricks extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private final androidx.fragment.app.FragmentActivity activity = null;
    private int currentCount;
    @org.jetbrains.annotations.Nullable()
    private java.util.Date selectedDate;
    private com.gk.bricks.databinding.DialogAddProductionBricksBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat format = null;
    @org.jetbrains.annotations.Nullable()
    private com.gk.bricks.model.parse.BricksProduction selectedDateProduction;
    
    public DialogAddProductionBricks(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity activity, int currentCount) {
        super(null);
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void adjustDialogWidth(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.view.Window window, float p2_772401952) {
    }
    
    private final void clickListeners() {
    }
    
    private final void fetchProductionCount(java.util.Date date) {
    }
    
    private final void showKeyboard() {
    }
    
    @java.lang.Override()
    public void dismiss() {
    }
    
    private final void hideKeyBoard() {
    }
}