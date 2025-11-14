package com.gk.bricks.datasource.firebase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\n0\u000eH\u0016J4\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/gk/bricks/datasource/firebase/FirebaseInterfaceImpl;", "Lcom/gk/bricks/datasource/firebase/FirebaseInterface;", "database", "Lcom/google/firebase/database/FirebaseDatabase;", "dataSource", "Lcom/gk/bricks/datasource/SharedPrefDelegate;", "(Lcom/google/firebase/database/FirebaseDatabase;Lcom/gk/bricks/datasource/SharedPrefDelegate;)V", "productionReference", "Lcom/google/firebase/database/DatabaseReference;", "getAllProduction", "", "mContext", "Landroid/content/Context;", "dataAvailableListener", "Lkotlin/Function1;", "", "Lcom/gk/bricks/model/ProductionModel;", "updateProductionCount", "date", "", "count", "", "isUpdatedListener", "", "app_debug"})
public final class FirebaseInterfaceImpl implements com.gk.bricks.datasource.firebase.FirebaseInterface {
    @org.jetbrains.annotations.NotNull()
    private final com.gk.bricks.datasource.SharedPrefDelegate dataSource = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.database.DatabaseReference productionReference;
    
    public FirebaseInterfaceImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.FirebaseDatabase database, @org.jetbrains.annotations.NotNull()
    com.gk.bricks.datasource.SharedPrefDelegate dataSource) {
        super();
    }
    
    @java.lang.Override()
    public void getAllProduction(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.gk.bricks.model.ProductionModel>, kotlin.Unit> dataAvailableListener) {
    }
    
    @java.lang.Override()
    public void updateProductionCount(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.lang.String date, int count, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> isUpdatedListener) {
    }
}