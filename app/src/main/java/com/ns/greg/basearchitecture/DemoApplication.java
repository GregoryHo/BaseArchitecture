package com.ns.greg.basearchitecture;

import com.ns.greg.basearchitecture.network.di.component.DaggerNetworkComponent;
import com.ns.greg.basearchitecture.network.di.component.NetworkComponent;
import com.ns.greg.basearchitecture.network.di.module.OkHttpClientModule;
import com.ns.greg.basearchitecture.network.di.module.OkHttpManagerModule;
import com.ns.greg.library.base_architecture.BaseApplication;

/**
 * @author Gregory
 * @since 2017/7/31
 */

public class DemoApplication extends BaseApplication {

  private NetworkComponent networkComponent;

  @Override public void onCreate() {
    super.onCreate();

    networkComponent = DaggerNetworkComponent.builder()
        .okHttpManagerModule(new OkHttpManagerModule())
        .okHttpClientModule(new OkHttpClientModule())
        .build();
  }

  public NetworkComponent getNetworkComponent() {
    return networkComponent;
  }
}
