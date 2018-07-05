package com.rain.module_two;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.rain.module_common.base.BaseTestActivity;
import com.rain.module_two.testinject.TestObj;
import com.rain.module_two.testinject.TestParcelable;

import java.util.List;
import java.util.Map;

/**
 * Author:rain
 * Date:2018/7/3 11:47
 * Description:
 * https://m.aliyun.com/test/activity1?name=老王&age=23&boy=true&high=180
 * 使用Autowired注解，自动注入
 */
@Route(path = "/test/activity1")
public class Test1Activity extends BaseTestActivity {

    @Autowired
    String name = "jack";

    @Autowired
    int age = 10;

    @Autowired
    int height = 175;

    @Autowired(name = "boy")
    boolean girl;

    @Autowired
    char ch = 'A';

    @Autowired
    float fl = 12.00f;

    @Autowired
    double dou = 12.01d;

    @Autowired
    TestParcelable pac;

    @Autowired
    TestObj obj;

    @Autowired
    List<TestObj> objList;

    @Autowired
    Map<String, List<TestObj>> map;

    @Autowired
    long high;

    @Autowired
    String url;

//    @Autowired
//    HelloService helloService;

    @Override
    public void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        // No more getter ...
        // name = getIntent().getStringExtra("name");
        // age = getIntent().getIntExtra("age", 0);
        // girl = getIntent().getBooleanExtra("girl", false);
        // high = getIntent().getLongExtra("high", 0);
        // url = getIntent().getStringExtra("url");
        // 将url的参数注入
        ARouter.getInstance().inject(this);
        String params = String.format(
                "name=%s,\n age=%s, \n height=%s,\n girl=%s,\n high=%s,\n url=%s,\n pac=%s,\n obj=%s \n ch=%s \n fl = %s, \n dou = %s, \n objList=%s, \n map=%s",
                name,
                age,
                height,
                girl,
                high,
                url,
                pac,
                obj,
                ch,
                fl,
                dou,
                objList,
                map
        );
//        helloService.sayHello("Hello moto.");

        ((TextView) findViewById(R.id.tv_test)).setText("I am " + Test1Activity.class.getName());
        ((TextView) findViewById(R.id.tv_content)).setText(params);
    }
}
