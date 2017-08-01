package com.ns.greg.basearchitecture.di;

import com.ns.greg.basearchitecture.DemoActivity;
import com.ns.greg.library.base_architecture.main.di.PerActivity;
import com.ns.greg.library.base_architecture.main.di.component.ApplicationComponent;
import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * @author Gregory
 * @since 2017/7/31
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { OkHttpManagerModule.class })
public interface NetworkComponent {

  void inject(DemoActivity demoActivity);

  // Exposed to sub-graphs
  OkHttpClient okHttpClient();
}
