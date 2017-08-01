package com.ns.greg.basearchitecture.di;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * @author Gregory
 * @since 2017/7/31
 */
@Module public class OkHttpClientModule {

  @Provides OkHttpClient providesOkHttpClient() {
    return new OkHttpClient();
  }
}
