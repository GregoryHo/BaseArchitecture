package com.ns.greg.basearchitecture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.ns.greg.basearchitecture.network.di.component.NetworkComponent;
import com.ns.greg.basearchitecture.network.OkHttpManager;
import com.ns.greg.library.base_architecture.BaseActivity;
import javax.inject.Inject;

/**
 * @author Gregory
 * @since 2017/7/31
 */
public class DemoActivity extends BaseActivity {

  @Inject OkHttpManager okHttpManager;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTheme(R.style.AppTheme);
    setContentView(R.layout.main_demo);

    // Extends from base-architecture
    String demo = getApplicationComponent().sharedPreferences().getString("DEMO", "");
    if (demo.isEmpty()) {
      getSharedPreference().edit().putString("DEMO", "Dagger is interesting").apply();
    }

    ((TextView) findViewById(R.id.tv_demo)).setText(demo);

    // Custom dependencies
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
