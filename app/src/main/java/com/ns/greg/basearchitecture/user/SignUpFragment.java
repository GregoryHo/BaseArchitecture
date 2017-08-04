package com.ns.greg.basearchitecture.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ns.greg.basearchitecture.DemoActivity;
import com.ns.greg.basearchitecture.R;
import com.ns.greg.basearchitecture.hook.ThreadExecutor;
import com.ns.greg.basearchitecture.hook.di.component.ExecutorComponent;
import com.ns.greg.library.fasthook.BaseRunnable;
import com.ns.greg.library.fasthook.functions.EasyRun0;
import javax.inject.Inject;

/**
 * @author Gregory
 * @since 2017/8/3
 */

public class SignUpFragment extends Fragment {

  @Inject ThreadExecutor threadExecutor;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivityComponent().inject(this);
  }

  private ExecutorComponent getActivityComponent() {
    return ((DemoActivity) getActivity()).getComponent();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return LayoutInflater.from(getContext()).inflate(R.layout.sign_up, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override public void onResume() {
    super.onResume();
    threadExecutor.addTask(new BaseRunnable<EasyRun0<Boolean>>() {
      @Override protected EasyRun0<Boolean> runImp() throws Exception {
        System.out.println("Lets' run!");
        return new EasyRun0<>(true);
      }
    }).start();
  }
}
