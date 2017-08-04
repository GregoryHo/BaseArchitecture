package com.ns.greg.library.base_architecture.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author Gregory
 * @since 2017/8/4
 */
@Module(includes = ApplicationModule.class) public class SharedPreferenceModule {

  @Provides @Singleton SharedPreferences providesSharedPreferences(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context);
  }
}
