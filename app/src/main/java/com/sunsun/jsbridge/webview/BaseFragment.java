package com.sunsun.jsbridge.webview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sunsun.jsbridge.utils.EventBusParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;


/**
 */
public abstract class BaseFragment extends Fragment {

    protected boolean isVisibleToUser;
    protected View mRootView;

    protected boolean isRegistertEventBus() {
        return true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mRootView == null){
            mRootView = inflater.inflate(setupLayoutId(), container, false);
            ButterKnife.bind(this, mRootView);
        }
        if (isRegistertEventBus()) {
            if (!EventBus.getDefault().isRegistered(this))
                EventBus.getDefault().register(this);
        }
        initView(mRootView);
        initBundle(savedInstanceState);
        return mRootView;
    }

    public abstract int setupLayoutId();

    public abstract void initView(View view);

    public abstract void initBundle(Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (isRegistertEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe
    public void onEventMainThread(EventBusParams event) {
    }
}
