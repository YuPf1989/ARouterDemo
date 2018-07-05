package com.rain.module_two;

import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.rain.module_common.base.BaseActivity;

/**
 * Author:rain
 * Date:2018/7/4 9:02
 * Description:
 */
@Route(path = "/test/activity2")
public class Test2Activity extends BaseActivity {
    @Autowired
    String key1;
    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        // 将url的参数注入
        ARouter.getInstance().inject(this);
        String key1 = getIntent().getStringExtra("key1");
        Toast.makeText(this, "key1="+key1, Toast.LENGTH_SHORT).show();
    }
}
