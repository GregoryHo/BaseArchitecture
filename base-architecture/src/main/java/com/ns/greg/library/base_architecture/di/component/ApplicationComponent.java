package com.ns.greg.library.base_architecture.main.di.component;

import android.content.SharedPreferences;
import com.ns.greg.library.base_architecture.BaseActivity;
import com.ns.greg.library.base_architecture.main.di.module.ApplicationModule;
import com.ns.greg.library.base_architecture.main.di.module.SharedPreferenceModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @author Gregory
 * @since 2017/7/28
 */
@Singleton @Component(modules = { ApplicationModule.class, SharedPreferenceModule.class })
public interface ApplicationComponent {

  void inject(BaseActivity baseActivity);

  // Exposed to sub-graphs
  SharedPreferences sharedPreferences();
}
