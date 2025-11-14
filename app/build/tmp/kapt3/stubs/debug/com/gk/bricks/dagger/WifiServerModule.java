package com.gk.bricks.dagger;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/gk/bricks/dagger/WifiServerModule;", "", "()V", "provideFirebaseDatabase", "Lcom/google/firebase/database/FirebaseDatabase;", "provideFirebaseInterface", "Lcom/gk/bricks/datasource/firebase/FirebaseInterface;", "database", "dataSource", "Lcom/gk/bricks/datasource/SharedPrefDelegate;", "provideWifiLopModule", "Lcom/gk/bricks/wifi/WifiLopInterface;", "app", "Landroid/app/Application;", "provideWifiServerModule", "Lcom/gk/bricks/wifi/WifiServerInterface;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class WifiServerModule {
    
    public WifiServerModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.gk.bricks.wifi.WifiServerInterface provideWifiServerModule(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.gk.bricks.wifi.WifiLopInterface provideWifiLopModule(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.FirebaseDatabase provideFirebaseDatabase() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.gk.bricks.datasource.firebase.FirebaseInterface provideFirebaseInterface(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.FirebaseDatabase database, @org.jetbrains.annotations.NotNull()
    com.gk.bricks.datasource.SharedPrefDelegate dataSource) {
        return null;
    }
}