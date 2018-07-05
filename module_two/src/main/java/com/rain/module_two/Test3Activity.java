package com.rain.module_two;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.rain.module_common.base.BaseTestActivity;

/**
 * Author:rain
 * Date:2018/7/4 9:47
 * Description:
 */
@Route(path = "/test/activity3")
public class Test3Activity extends BaseTestActivity {
    @Autowired
    String name;

    @Autowired
    int age;

    @Autowired(name = "boy")
    boolean girl;

    // 这个字段没有注解，是不会自动注入的
    private long high;

    @Override
    public void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        // 将url的参数注入
        ARouter.getInstance().inject(this);
        ((TextView) findViewById(R.id.tv_test)).setText("I'm "+Test3Activity.class.getSimpleName());
        String params = String.format("name=%s, age=%s, girl=%s, high=%s", name, age, girl, high);
        setValue(params);
    }
}
