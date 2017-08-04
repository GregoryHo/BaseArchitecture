package com.ns.greg.library.base_architecture.di.component;

import android.content.SharedPreferences;
import com.ns.greg.library.base_architecture.BaseActivity;
import com.ns.greg.library.base_architecture.di.module.ApplicationModule;
import com.ns.greg.library.base_architecture.di.module.SharedPreferenceModule;
import com.ns.greg.library.base_architecture.network.OkHttpManager;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @author Gregory
 * @since 2017/7/28
 */
@Singleton @Component(modules = { ApplicationModule.class, SharedPreferenceModule.class
}) public interface ApplicationComponent {

  void inject(BaseActivity baseActivity);

  // Exposed to sub-graphs
  SharedPreferences sharedPreferences();

  OkHttpManager okHttpManager();
}
