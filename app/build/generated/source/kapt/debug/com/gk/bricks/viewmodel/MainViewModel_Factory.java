package com.gk.bricks.viewmodel;

import android.app.Application;
import com.gk.bricks.datasource.SharedPrefDelegate;
import com.gk.bricks.datasource.firebase.FirebaseInterface;
import com.gk.bricks.managers.HotspotManager;
import com.gk.bricks.wifi.WifiLopInterface;
import com.gk.bricks.wifi.WifiServerInterface;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<Application> appProvider;

  private final Provider<WifiServerInterface> wifiServerInterfaceProvider;

  private final Provider<FirebaseInterface> firebaseDatabaseProvider;

  private final Provider<WifiLopInterface> wifiLopInterfaceProvider;

  private final Provider<SharedPrefDelegate> dataSourceProvider;

  private final Provider<HotspotManager> hotspotManagerProvider;

  public MainViewModel_Factory(Provider<Application> appProvider,
      Provider<WifiServerInterface> wifiServerInterfaceProvider,
      Provider<FirebaseInterface> firebaseDatabaseProvider,
      Provider<WifiLopInterface> wifiLopInterfaceProvider,
      Provider<SharedPrefDelegate> dataSourceProvider,
      Provider<HotspotManager> hotspotManagerProvider) {
    this.appProvider = appProvider;
    this.wifiServerInterfaceProvider = wifiServerInterfaceProvider;
    this.firebaseDatabaseProvider = firebaseDatabaseProvider;
    this.wifiLopInterfaceProvider = wifiLopInterfaceProvider;
    this.dataSourceProvider = dataSourceProvider;
    this.hotspotManagerProvider = hotspotManagerProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(appProvider.get(), wifiServerInterfaceProvider.get(), firebaseDatabaseProvider.get(), wifiLopInterfaceProvider.get(), dataSourceProvider.get(), hotspotManagerProvider.get());
  }

  public static MainViewModel_Factory create(Provider<Application> appProvider,
      Provider<WifiServerInterface> wifiServerInterfaceProvider,
      Provider<FirebaseInterface> firebaseDatabaseProvider,
      Provider<WifiLopInterface> wifiLopInterfaceProvider,
      Provider<SharedPrefDelegate> dataSourceProvider,
      Provider<HotspotManager> hotspotManagerProvider) {
    return new MainViewModel_Factory(appProvider, wifiServerInterfaceProvider, firebaseDatabaseProvider, wifiLopInterfaceProvider, dataSourceProvider, hotspotManagerProvider);
  }

  public static MainViewModel newInstance(Application app, WifiServerInterface wifiServerInterface,
      FirebaseInterface firebaseDatabase, WifiLopInterface wifiLopInterface,
      SharedPrefDelegate dataSource, HotspotManager hotspotManager) {
    return new MainViewModel(app, wifiServerInterface, firebaseDatabase, wifiLopInterface, dataSource, hotspotManager);
  }
}
