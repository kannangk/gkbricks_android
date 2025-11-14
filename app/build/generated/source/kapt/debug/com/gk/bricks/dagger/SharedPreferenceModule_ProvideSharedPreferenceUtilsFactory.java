package com.gk.bricks.dagger;

import android.app.Application;
import com.gk.bricks.datasource.SharedPreferenceUtils;
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
public final class SharedPreferenceModule_ProvideSharedPreferenceUtilsFactory implements Factory<SharedPreferenceUtils> {
  private final SharedPreferenceModule module;

  private final Provider<Application> appProvider;

  public SharedPreferenceModule_ProvideSharedPreferenceUtilsFactory(SharedPreferenceModule module,
      Provider<Application> appProvider) {
    this.module = module;
    this.appProvider = appProvider;
  }

  @Override
  public SharedPreferenceUtils get() {
    return provideSharedPreferenceUtils(module, appProvider.get());
  }

  public static SharedPreferenceModule_ProvideSharedPreferenceUtilsFactory create(
      SharedPreferenceModule module, Provider<Application> appProvider) {
    return new SharedPreferenceModule_ProvideSharedPreferenceUtilsFactory(module, appProvider);
  }

  public static SharedPreferenceUtils provideSharedPreferenceUtils(SharedPreferenceModule instance,
      Application app) {
    return Preconditions.checkNotNullFromProvides(instance.provideSharedPreferenceUtils(app));
  }
}
