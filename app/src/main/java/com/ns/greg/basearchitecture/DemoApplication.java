package com.ns.greg.basearchitecture;

import com.ns.greg.basearchitecture.di.DaggerNetworkComponent;
import com.ns.greg.basearchitecture.di.NetworkComponent;
import com.ns.greg.basearchitecture.di.OkHttpManagerModule;
import com.ns.greg.library.base_architecture.main.BaseApplication;

/**
 * @author Gregory
 * @since 2017/7/31
 */

public class DemoApplication extends BaseApplication {

  private NetworkComponent networkComponent;

  @Override public void onCreate() {
    super.onCreate();

    networkComponent = DaggerNetworkComponent.builder()
        .applicationComponent(getApplicationComponent())
        .okHttpManagerModule(new OkHttpManagerModule())
        .build();
  }

  public NetworkComponent getNetworkComponent() {
    return networkComponent;
  }
}
