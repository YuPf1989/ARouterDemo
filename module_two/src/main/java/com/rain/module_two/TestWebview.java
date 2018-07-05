package com.rain.module_two;

import android.os.Bundle;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.rain.module_common.base.BaseActivity;

/**
 * Author:rain
 * Date:2018/7/3 17:20
 * Description:
 *
 */
@Route(path = "/test/webviewActivity")
public class TestWebview extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        WebView webview = findViewById(R.id.webview);
        webview.loadUrl(getIntent().getStringExtra("url"));
    }
}
