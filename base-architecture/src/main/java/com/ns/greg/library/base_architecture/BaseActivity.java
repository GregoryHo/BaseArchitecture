package com.ns.greg.library.base_architecture;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.ns.greg.library.base_architecture.main.di.component.ApplicationComponent;
import com.ns.greg.library.base_architecture.main.di.module.ActivityModule;

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

  protected SharedPreferences getSharedPreference() {
    return getApplicationComponent().sharedPreferences();
  }

  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }
}