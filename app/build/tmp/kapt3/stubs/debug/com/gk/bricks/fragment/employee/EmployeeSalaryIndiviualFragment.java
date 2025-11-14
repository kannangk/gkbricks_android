package com.gk.bricks.fragment.employee;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0011H\u0082 J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010\'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0015H\u0016J\u0012\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J$\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00102\u001a\u00020#H\u0002J\u001a\u00103\u001a\u00020#2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#05J6\u00106\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00152\b\b\u0002\u00107\u001a\u00020\b2\b\b\u0002\u00108\u001a\u00020\b2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020#05J\u0018\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020-2\u0006\u0010$\u001a\u00020\bH\u0002J\b\u0010<\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/gk/bricks/fragment/employee/EmployeeSalaryIndiviualFragment;", "Lcom/gk/bricks/fragment/BaseFragment;", "()V", "binding", "Lcom/gk/bricks/databinding/FragmentEmpIndividualDataBinding;", "empData", "Lcom/gk/bricks/model/parse/Employee;", "empId", "", "empList", "", "Lcom/gk/bricks/model/parse/EmployeeWorkLog;", "empName", "empPhotoUrl", "employeeSalaryAdapter", "Lcom/gk/bricks/adapter/EmployeeSalaryAdapter;", "isSalaryScreen", "", "lastWorkLogs", "", "mContext", "Landroid/content/Context;", "mainNavViewModel", "Lcom/gk/bricks/viewmodel/MainNavViewModel;", "getMainNavViewModel", "()Lcom/gk/bricks/viewmodel/MainNavViewModel;", "mainNavViewModel$delegate", "Lkotlin/Lazy;", "totalAdvanceSalary", "", "totalWorkingSalary", "getApiKey", "id", "isDebug", "loadProfileImageFromS3", "", "url", "ivView", "Landroid/widget/ImageView;", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onShowDate", "showDatePicker", "onDateSelected", "Lkotlin/Function1;", "showEditTextDialog", "title", "initialValue", "onSave", "showProfilePopupWithAnimation", "view", "updateProductionList", "app_debug"})
public final class EmployeeSalaryIndiviualFragment extends com.gk.bricks.fragment.BaseFragment {
    private android.content.Context mContext;
    private com.gk.bricks.databinding.FragmentEmpIndividualDataBinding binding;
    private com.gk.bricks.adapter.EmployeeSalaryAdapter employeeSalaryAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.gk.bricks.model.parse.Employee empData;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.gk.bricks.model.parse.EmployeeWorkLog> empList = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.gk.bricks.model.parse.EmployeeWorkLog> lastWorkLogs;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String empId = "";
    private boolean isSalaryScreen = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String empName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String empPhotoUrl = "";
    private int totalWorkingSalary = 0;
    private int totalAdvanceSalary = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainNavViewModel$delegate = null;
    
    public EmployeeSalaryIndiviualFragment() {
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
    
    private final void onShowDate() {
    }
    
    public final void showDatePicker(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDateSelected) {
    }
    
    public final void showEditTextDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String initialValue, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSave) {
    }
    
    private final void showProfilePopupWithAnimation(android.view.View view, java.lang.String url) {
    }
    
    private final void updateProductionList() {
    }
    
    private final void loadProfileImageFromS3(java.lang.String url, android.widget.ImageView ivView) {
    }
    
    private final native java.lang.String getApiKey(int id, boolean isDebug) {
        return null;
    }
}