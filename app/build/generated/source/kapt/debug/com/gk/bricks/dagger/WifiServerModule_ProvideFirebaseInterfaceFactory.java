package com.gk.bricks.dagger;

import com.gk.bricks.datasource.SharedPrefDelegate;
import com.gk.bricks.datasource.firebase.FirebaseInterface;
import com.google.firebase.database.FirebaseDatabase;
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
public final class WifiServerModule_ProvideFirebaseInterfaceFactory implements Factory<FirebaseInterface> {
  private final WifiServerModule module;

  private final Provider<FirebaseDatabase> databaseProvider;

  private final Provider<SharedPrefDelegate> dataSourceProvider;

  public WifiServerModule_ProvideFirebaseInterfaceFactory(WifiServerModule module,
      Provider<FirebaseDatabase> databaseProvider,
      Provider<SharedPrefDelegate> dataSourceProvider) {
    this.module = module;
    this.databaseProvider = databaseProvider;
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public FirebaseInterface get() {
    return provideFirebaseInterface(module, databaseProvider.get(), dataSourceProvider.get());
  }

  public static WifiServerModule_ProvideFirebaseInterfaceFactory create(WifiServerModule module,
      Provider<FirebaseDatabase> databaseProvider,
      Provider<SharedPrefDelegate> dataSourceProvider) {
    return new WifiServerModule_ProvideFirebaseInterfaceFactory(module, databaseProvider, dataSourceProvider);
  }

  public static FirebaseInterface provideFirebaseInterface(WifiServerModule instance,
      FirebaseDatabase database, SharedPrefDelegate dataSource) {
    return Preconditions.checkNotNullFromProvides(instance.provideFirebaseInterface(database, dataSource));
  }
}
