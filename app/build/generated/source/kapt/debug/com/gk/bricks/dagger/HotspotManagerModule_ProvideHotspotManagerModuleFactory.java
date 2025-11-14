package com.gk.bricks.dagger;

import android.app.Application;
import com.gk.bricks.managers.HotspotManager;
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
public final class HotspotManagerModule_ProvideHotspotManagerModuleFactory implements Factory<HotspotManager> {
  private final HotspotManagerModule module;

  private final Provider<Application> appProvider;

  public HotspotManagerModule_ProvideHotspotManagerModuleFactory(HotspotManagerModule module,
      Provider<Application> appProvider) {
    this.module = module;
    this.appProvider = appProvider;
  }

  @Override
  public HotspotManager get() {
    return provideHotspotManagerModule(module, appProvider.get());
  }

  public static HotspotManagerModule_ProvideHotspotManagerModuleFactory create(
      HotspotManagerModule module, Provider<Application> appProvider) {
    return new HotspotManagerModule_ProvideHotspotManagerModuleFactory(module, appProvider);
  }

  public static HotspotManager provideHotspotManagerModule(HotspotManagerModule instance,
      Application app) {
    return Preconditions.checkNotNullFromProvides(instance.provideHotspotManagerModule(app));
  }
}
