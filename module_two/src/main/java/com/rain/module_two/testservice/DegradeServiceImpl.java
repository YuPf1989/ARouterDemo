package com.rain.module_two.testservice;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.orhanobut.logger.Logger;

/**
 * Author:rain
 * Date:2018/7/9 9:20
 * Description:
 * 全局降级策略
 * 路径path随意指定
 */
@Route(path = "/xxxx/xxx")
public class DegradeServiceImpl implements DegradeService {
    @Override
    public void onLost(Context context, Postcard postcard) {
        Logger.e("找不到了");
    }

    @Override
    public void init(Context context) {

    }
}
