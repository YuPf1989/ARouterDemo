package com.rain.module_two.testservice;

import android.content.Context;
import android.net.Uri;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;

/**
 * Author:rain
 * Date:2018/7/5 9:20
 * Description:
 * 重写跳转的url
 */
@Route(path = "/xxx/xxx")
public class PathReplaceServiceImpl implements PathReplaceService {
    @Override
    public String forString(String path) {
        return path;
    }

    @Override
    public Uri forUri(Uri uri) {
        return uri;
    }

    @Override
    public void init(Context context) {

    }
}
