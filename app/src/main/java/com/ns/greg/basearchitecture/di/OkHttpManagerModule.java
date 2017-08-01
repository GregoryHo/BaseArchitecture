package com.ns.greg.basearchitecture.di;

import com.ns.greg.basearchitecture.network.OkHttpManager;
import com.ns.greg.library.base_architecture.main.di.PerActivity;
import dagger.Module;
import dagger.Provides;

/**
 * @author Gregory
 * @since 2017/7/31
 */
@Module(includes = OkHttpClientModule.class) public class OkHttpManagerModule {

  @Provides @PerActivity OkHttpManager providesOkHttpManager() {
    return new OkHttpManager();
  }
}
