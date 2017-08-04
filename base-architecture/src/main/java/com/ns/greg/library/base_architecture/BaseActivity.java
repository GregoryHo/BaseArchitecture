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
  }

  protected ApplicationComponent getApplicationComponent() {
    return ((BaseApplication) getApplication()).getApplicationComponent();
  }

  public SharedPreferences getSharedPreference() {
    return getApplicationComponent().sharedPreferences();
  }

  public OkHttpManager getOkHttpManager() {
    return getApplicationComponent().okHttpManager();
  }

  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }
}
