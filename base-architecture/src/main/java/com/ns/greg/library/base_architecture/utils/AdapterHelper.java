package com.ns.greg.library.base_architecture.utils;

import android.support.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/**
 * @author Gregory
 * @since 2017/8/2
 */
public class AdapterHelper {

  /**
   * Gets the list item held at the specified adapter position.
   *
   * @param index The index of the list item to return
   * @return The list item at the specified position
   */
  @Nullable public static <T> T getListItem(List<T> itemList, int index) {
    if (checkIsLegalIndex(itemList, index)) {
      return itemList.get(index);
    }

    return null;
  }

  public static boolean checkIsLegalIndex(Collection itemList, int index) {
    return index >= 0 && index < itemList.size();
  }
}
