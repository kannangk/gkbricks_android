package com.gk.bricks;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.hilt.work.WorkerAssistedFactory;
import androidx.hilt.work.WorkerFactoryModule_ProvideFactoryFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.work.ListenableWorker;
import com.gk.bricks.dagger.HotspotManagerModule;
import com.gk.bricks.dagger.HotspotManagerModule_ProvideHotspotManagerModuleFactory;
import com.gk.bricks.dagger.SharedPreferenceModule;
import com.gk.bricks.dagger.SharedPreferenceModule_ProvideSharedPrefImplFactory;
import com.gk.bricks.dagger.SharedPreferenceModule_ProvideSharedPreferenceUtilsFactory;
import com.gk.bricks.dagger.WifiServerModule;
import com.gk.bricks.dagger.WifiServerModule_ProvideFirebaseDatabaseFactory;
import com.gk.bricks.dagger.WifiServerModule_ProvideFirebaseInterfaceFactory;
import com.gk.bricks.dagger.WifiServerModule_ProvideWifiLopModuleFactory;
import com.gk.bricks.dagger.WifiServerModule_ProvideWifiServerModuleFactory;
import com.gk.bricks.datasource.SharedPrefDelegate;
import com.gk.bricks.datasource.SharedPreferenceUtils;
import com.gk.bricks.datasource.firebase.FirebaseInterface;
import com.gk.bricks.fragment.delivery.AddChamberUnloadingLogsFragment;
import com.gk.bricks.fragment.delivery.AddVendorFragment;
import com.gk.bricks.fragment.delivery.AddVendorLogsFragment;
import com.gk.bricks.fragment.delivery.ChamberIndiviualFragment;
import com.gk.bricks.fragment.delivery.ChamberLoadingListFragment;
import com.gk.bricks.fragment.delivery.ChamberUnLoadingListFragment;
import com.gk.bricks.fragment.delivery.ChamberUnloadingIndiviualFragment;
import com.gk.bricks.fragment.delivery.DeliveryHomeFragment;
import com.gk.bricks.fragment.delivery.VendorIndiviualFragment;
import com.gk.bricks.fragment.delivery.VendorListFragment;
import com.gk.bricks.fragment.employee.AddLabourFragment;
import com.gk.bricks.fragment.employee.AllEmployeeListFragment;
import com.gk.bricks.fragment.employee.EmployeeHomeFragment;
import com.gk.bricks.fragment.employee.EmployeeListFragment;
import com.gk.bricks.fragment.employee.EmployeeSalaryIndiviualFragment;
import com.gk.bricks.fragment.employee.EmployeeWorkUpdateFragment;
import com.gk.bricks.fragment.production.HomeFragment;
import com.gk.bricks.fragment.production.ProductionHistoryFragment;
import com.gk.bricks.fragment.production.SettingsFragment;
import com.gk.bricks.managers.HotspotManager;
import com.gk.bricks.viewmodel.MainNavViewModel;
import com.gk.bricks.viewmodel.MainNavViewModel_HiltModules_KeyModule_ProvideFactory;
import com.gk.bricks.viewmodel.MainViewModel;
import com.gk.bricks.viewmodel.MainViewModel_HiltModules_KeyModule_ProvideFactory;
import com.gk.bricks.wifi.WifiLopInterface;
import com.gk.bricks.wifi.WifiServerInterface;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.database.FirebaseDatabase;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DaggerBaseApplication_HiltComponents_SingletonC {
  private DaggerBaseApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private HotspotManagerModule hotspotManagerModule;

    private SharedPreferenceModule sharedPreferenceModule;

    private WifiServerModule wifiServerModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public Builder hotspotManagerModule(HotspotManagerModule hotspotManagerModule) {
      this.hotspotManagerModule = Preconditions.checkNotNull(hotspotManagerModule);
      return this;
    }

    public Builder sharedPreferenceModule(SharedPreferenceModule sharedPreferenceModule) {
      this.sharedPreferenceModule = Preconditions.checkNotNull(sharedPreferenceModule);
      return this;
    }

    public Builder wifiServerModule(WifiServerModule wifiServerModule) {
      this.wifiServerModule = Preconditions.checkNotNull(wifiServerModule);
      return this;
    }

    public BaseApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      if (hotspotManagerModule == null) {
        this.hotspotManagerModule = new HotspotManagerModule();
      }
      if (sharedPreferenceModule == null) {
        this.sharedPreferenceModule = new SharedPreferenceModule();
      }
      if (wifiServerModule == null) {
        this.wifiServerModule = new WifiServerModule();
      }
      return new SingletonCImpl(applicationContextModule, hotspotManagerModule, sharedPreferenceModule, wifiServerModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements BaseApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public BaseApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements BaseApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public BaseApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements BaseApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public BaseApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements BaseApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public BaseApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements BaseApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public BaseApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements BaseApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public BaseApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements BaseApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public BaseApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends BaseApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends BaseApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectAddChamberUnloadingLogsFragment(AddChamberUnloadingLogsFragment arg0) {
    }

    @Override
    public void injectAddVendorFragment(AddVendorFragment arg0) {
    }

    @Override
    public void injectAddVendorLogsFragment(AddVendorLogsFragment arg0) {
    }

    @Override
    public void injectChamberIndiviualFragment(ChamberIndiviualFragment arg0) {
    }

    @Override
    public void injectChamberLoadingListFragment(ChamberLoadingListFragment arg0) {
    }

    @Override
    public void injectChamberUnLoadingListFragment(ChamberUnLoadingListFragment arg0) {
    }

    @Override
    public void injectChamberUnloadingIndiviualFragment(ChamberUnloadingIndiviualFragment arg0) {
    }

    @Override
    public void injectDeliveryHomeFragment(DeliveryHomeFragment arg0) {
    }

    @Override
    public void injectVendorIndiviualFragment(VendorIndiviualFragment arg0) {
    }

    @Override
    public void injectVendorListFragment(VendorListFragment arg0) {
    }

    @Override
    public void injectAddLabourFragment(AddLabourFragment arg0) {
    }

    @Override
    public void injectAllEmployeeListFragment(AllEmployeeListFragment arg0) {
    }

    @Override
    public void injectEmployeeHomeFragment(EmployeeHomeFragment arg0) {
    }

    @Override
    public void injectEmployeeListFragment(EmployeeListFragment arg0) {
    }

    @Override
    public void injectEmployeeSalaryIndiviualFragment(EmployeeSalaryIndiviualFragment arg0) {
    }

    @Override
    public void injectEmployeeWorkUpdateFragment(EmployeeWorkUpdateFragment arg0) {
    }

    @Override
    public void injectHomeFragment(HomeFragment arg0) {
    }

    @Override
    public void injectProductionHistoryFragment(ProductionHistoryFragment arg0) {
    }

    @Override
    public void injectSettingsFragment(SettingsFragment arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends BaseApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends BaseApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectDeliveryMainActivity(DeliveryMainActivity arg0) {
    }

    @Override
    public void injectEmployeeMainActivity(EmployeeMainActivity arg0) {
    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
    }

    @Override
    public void injectProductionMainActivity(ProductionMainActivity arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return ImmutableSet.<String>of(MainNavViewModel_HiltModules_KeyModule_ProvideFactory.provide(), MainViewModel_HiltModules_KeyModule_ProvideFactory.provide());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends BaseApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<MainNavViewModel> mainNavViewModelProvider;

    private Provider<MainViewModel> mainViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.mainNavViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.mainViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return ImmutableMap.<String, Provider<ViewModel>>of("com.gk.bricks.viewmodel.MainNavViewModel", ((Provider) mainNavViewModelProvider), "com.gk.bricks.viewmodel.MainViewModel", ((Provider) mainViewModelProvider));
    }

    @Override
    public Map<String, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<String, Object>of();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.gk.bricks.viewmodel.MainNavViewModel 
          return (T) new MainNavViewModel(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule), singletonCImpl.provideWifiServerModuleProvider.get(), singletonCImpl.provideFirebaseInterfaceProvider.get(), singletonCImpl.provideHotspotManagerModuleProvider.get());

          case 1: // com.gk.bricks.viewmodel.MainViewModel 
          return (T) new MainViewModel(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule), singletonCImpl.provideWifiServerModuleProvider.get(), singletonCImpl.provideFirebaseInterfaceProvider.get(), singletonCImpl.provideWifiLopModuleProvider.get(), singletonCImpl.provideSharedPrefImplProvider.get(), singletonCImpl.provideHotspotManagerModuleProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends BaseApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends BaseApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends BaseApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final WifiServerModule wifiServerModule;

    private final SharedPreferenceModule sharedPreferenceModule;

    private final HotspotManagerModule hotspotManagerModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<WifiServerInterface> provideWifiServerModuleProvider;

    private Provider<FirebaseDatabase> provideFirebaseDatabaseProvider;

    private Provider<SharedPreferenceUtils> provideSharedPreferenceUtilsProvider;

    private Provider<SharedPrefDelegate> provideSharedPrefImplProvider;

    private Provider<FirebaseInterface> provideFirebaseInterfaceProvider;

    private Provider<HotspotManager> provideHotspotManagerModuleProvider;

    private Provider<WifiLopInterface> provideWifiLopModuleProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam,
        HotspotManagerModule hotspotManagerModuleParam,
        SharedPreferenceModule sharedPreferenceModuleParam,
        WifiServerModule wifiServerModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      this.wifiServerModule = wifiServerModuleParam;
      this.sharedPreferenceModule = sharedPreferenceModuleParam;
      this.hotspotManagerModule = hotspotManagerModuleParam;
      initialize(applicationContextModuleParam, hotspotManagerModuleParam, sharedPreferenceModuleParam, wifiServerModuleParam);

    }

    private HiltWorkerFactory hiltWorkerFactory() {
      return WorkerFactoryModule_ProvideFactoryFactory.provideFactory(ImmutableMap.<String, Provider<WorkerAssistedFactory<? extends ListenableWorker>>>of());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam,
        final HotspotManagerModule hotspotManagerModuleParam,
        final SharedPreferenceModule sharedPreferenceModuleParam,
        final WifiServerModule wifiServerModuleParam) {
      this.provideWifiServerModuleProvider = DoubleCheck.provider(new SwitchingProvider<WifiServerInterface>(singletonCImpl, 0));
      this.provideFirebaseDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseDatabase>(singletonCImpl, 2));
      this.provideSharedPreferenceUtilsProvider = DoubleCheck.provider(new SwitchingProvider<SharedPreferenceUtils>(singletonCImpl, 4));
      this.provideSharedPrefImplProvider = DoubleCheck.provider(new SwitchingProvider<SharedPrefDelegate>(singletonCImpl, 3));
      this.provideFirebaseInterfaceProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseInterface>(singletonCImpl, 1));
      this.provideHotspotManagerModuleProvider = DoubleCheck.provider(new SwitchingProvider<HotspotManager>(singletonCImpl, 5));
      this.provideWifiLopModuleProvider = DoubleCheck.provider(new SwitchingProvider<WifiLopInterface>(singletonCImpl, 6));
    }

    @Override
    public void injectBaseApplication(BaseApplication baseApplication) {
      injectBaseApplication2(baseApplication);
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    @CanIgnoreReturnValue
    private BaseApplication injectBaseApplication2(BaseApplication instance) {
      BaseApplication_MembersInjector.injectWorkerFactory(instance, hiltWorkerFactory());
      return instance;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.gk.bricks.wifi.WifiServerInterface 
          return (T) WifiServerModule_ProvideWifiServerModuleFactory.provideWifiServerModule(singletonCImpl.wifiServerModule, ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 1: // com.gk.bricks.datasource.firebase.FirebaseInterface 
          return (T) WifiServerModule_ProvideFirebaseInterfaceFactory.provideFirebaseInterface(singletonCImpl.wifiServerModule, singletonCImpl.provideFirebaseDatabaseProvider.get(), singletonCImpl.provideSharedPrefImplProvider.get());

          case 2: // com.google.firebase.database.FirebaseDatabase 
          return (T) WifiServerModule_ProvideFirebaseDatabaseFactory.provideFirebaseDatabase(singletonCImpl.wifiServerModule);

          case 3: // com.gk.bricks.datasource.SharedPrefDelegate 
          return (T) SharedPreferenceModule_ProvideSharedPrefImplFactory.provideSharedPrefImpl(singletonCImpl.sharedPreferenceModule, singletonCImpl.provideSharedPreferenceUtilsProvider.get());

          case 4: // com.gk.bricks.datasource.SharedPreferenceUtils 
          return (T) SharedPreferenceModule_ProvideSharedPreferenceUtilsFactory.provideSharedPreferenceUtils(singletonCImpl.sharedPreferenceModule, ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 5: // com.gk.bricks.managers.HotspotManager 
          return (T) HotspotManagerModule_ProvideHotspotManagerModuleFactory.provideHotspotManagerModule(singletonCImpl.hotspotManagerModule, ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          case 6: // com.gk.bricks.wifi.WifiLopInterface 
          return (T) WifiServerModule_ProvideWifiLopModuleFactory.provideWifiLopModule(singletonCImpl.wifiServerModule, ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonCImpl.applicationContextModule));

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
