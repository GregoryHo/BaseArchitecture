package com.ns.greg.library.base_architecture.main;

import android.app.Application;
import com.ns.greg.library.base_architecture.main.di.component.ApplicationComponent;
import com.ns.greg.library.base_architecture.main.di.component.DaggerApplicationComponent;
import com.ns.greg.library.base_architecture.main.di.module.ApplicationModule;
import com.ns.greg.library.base_architecture.main.di.module.SharedPreferenceModule;

/**
 * @author Gregory
 * @since 2017/7/28
 */
public class BaseApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();

    applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .sharedPreferenceModule(new SharedPreferenceModule())
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
