package com.ns.greg.library.base_architecture.main.di.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author Gregory
 * @since 2017/7/31
 */
@Module(includes = ApplicationModule.class) public class SharedPreferenceModule {

  @Provides @Singleton SharedPreferences providesSharedPreference(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context);
  }
}
