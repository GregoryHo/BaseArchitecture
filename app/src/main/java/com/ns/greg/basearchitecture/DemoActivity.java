package com.ns.greg.basearchitecture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.ns.greg.basearchitecture.di.component.DaggerDemoComponent;
import com.ns.greg.basearchitecture.di.component.DemoComponent;
import com.ns.greg.basearchitecture.di.module.ExecutorModule;
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
public class DemoActivity extends BaseActivity implements HasComponent<DemoComponent> {

  private DemoComponent demoComponent;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTheme(R.style.AppTheme);
    setContentView(R.layout.main_demo);

    // Extends from base-architecture
    sharedPreferenceDemo();
    networkDemo();

    demoComponent = DaggerDemoComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .executorModule(new ExecutorModule())
        .build();

    initViewPager();
  }

  private void networkDemo() {
    getOkHttpManager().request("https://www.yahoo.com");
  }

  private void sharedPreferenceDemo() {
    String demo = getSharedPreferenceManager().getString("DEMO", "");
    if (demo.isEmpty()) {
      getSharedPreferenceManager().putString("DEMO", "Dagger is interesting");
    }

    Toast.makeText(getApplicationContext(), demo, Toast.LENGTH_SHORT).show();
  }

  private void initViewPager() {
    List<Fragment> fragments = new ArrayList<>();
    fragments.add(new SignUpFragment());
    fragments.add(new LoginFragment());

    EasyViewPager viewPager = (EasyViewPager) findViewById(R.id.ViewPager);
    viewPager.setAdapter(new DemoAdapter(getSupportFragmentManager(), fragments));
  }

  @Override public DemoComponent getComponent() {
    return demoComponent;
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
