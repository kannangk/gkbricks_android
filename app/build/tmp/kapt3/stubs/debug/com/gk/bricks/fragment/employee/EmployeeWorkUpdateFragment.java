package com.gk.bricks.fragment.employee;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010\'\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/gk/bricks/fragment/employee/EmployeeWorkUpdateFragment;", "Lcom/gk/bricks/fragment/BaseFragment;", "()V", "binding", "Lcom/gk/bricks/databinding/FragmentEmpWorkUpdateBinding;", "empList", "", "Lcom/gk/bricks/model/parse/Employee;", "employeeWorkUpdateAdapter", "Lcom/gk/bricks/adapter/EmployeeWorkUpdateAdapter;", "lastWorkLogs", "", "Lcom/gk/bricks/model/parse/EmployeeWorkLog;", "mContext", "Landroid/content/Context;", "mainNavViewModel", "Lcom/gk/bricks/viewmodel/MainNavViewModel;", "getMainNavViewModel", "()Lcom/gk/bricks/viewmodel/MainNavViewModel;", "mainNavViewModel$delegate", "Lkotlin/Lazy;", "selectedDate", "Ljava/util/Date;", "onAttach", "", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveSalary", "emp", "salary", "", "updateProductionList", "app_debug"})
public final class EmployeeWorkUpdateFragment extends com.gk.bricks.fragment.BaseFragment {
    private android.content.Context mContext;
    private com.gk.bricks.databinding.FragmentEmpWorkUpdateBinding binding;
    private com.gk.bricks.adapter.EmployeeWorkUpdateAdapter employeeWorkUpdateAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.gk.bricks.model.parse.Employee> empList = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.gk.bricks.model.parse.EmployeeWorkLog> lastWorkLogs;
    @org.jetbrains.annotations.Nullable()
    private java.util.Date selectedDate;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mainNavViewModel$delegate = null;
    
    public EmployeeWorkUpdateFragment() {
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
    
    private final void onSaveSalary(com.gk.bricks.model.parse.Employee emp, int salary) {
    }
}