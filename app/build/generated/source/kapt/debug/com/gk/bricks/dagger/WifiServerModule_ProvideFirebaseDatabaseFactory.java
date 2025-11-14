package com.gk.bricks.dagger;

import com.google.firebase.database.FirebaseDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class WifiServerModule_ProvideFirebaseDatabaseFactory implements Factory<FirebaseDatabase> {
  private final WifiServerModule module;

  public WifiServerModule_ProvideFirebaseDatabaseFactory(WifiServerModule module) {
    this.module = module;
  }

  @Override
  public FirebaseDatabase get() {
    return provideFirebaseDatabase(module);
  }

  public static WifiServerModule_ProvideFirebaseDatabaseFactory create(WifiServerModule module) {
    return new WifiServerModule_ProvideFirebaseDatabaseFactory(module);
  }

  public static FirebaseDatabase provideFirebaseDatabase(WifiServerModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideFirebaseDatabase());
  }
}
