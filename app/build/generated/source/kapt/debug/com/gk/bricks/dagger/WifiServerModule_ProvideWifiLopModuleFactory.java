package com.gk.bricks.dagger;

import android.app.Application;
import com.gk.bricks.wifi.WifiLopInterface;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class WifiServerModule_ProvideWifiLopModuleFactory implements Factory<WifiLopInterface> {
  private final WifiServerModule module;

  private final Provider<Application> appProvider;

  public WifiServerModule_ProvideWifiLopModuleFactory(WifiServerModule module,
      Provider<Application> appProvider) {
    this.module = module;
    this.appProvider = appProvider;
  }

  @Override
  public WifiLopInterface get() {
    return provideWifiLopModule(module, appProvider.get());
  }

  public static WifiServerModule_ProvideWifiLopModuleFactory create(WifiServerModule module,
      Provider<Application> appProvider) {
    return new WifiServerModule_ProvideWifiLopModuleFactory(module, appProvider);
  }

  public static WifiLopInterface provideWifiLopModule(WifiServerModule instance, Application app) {
    return Preconditions.checkNotNullFromProvides(instance.provideWifiLopModule(app));
  }
}
