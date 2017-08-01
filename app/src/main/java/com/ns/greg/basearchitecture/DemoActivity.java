package com.ns.greg.basearchitecture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.ns.greg.basearchitecture.di.NetworkComponent;
import com.ns.greg.basearchitecture.network.OkHttpManager;
import com.ns.greg.library.base_architecture.main.BaseActivity;
import javax.inject.Inject;

/**
 * @author Gregory
 * @since 2017/7/31
 */
public class DemoActivity extends BaseActivity {

  @Inject OkHttpManager okHttpManager;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_demo);

    String demo = getApplicationComponent().sharedPreferences().getString("DEMO", "");
    if (demo.isEmpty()) {
      getSharedPreference().edit().putString("DEMO", "Dagger!").apply();
    }

    ((TextView) findViewById(R.id.tv_demo)).setText(demo);

    getNetworkComponent().inject(this);
    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0) {
        okHttpManager.request("https://www.yahoo.com", getNetworkComponent().okHttpClient());
      } else {
        okHttpManager.request("https://www.google.com", getNetworkComponent().okHttpClient());
      }
    }
  }

  protected NetworkComponent getNetworkComponent() {
    return ((DemoApplication) getApplication()).getNetworkComponent();
  }
}
