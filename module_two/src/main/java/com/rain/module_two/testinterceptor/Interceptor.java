package com.rain.module_two.testinterceptor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.Logger;
import com.rain.module_common.base.BaseActivity;

/**
 * Author:rain
 * Date:2018/7/4 11:58
 * Description:
 * AOP面向切面
 * 貌似是全局的拦截器
 */
@com.alibaba.android.arouter.facade.annotation.Interceptor(priority = 7)
public class Interceptor implements IInterceptor {
    private Context context;
    private Activity holdActivity;
    @Override
    public void process(final Postcard postcard, final InterceptorCallback callback) {
        // 确定是mainActivity，如果是就保存
        if ("MainActivity".equals(BaseActivity.getActivity().getLocalClassName())) {
            holdActivity = BaseActivity.getActivity();
        }
        if ("/test/activity4".equals(postcard.getPath())) {
            Logger.e(BaseActivity.getActivity().getLocalClassName());
            final AlertDialog.Builder builder = new AlertDialog.Builder(holdActivity)
                    .setCancelable(false)
                    .setTitle("温馨提示")
                    .setMessage("想要跳转到Test4Activity么?")
                    .setPositiveButton("跳转", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            callback.onContinue(postcard);
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            callback.onInterrupt(null);
                        }
                    })
                    .setNeutralButton("加点料", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            postcard.withString("extra", "我是拦截器中添加的参数");
                            callback.onContinue(postcard);
                        }
                    });

            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    builder.create().show();
                }
            });
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
