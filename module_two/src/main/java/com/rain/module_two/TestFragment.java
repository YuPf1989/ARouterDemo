package com.rain.module_two;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.rain.module_common.base.BaseFragment;

/**
 * Author:rain
 * Date:2018/7/3 16:34
 * Description:
 */
@Route(path = "/test/fragment")
public class TestFragment extends BaseFragment {

    private TextView tv_content;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        tv_content = rootView.findViewById(R.id.tv_content);
    }
}
