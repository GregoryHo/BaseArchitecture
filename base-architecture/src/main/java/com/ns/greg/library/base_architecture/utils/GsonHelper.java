package com.ns.greg.library.base_architecture.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

/**
 * @author Gregory
 * @since 2017/8/4
 */

public class GsonHelper {

  @NonNull public static String createJson(@NonNull Object object) {
    Gson gson = new GsonBuilder().serializeNulls().create();

    return gson.toJson(object);
  }

  @Nullable public static String createJsonWithTypeAdapter(@NonNull Object object, Class<?> aClass, TypeAdapter typeAdapter) {
    Gson gson = new GsonBuilder().serializeNulls()
        .registerTypeAdapter(aClass, typeAdapter)
        .create();

    return gson.toJson(object);
  }

  @Nullable public static <T> T parseJson(@Nullable String json, @NonNull Class<T> aClass)
      throws JsonSyntaxException {
    if (json == null || json.isEmpty()) {
      return null;
    }

    Gson gson = new GsonBuilder().serializeNulls().create();

    return gson.fromJson(json, aClass);
  }

  @Nullable public static <T> Map<String, T> parseJsonWithDynamicKey(@Nullable String json) {
    if (json == null || json.isEmpty()) {
      return null;
    }

    Gson gson = new GsonBuilder().serializeNulls().create();

    return gson.fromJson(json, new TypeToken<Map<String, T>>(){}.getType());
  }

  @Nullable public static <T> T parseJsonWithTypeAdapter(@Nullable String json, @NonNull Class<T> aClass, TypeAdapter typeAdapter) {
    if (json == null || json.isEmpty()) {
      return null;
    }

    Gson gson = new GsonBuilder().serializeNulls()
        .registerTypeAdapter(aClass, typeAdapter)
        .create();

    return gson.fromJson(json, aClass);
  }
}
