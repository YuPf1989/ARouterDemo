package com.rain.arouterdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.Logger;
import com.rain.module_common.base.BaseActivity;
import com.rain.module_common.data.TestBean;
import com.rain.module_two.testinject.TestObj;
import com.rain.module_two.testinject.TestParcelable;
import com.rain.module_two.testservice.HelloService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 阿里Arouter 使用demo
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final int REQUEST_CODE = 741;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Logger.e("initViews");
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);
        findViewById(R.id.btn_10).setOnClickListener(this);
        findViewById(R.id.btn_11).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 应用内跳转
            case R.id.btn_1:
                ARouter.getInstance().build("/test/activity5")
                        .navigation();
                break;
            // 应用内跳转,携带参数
            case R.id.btn_2:
                TestBean obj = new TestBean("alex", 20);
                ARouter.getInstance().build("/test/activity5")
                        .withLong("key1", 666L)
                        .withString("key2", "hello world")
                        .withObject("key3", obj)
                        .navigation();
                break;
            // 跳转forResult
            case R.id.btn_3:
                ARouter.getInstance().build("/test/activity5")
                        .navigation(this, REQUEST_CODE);
                break;
            // 获取fragment
            case R.id.btn_4:
                Uri uri = Uri.parse("arouter://m.aliyun.com/test/fragment");
                Fragment fragment = (Fragment) ARouter.getInstance().build(uri)
                        .navigation();
                Toast.makeText(this, fragment.toString(), Toast.LENGTH_SHORT).show();
                break;
            // 通过url跳转
            case R.id.btn_5:
                ARouter.getInstance().build("/test/webviewActivity")
                        .withString("url", "file:///android_asset/schame-test.html")
                        .navigation();
                break;
            // 拦截器测试
            case R.id.btn_6:
                ARouter.getInstance().build("/test/activity4")
                        .navigation(this, new NavCallback() {
                            @Override
                            public void onArrival(Postcard postcard) {

                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Logger.e("被拦截了");
                            }
                        });
                break;
            // 旧版本动画
            case R.id.btn_7:// 注意使用动画时，必须添加 this对象
                ARouter.getInstance().build("/test/activity1")
                        .withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                        .navigation(this);
                break;
            // 新版本动画
            case R.id.btn_8:
                if (Build.VERSION.SDK_INT > 16) {
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                            .makeScaleUpAnimation(v, v.getWidth() / 2, v.getHeight() / 2, 0, 0);
                    ARouter.getInstance().build("/test/activity1")
                            .withOptionsCompat(optionsCompat)
                            .navigation();
                } else {
                    Toast.makeText(this, "sdk<16,不支持新版本动画", Toast.LENGTH_SHORT).show();
                }
                break;
            // 依赖注入
            case R.id.btn_9:
                TestParcelable testParcelable = new TestParcelable("jack", 666);
                TestObj testObj = new TestObj("nicky", 888);
                List<TestObj> list = new ArrayList<>();
                list.add(testObj);
                HashMap<String, List<TestObj>> map = new HashMap<>();
                map.put("key", list);
                ARouter.getInstance().build("/test/activity1")
                        .withString("name", "老王")
                        .withInt("age", 18)
                        .withBoolean("boy", true)
                        .withLong("high", 180)
                        .withString("url", "https://a.b.c")
                        .withParcelable("pac", testParcelable)
                        .withObject("obj", testObj)
                        .withObject("objList", list)
                        .withObject("map", map)
                        .navigation();
                break;
            // 通过path调用服务
            case R.id.btn_10:
                ((HelloService) ARouter.getInstance().build("/service/hello").navigation()).sayHello("hello world");
                break;

            // 通过type调用服务
            case R.id.btn_11:
                ARouter.getInstance().navigation(HelloService.class).sayHello("hello moto");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            Toast.makeText(this, "resultCode:" + resultCode, Toast.LENGTH_SHORT).show();
        }
    }
}
