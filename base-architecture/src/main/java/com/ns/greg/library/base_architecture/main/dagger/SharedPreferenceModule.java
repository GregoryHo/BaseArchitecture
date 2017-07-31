package com.ns.greg.library.base_architecture.main.dagger;

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
@Module(includes = AndroidModule.class) public class SharedPreferenceModule {

  @Provides @Singleton SharedPreferences providesSharedPreference(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context);
  }
}
