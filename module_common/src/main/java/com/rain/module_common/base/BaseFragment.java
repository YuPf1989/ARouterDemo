package com.rain.module_common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author:rain
 * Time:2017/6/15 17:44
 * Description:This is BaseFragment
 */

public abstract class BaseFragment extends Fragment {

    protected View rootView;
    protected Context mContext;
    private static final String TAG = "BaseFragment";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        mContext = getContext();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(savedInstanceState);
        start();
    }





    protected void start() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    /**
     * 初始化 Toolbar
     * 注意这里的toolbar在activity中
     */
    protected void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        ((BaseActivity) getActivity()).initToolBar(toolbar, homeAsUpEnabled, title);
    }

    protected abstract int getLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

}
