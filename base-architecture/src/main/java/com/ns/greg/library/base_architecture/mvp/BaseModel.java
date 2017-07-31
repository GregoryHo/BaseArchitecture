package com.ns.greg.library.base_architecture.mvp;

/**
 * @author Gregory
 * @since 2016/4/1
 */
public interface BaseModel<T, P extends BasePresenter> {

  /**
   * Updating current data set (you need impl this by yourself) by add data set (from outside)
   *
   * @param dataSet target dataSet resource that need to add in current data set
   * @throws ClassCastException throws exception if given the wrong class type
   */
  void updateDataSet(T dataSet) throws ClassCastException;

  /**
   * Get the current data set(used in update view)
   */
  T getDataSets();

  void setPresenter(P presenter);
}
