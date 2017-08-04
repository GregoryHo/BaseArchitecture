package com.ns.greg.library.base_architecture.di.module;

import com.ns.greg.library.base_architecture.BaseActivity;
import com.ns.greg.library.base_architecture.di.PerActivity;
import dagger.Module;
import dagger.Provides;

/**
 * @author Gregory
 * @since 2017/8/1
 */
@Module public class ActivityModule {

  private BaseActivity activity;

  public ActivityModule(BaseActivity activity) {
    this.activity = activity;
  }

  @Provides @PerActivity BaseActivity providesActivity() {
    return activity;
  }
}
