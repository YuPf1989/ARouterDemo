package com.rain.module_common.base;

import android.os.Bundle;
import android.widget.TextView;

import com.rain.module_common.R;

/**
 * Author:rain
 * Date:2018/7/3 11:52
 * Description:
 */
public class BaseTestActivity extends BaseActivity {

    private TextView tv_content;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        tv_content = findViewById(R.id.tv_content);

    }

    public void setValue(String value) {
        tv_content.setText(value);
    }
}
