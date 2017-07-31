package com.ns.greg.library.base_architecture.main.dagger;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author Gregory
 * @since 2017/7/28
 */
@Module public class AndroidModule {

  private final Context application;

  public AndroidModule(Context application) {
    this.application = application;
  }

  @Provides @Singleton Context providesContext() {
    return application;
  }
}
