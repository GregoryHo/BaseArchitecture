package com.ns.greg.library.base_architecture.main.di.module;

import android.app.Activity;
import com.ns.greg.library.base_architecture.main.di.PerActivity;
import dagger.Module;
import dagger.Provides;

/**
 * @author Gregory
 * @since 2017/8/1
 */
@Module public class ActivityModule {

  private Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides @PerActivity Activity providesActivity() {
    return activity;
  }
}
