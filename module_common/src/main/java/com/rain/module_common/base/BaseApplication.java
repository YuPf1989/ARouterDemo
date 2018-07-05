package com.rain.module_common.base;

import android.app.Application;
import android.support.annotation.Nullable;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * Author:rain
 * Date:2018/7/3 11:19
 * Description:
 * 进行一些公共的初始化操作
 */
public class BaseApplication extends Application {
    private static Application application;
    private static final String TAG  = "BaseApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        Utils.init(this);
        // 初始化logger
        Logger.addLogAdapter(new AndroidLogAdapter() {

            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                // 根据返回值，是否开启日志,
                // 之所以不使用BuildConfig.Debug是因为在多module情况下，子module build始终为release，是不准确的
                // 参见https://blog.csdn.net/j236027367/article/details/78751281
                return Utils.isAppDebug();
            }
        });
}

    public static Application getApplication() {
        return application;
    }
}
