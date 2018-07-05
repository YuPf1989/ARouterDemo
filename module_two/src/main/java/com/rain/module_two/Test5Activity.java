package com.rain.module_two;

import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.rain.module_common.base.BaseTestActivity;
import com.rain.module_common.data.TestBean;
import com.rain.module_two.testinject.TestObj;

/**
 * Author:rain
 * Date:2018/7/4 10:06
 * Description:
 */
@Route(path = "/test/activity5")
public class Test5Activity extends BaseTestActivity {
    public static final int RESULT_CODE = 840;
    @Autowired
    long key1;

    @Autowired
    String key2;

    @Autowired
    TestBean key3;

    @Override
    public void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        ARouter.getInstance().inject(this);
        String value = String.format("key1=%s,\n key2=%s,\nkey3=%s", key1, key2, (key3 == null ? "null" : key3.toString()));
        setValue(value);
        setResult(RESULT_CODE);
    }
}
