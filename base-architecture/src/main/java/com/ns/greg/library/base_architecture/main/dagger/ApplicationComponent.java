package com.ns.greg.library.base_architecture.main.dagger;

import com.ns.greg.library.base_architecture.main.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @author Gregory
 * @since 2017/7/28
 */
@Singleton
@Component(modules = { AndroidModule.class, SharedPreferenceModule.class })
public interface ApplicationComponent {

  void inject(BaseActivity baseActivity);
}
