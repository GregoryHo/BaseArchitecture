package com.ns.greg.basearchitecture.hook.di.module;

import com.ns.greg.basearchitecture.hook.ThreadExecutor;
import com.ns.greg.library.base_architecture.di.PerActivity;
import dagger.Module;
import dagger.Provides;

/**
 * @author Gregory
 * @since 2017/8/4
 */
@Module public class ExecutorModule {

  @Provides @PerActivity ThreadExecutor providesThreadExecutor() {
    return new ThreadExecutor();
  }
}
