package com.ns.greg.basearchitecture.network.di.component;

import com.ns.greg.basearchitecture.DemoActivity;
import com.ns.greg.basearchitecture.network.di.module.OkHttpClientModule;
import com.ns.greg.basearchitecture.network.di.module.OkHttpManagerModule;
import com.ns.greg.library.base_architecture.main.di.PerActivity;
import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * @author Gregory
 * @since 2017/7/31
 */
@PerActivity @Component(modules = {
    OkHttpClientModule.class, OkHttpManagerModule.class
}) public interface NetworkComponent {

  void inject(DemoActivity demoActivity);

  // Exposed to sub-graphs
  OkHttpClient okHttpClient();
}
