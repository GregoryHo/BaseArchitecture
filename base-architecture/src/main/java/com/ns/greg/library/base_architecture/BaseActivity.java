package com.ns.greg.library.base_architecture;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.ns.greg.library.base_architecture.di.component.ApplicationComponent;
import com.ns.greg.library.base_architecture.di.module.ActivityModule;
import com.ns.greg.library.base_architecture.network.OkHttpManager;

/**
 * @author Gregory
 * @since 2017/7/28
 */
public class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getApplicationComponent().inject(this);

    networkDemo();
  }

  private void networkDemo() {
    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0) {
        getOkHttpManager().request("https://www.yahoo.com");
      } else {
        getOkHttpManager().request("https://www.google.com");
      }
    }
  }

  protected ApplicationComponent getApplicationComponent() {
    return ((BaseApplication) getApplication()).getApplicationComponent();
  }

  protected OkHttpManager getOkHttpManager() {
    return getApplicationComponent().okHttpManager();
  }

  protected SharedPreferences getSharedPreference() {
    return getApplicationComponent().sharedPreferences();
  }

  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }
}
