package com.ns.greg.library.base_architecture.di.component;

import com.ns.greg.library.base_architecture.BaseActivity;
import com.ns.greg.library.base_architecture.di.PerActivity;
import com.ns.greg.library.base_architecture.di.module.ActivityModule;
import dagger.Component;

/**
 * @author Gregory
 * @since 2017/8/1
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  // Exposed to sub-graphs
  BaseActivity activity();
}
