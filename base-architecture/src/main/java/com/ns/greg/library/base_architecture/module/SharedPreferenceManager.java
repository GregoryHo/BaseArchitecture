package com.ns.greg.library.base_architecture.module;

import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Gregory
 * @since 2017/8/4
 */
@Singleton public class SharedPreferenceManager {

  private SharedPreferences sharedPreferences;

  @Inject SharedPreferenceManager(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  /**
   * Gets the String from {@link SharedPreferences}
   * with specific key
   *
   * @param key specific key
   * @param defaultValue default value
   */
  public String getString(String key, String defaultValue) {
    return sharedPreferences.getString(key, defaultValue);
  }

  /**
   * Sets the String into {@link SharedPreferences}
   *
   * @param key specific key
   * @param value stored value
   */
  public void setString(String key, String value) {
    sharedPreferences.edit().putString(key, value).apply();
  }

  /**
   * Gets the boolean form {@link SharedPreferences}
   * with specific key
   *
   * @param key specific key
   * @param defaultValue default value
   */
  public boolean getBoolean(String key, boolean defaultValue) {
    return sharedPreferences.getBoolean(key, defaultValue);
  }

  /**
   * Sets the boolean into {@link SharedPreferences}
   *
   * @param key specific key
   * @param value stored value
   */
  public void setBoolean(String key, boolean value) {
    sharedPreferences.edit().putBoolean(key, value).apply();
  }

  /**
   * Gets the Integer form {@link SharedPreferences}
   * with specific key
   *
   * @param key specific key
   * @param defaultValue default value
   */
  public int getInt(String key, int defaultValue) {
    return sharedPreferences.getInt(key, defaultValue);
  }

  /**
   * Sets the Integer into {@link SharedPreferences}
   *
   * @param key specific key
   * @param value stored value
   */
  public void setInt(String key, int value) {
    sharedPreferences.edit().putInt(key, value).apply();
  }

  /**
   * Gets the Float from {@link SharedPreferences}
   * with specific key
   *
   * @param key specific key
   * @param defaultValue default value
   */
  public float getFloat(String key, float defaultValue) {
    return sharedPreferences.getFloat(key, defaultValue);
  }

  /**
   * Sets the Float into {@link SharedPreferences}
   *
   * @param key specific key
   * @param value stored value
   */
  public void setFloat(String key, float value) {
    sharedPreferences.edit().putFloat(key, value).apply();
  }

  /**
   * Gets the Long from {@link SharedPreferences}
   * with specific key
   *
   * @param key specific key
   * @param defaultValue default value
   */
  public long getLong(String key, long defaultValue) {
    return sharedPreferences.getLong(key, defaultValue);
  }

  /**
   * Sets the Long into {@link SharedPreferences}
   *
   * @param key specific key
   * @param value stored value
   */
  public void setLong(String key, long value) {
    sharedPreferences.edit().putLong(key, value).apply();
  }

  /**
   * Checks if {@link SharedPreferences} contains the specific key
   *
   * @param key specific key
   */
  public boolean hasKey(String key) {
    return sharedPreferences.contains(key);
  }

  /**
   * Clears {@link SharedPreferences}
   */
  public void clearPreferences() {
    sharedPreferences.edit().clear().apply();
  }
}
