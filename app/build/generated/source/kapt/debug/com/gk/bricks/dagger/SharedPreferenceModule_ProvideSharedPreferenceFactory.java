package com.gk.bricks.dagger;

import android.app.Application;
import android.content.SharedPreferences;
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
public final class SharedPreferenceModule_ProvideSharedPreferenceFactory implements Factory<SharedPreferences> {
  private final SharedPreferenceModule module;

  private final Provider<Application> appProvider;

  public SharedPreferenceModule_ProvideSharedPreferenceFactory(SharedPreferenceModule module,
      Provider<Application> appProvider) {
    this.module = module;
    this.appProvider = appProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreference(module, appProvider.get());
  }

  public static SharedPreferenceModule_ProvideSharedPreferenceFactory create(
      SharedPreferenceModule module, Provider<Application> appProvider) {
    return new SharedPreferenceModule_ProvideSharedPreferenceFactory(module, appProvider);
  }

  public static SharedPreferences provideSharedPreference(SharedPreferenceModule instance,
      Application app) {
    return Preconditions.checkNotNullFromProvides(instance.provideSharedPreference(app));
  }
}
