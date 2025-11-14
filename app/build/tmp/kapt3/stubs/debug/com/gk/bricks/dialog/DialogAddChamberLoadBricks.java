package com.gk.bricks.dialog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0019\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082 J\b\u0010\u001d\u001a\u00020\bH\u0002J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001aH\u0002J\b\u0010$\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/gk/bricks/dialog/DialogAddChamberLoadBricks;", "Landroid/app/Dialog;", "activity", "Landroidx/fragment/app/FragmentActivity;", "chamberId", "", "onUpdated", "Lkotlin/Function0;", "", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/gk/bricks/databinding/DialogAddChamberLoadingBinding;", "format", "Ljava/text/SimpleDateFormat;", "selectedDate", "adjustDialogWidth", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "default", "", "clickListeners", "dismiss", "getApiKey", "id", "", "isDebug", "", "hideKeyBoard", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPayLog", "bricksCount", "paidAmount", "showKeyboard", "app_debug"})
public final class DialogAddChamberLoadBricks extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private final androidx.fragment.app.FragmentActivity activity = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String chamberId;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onUpdated = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedDate;
    private com.gk.bricks.databinding.DialogAddChamberLoadingBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat format = null;
    
    public DialogAddChamberLoadBricks(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String chamberId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onUpdated) {
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
    
    private final void onPayLog(int bricksCount, int paidAmount) {
    }
    
    private final void showKeyboard() {
    }
    
    @java.lang.Override()
    public void dismiss() {
    }
    
    private final void hideKeyBoard() {
    }
    
    private final native java.lang.String getApiKey(int id, boolean isDebug) {
        return null;
    }
}