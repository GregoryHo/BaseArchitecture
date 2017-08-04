package com.ns.greg.library.base_architecture;

import android.app.Application;
import com.ns.greg.library.base_architecture.di.component.ApplicationComponent;
import com.ns.greg.library.base_architecture.di.component.DaggerApplicationComponent;
import com.ns.greg.library.base_architecture.di.module.ApplicationModule;

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
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
