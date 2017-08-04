package com.ns.greg.basearchitecture.hook;

import com.ns.greg.library.fasthook.BaseRunnable;
import com.ns.greg.library.fasthook.BaseThreadManager;
import com.ns.greg.library.fasthook.BaseThreadTask;
import com.ns.greg.library.fasthook.ThreadExecutorFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Gregory
 * @since 2017/8/3
 */
public class ThreadExecutor extends BaseThreadManager<ThreadPoolExecutor> {

  @Override protected ThreadPoolExecutor createThreadPool() {
    return ThreadExecutorFactory.newCoreSizeThreadPool();
  }

  @Override protected BaseThreadTask createBaseThreadTask(BaseRunnable job) {
    return new BaseThreadTask(job);
  }
}
