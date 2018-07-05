package com.rain.module_two;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.rain.module_common.base.BaseTestActivity;

/**
 * Author:rain
 * Date:2018/7/4 10:06
 * Description:
 */
@Route(path = "/test/activity4")
public class Test4Activity extends BaseTestActivity {

    @Override
    public void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        String extra = getIntent().getStringExtra("extra");
        setValue(extra);
    }
}
