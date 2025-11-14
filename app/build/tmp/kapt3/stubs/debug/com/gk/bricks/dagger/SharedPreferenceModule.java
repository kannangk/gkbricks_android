package com.gk.bricks.dagger;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/gk/bricks/dagger/SharedPreferenceModule;", "", "()V", "provideSharedPrefImpl", "Lcom/gk/bricks/datasource/SharedPrefDelegate;", "sharedPreferenceUtils", "Lcom/gk/bricks/datasource/SharedPreferenceUtils;", "provideSharedPreference", "Landroid/content/SharedPreferences;", "app", "Landroid/app/Application;", "provideSharedPreferenceUtils", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class SharedPreferenceModule {
    
    public SharedPreferenceModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences provideSharedPreference(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.gk.bricks.datasource.SharedPreferenceUtils provideSharedPreferenceUtils(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.gk.bricks.datasource.SharedPrefDelegate provideSharedPrefImpl(@org.jetbrains.annotations.NotNull()
    com.gk.bricks.datasource.SharedPreferenceUtils sharedPreferenceUtils) {
        return null;
    }
}