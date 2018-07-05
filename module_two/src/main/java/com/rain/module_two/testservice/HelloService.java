package com.rain.module_two.testservice;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Author:rain
 * Date:2018/7/4 17:40
 * Description:
 */
@Route(path = "/service/hello")
public class HelloService implements IProvider {
    private Context context;
    @Override
    public void init(Context context) {
        this.context = context;
    }

    public void sayHello(String s){
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }
}
