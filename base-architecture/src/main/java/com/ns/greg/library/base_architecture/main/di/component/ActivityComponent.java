package com.ns.greg.library.base_architecture.main.di.component;

import android.app.Activity;
import com.ns.greg.library.base_architecture.main.di.PerActivity;
import com.ns.greg.library.base_architecture.main.di.module.ActivityModule;
import dagger.Component;

/**
 * @author Gregory
 * @since 2017/8/1
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  // Exposed to sub-graphs
  Activity activity();
}
