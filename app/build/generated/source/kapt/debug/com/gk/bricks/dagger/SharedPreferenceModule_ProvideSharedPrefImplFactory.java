package com.gk.bricks.dagger;

import com.gk.bricks.datasource.SharedPrefDelegate;
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
public final class SharedPreferenceModule_ProvideSharedPrefImplFactory implements Factory<SharedPrefDelegate> {
  private final SharedPreferenceModule module;

  private final Provider<SharedPreferenceUtils> sharedPreferenceUtilsProvider;

  public SharedPreferenceModule_ProvideSharedPrefImplFactory(SharedPreferenceModule module,
      Provider<SharedPreferenceUtils> sharedPreferenceUtilsProvider) {
    this.module = module;
    this.sharedPreferenceUtilsProvider = sharedPreferenceUtilsProvider;
  }

  @Override
  public SharedPrefDelegate get() {
    return provideSharedPrefImpl(module, sharedPreferenceUtilsProvider.get());
  }

  public static SharedPreferenceModule_ProvideSharedPrefImplFactory create(
      SharedPreferenceModule module,
      Provider<SharedPreferenceUtils> sharedPreferenceUtilsProvider) {
    return new SharedPreferenceModule_ProvideSharedPrefImplFactory(module, sharedPreferenceUtilsProvider);
  }

  public static SharedPrefDelegate provideSharedPrefImpl(SharedPreferenceModule instance,
      SharedPreferenceUtils sharedPreferenceUtils) {
    return Preconditions.checkNotNullFromProvides(instance.provideSharedPrefImpl(sharedPreferenceUtils));
  }
}
