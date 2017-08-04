package com.ns.greg.basearchitecture.di.component;

import com.ns.greg.basearchitecture.di.module.ExecutorModule;
import com.ns.greg.basearchitecture.user.SignUpFragment;
import com.ns.greg.library.base_architecture.di.PerActivity;
import com.ns.greg.library.base_architecture.di.component.ActivityComponent;
import com.ns.greg.library.base_architecture.di.component.ApplicationComponent;
import com.ns.greg.library.base_architecture.di.module.ActivityModule;
import dagger.Component;

/**
 * @author Gregory
 * @since 2017/8/4
 */
@PerActivity @Component(dependencies = ApplicationComponent.class, modules = {
    ActivityModule.class, ExecutorModule.class
}) public interface DemoComponent extends ActivityComponent {

  void inject(SignUpFragment signUpFragment);
}
