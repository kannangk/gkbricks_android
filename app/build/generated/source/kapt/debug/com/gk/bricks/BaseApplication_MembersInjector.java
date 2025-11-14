package com.gk.bricks;

import androidx.hilt.work.HiltWorkerFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class BaseApplication_MembersInjector implements MembersInjector<BaseApplication> {
  private final Provider<HiltWorkerFactory> workerFactoryProvider;

  public BaseApplication_MembersInjector(Provider<HiltWorkerFactory> workerFactoryProvider) {
    this.workerFactoryProvider = workerFactoryProvider;
  }

  public static MembersInjector<BaseApplication> create(
      Provider<HiltWorkerFactory> workerFactoryProvider) {
    return new BaseApplication_MembersInjector(workerFactoryProvider);
  }

  @Override
  public void injectMembers(BaseApplication instance) {
    injectWorkerFactory(instance, workerFactoryProvider.get());
  }

  @InjectedFieldSignature("com.gk.bricks.BaseApplication.workerFactory")
  public static void injectWorkerFactory(BaseApplication instance,
      HiltWorkerFactory workerFactory) {
    instance.workerFactory = workerFactory;
  }
}
