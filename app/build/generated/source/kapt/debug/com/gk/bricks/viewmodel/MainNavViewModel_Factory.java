package com.gk.bricks.viewmodel;

import android.app.Application;
import com.gk.bricks.datasource.firebase.FirebaseInterface;
import com.gk.bricks.managers.HotspotManager;
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
public final class MainNavViewModel_Factory implements Factory<MainNavViewModel> {
  private final Provider<Application> appProvider;

  private final Provider<WifiServerInterface> wifiServerInterfaceProvider;

  private final Provider<FirebaseInterface> firebaseDatabaseProvider;

  private final Provider<HotspotManager> hotspotManagerProvider;

  public MainNavViewModel_Factory(Provider<Application> appProvider,
      Provider<WifiServerInterface> wifiServerInterfaceProvider,
      Provider<FirebaseInterface> firebaseDatabaseProvider,
      Provider<HotspotManager> hotspotManagerProvider) {
    this.appProvider = appProvider;
    this.wifiServerInterfaceProvider = wifiServerInterfaceProvider;
    this.firebaseDatabaseProvider = firebaseDatabaseProvider;
    this.hotspotManagerProvider = hotspotManagerProvider;
  }

  @Override
  public MainNavViewModel get() {
    return newInstance(appProvider.get(), wifiServerInterfaceProvider.get(), firebaseDatabaseProvider.get(), hotspotManagerProvider.get());
  }

  public static MainNavViewModel_Factory create(Provider<Application> appProvider,
      Provider<WifiServerInterface> wifiServerInterfaceProvider,
      Provider<FirebaseInterface> firebaseDatabaseProvider,
      Provider<HotspotManager> hotspotManagerProvider) {
    return new MainNavViewModel_Factory(appProvider, wifiServerInterfaceProvider, firebaseDatabaseProvider, hotspotManagerProvider);
  }

  public static MainNavViewModel newInstance(Application app,
      WifiServerInterface wifiServerInterface, FirebaseInterface firebaseDatabase,
      HotspotManager hotspotManager) {
    return new MainNavViewModel(app, wifiServerInterface, firebaseDatabase, hotspotManager);
  }
}
