package com.rain.module_common.base;

import android.os.Bundle;

/**
 * 当前fragment对用户第一次可见时加载数据
 */

public abstract class LazyLoadFragment extends BaseFragment {
    // 初始化是否完成
    protected boolean isViewInitiated;
    // 用户是否可见
    protected boolean isVisibleToUser;
    // 数据是否第一次初始化过
    protected boolean isDataInitiated;

    private static final String TAG  = "LazyLoadFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

    public abstract void fetchData();

    public boolean prepareFetchData() {
        return prepareFetchData(false);
    }

    /**
     * 准备加载数据
     */
    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isVisibleToUser = false;
        isViewInitiated = false;
        isDataInitiated = false;
    }
}