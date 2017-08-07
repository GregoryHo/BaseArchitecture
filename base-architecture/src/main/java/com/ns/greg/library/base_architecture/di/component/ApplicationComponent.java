package com.ns.greg.library.base_architecture.di.component;

import com.ns.greg.library.base_architecture.BaseActivity;
import com.ns.greg.library.base_architecture.di.module.ApplicationModule;
import com.ns.greg.library.base_architecture.di.module.SharedPreferenceModule;
import com.ns.greg.library.base_architecture.module.OkHttpManager;
import com.ns.greg.library.base_architecture.module.SharedPreferenceManager;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @author Gregory
 * @since 2017/7/28
 */
@Singleton @Component(modules = { ApplicationModule.class, SharedPreferenceModule.class })
public interface ApplicationComponent {

  void inject(BaseActivity baseActivity);

  /*--------------------------------
   * Exposed to sub-graphs
   *-------------------------------*/

  SharedPreferenceManager sharedPreferenceManger();

  OkHttpManager okHttpManager();
}
