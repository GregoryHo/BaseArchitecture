package com.ns.greg.library.base_architecture.mvp;

import android.view.View;

/**
 * @author Gregory
 * @since 2016/3/31
 */
public interface BaseView<T> {

  /**
   * Sets the presenter
   */
  void setPresenter(T presenter);

  /**
   * Find the widget in the view
   *
   * @param view the target layout
   */
  void findView(View view);

  /**
   * Showing the message in the way you impl
   *
   * @param message the tips message
   */
  void showTipsMessage(String message);
}
