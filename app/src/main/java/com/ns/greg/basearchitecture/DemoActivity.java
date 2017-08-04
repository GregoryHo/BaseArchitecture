package com.ns.greg.basearchitecture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.ns.greg.basearchitecture.hook.di.component.DaggerExecutorComponent;
import com.ns.greg.basearchitecture.hook.di.component.ExecutorComponent;
import com.ns.greg.basearchitecture.hook.di.module.ExecutorModule;
import com.ns.greg.basearchitecture.user.LoginFragment;
import com.ns.greg.basearchitecture.user.SignUpFragment;
import com.ns.greg.library.base_architecture.BaseActivity;
import com.ns.greg.library.base_architecture.di.HasComponent;
import com.ns.greg.library.easy_viewpager.EasyViewPager;
import com.ns.greg.library.easy_viewpager.adapter.BaseFragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/7/31
 */
public class DemoActivity extends BaseActivity implements HasComponent<ExecutorComponent> {

  private ExecutorComponent executorComponent;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTheme(R.style.AppTheme);
    setContentView(R.layout.main_demo);

    // Extends from base-architecture
    String demo = getApplicationComponent().sharedPreferences().getString("DEMO", "");
    if (demo.isEmpty()) {
      getSharedPreference().edit().putString("DEMO", "Dagger is interesting").apply();
    }

    Toast.makeText(getApplicationContext(), demo, Toast.LENGTH_SHORT).show();

    executorComponent = DaggerExecutorComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .executorModule(new ExecutorModule())
        .build();

    initViewPager();
  }

  private void initViewPager() {
    List<Fragment> fragments = new ArrayList<>();
    fragments.add(new SignUpFragment());
    fragments.add(new LoginFragment());

    EasyViewPager viewPager = (EasyViewPager) findViewById(R.id.ViewPager);
    viewPager.setAdapter(new DemoAdapter(getSupportFragmentManager(), fragments));
  }

  @Override public ExecutorComponent getComponent() {
    return executorComponent;
  }

  private static class DemoAdapter extends BaseFragmentStatePagerAdapter {

    DemoAdapter(FragmentManager fm) {
      super(fm);
    }

    DemoAdapter(FragmentManager fm, Fragment fragment) {
      super(fm, fragment);
    }

    DemoAdapter(FragmentManager fm, List<Fragment> fragments) {
      super(fm, fragments);
    }
  }
}
