package com.ns.greg.basearchitecture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.ns.greg.library.base_architecture.main.BaseActivity;

/**
 * @author Gregory
 * @since 2017/7/31
 */
public class DemoActivity extends BaseActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_demo);

    String demo = getSharedPreference().getString("DEMO", "");
    if (demo.isEmpty()) {
      getSharedPreference().edit().putString("DEMO", "Dagger!").apply();
    }

    ((TextView) findViewById(R.id.tv_demo)).setText(demo);
  }
}
