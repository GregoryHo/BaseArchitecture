package com.ns.greg.library.base_architecture.di.module;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author Gregory
 * @since 2017/7/28
 */
@Module public class ApplicationModule {

  private final Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides @Singleton Context providesApplicationContext() {
    return application;
  }
}
