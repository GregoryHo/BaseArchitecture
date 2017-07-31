package com.ns.greg.library.base_architecture.main;

import android.app.Application;
import com.ns.greg.library.base_architecture.main.dagger.AndroidModule;
import com.ns.greg.library.base_architecture.main.dagger.ApplicationComponent;
import com.ns.greg.library.base_architecture.main.dagger.DaggerApplicationComponent;
import com.ns.greg.library.base_architecture.main.dagger.SharedPreferenceModule;

/**
 * @author Gregory
 * @since 2017/7/28
 */
public class BaseApplication extends Application {

  private final ApplicationComponent applicationComponent = createComponent();

  @Override public void onCreate() {
    super.onCreate();
  }

  private ApplicationComponent createComponent() {
    return DaggerApplicationComponent.builder()
        .androidModule(new AndroidModule(this))
        .sharedPreferenceModule(new SharedPreferenceModule())
        .build();
  }

  public ApplicationComponent component() {
    return applicationComponent;
  }
}
