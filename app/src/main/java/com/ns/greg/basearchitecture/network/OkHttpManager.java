package com.ns.greg.basearchitecture.network;

import android.support.annotation.NonNull;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Gregory
 * @since 2017/7/31
 */
public class OkHttpManager {

  public void request(String url, OkHttpClient okHttpClient) {
    HttpUrl httpUrl = HttpUrl.parse(url);
    if (httpUrl == null) {
      return;
    }

    Request request = new Request.Builder().url(httpUrl.toString()).build();
    okHttpClient.newCall(request).enqueue(new Callback() {
      @Override public void onFailure(@NonNull Call call, @NonNull IOException e) {
        System.out.println("onFailure, " + "call: [" + call + "], e: [" + e + "]");
      }

      @Override public void onResponse(@NonNull Call call, @NonNull Response response)
          throws IOException {
        System.out.println("onResponse, " + "call: [" + call + "], response: [" + response + "]");
      }
    });
  }
}
