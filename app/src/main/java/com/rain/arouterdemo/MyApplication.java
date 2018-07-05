package com.rain.arouterdemo;

import com.alibaba.android.arouter.launcher.ARouter;
import com.rain.module_common.base.BaseApplication;
import com.rain.module_common.base.Utils;

/**
 * Author:rain
 * Date:2018/7/3 11:21
 * Description:
 */
public class MyApplication extends BaseApplication {
    private static final String TAG  = "MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        if (Utils.isAppDebug()) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        // 关闭路由
//        ARouter.getInstance().destroy();
    }
}
