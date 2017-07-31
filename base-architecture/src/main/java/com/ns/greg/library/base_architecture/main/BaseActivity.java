package com.ns.greg.library.base_architecture.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import javax.inject.Inject;

/**
 * @author Gregory
 * @since 2017/7/28
 */
public class BaseActivity extends AppCompatActivity {

  @Inject SharedPreferences sharedPreference;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ((BaseApplication) getApplication()).component().inject(this);
  }

  protected SharedPreferences getSharedPreference() {
    return sharedPreference;
  }
}
