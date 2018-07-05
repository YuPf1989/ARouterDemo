package com.rain.module_two.testservice;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Author:rain
 * Date:2018/7/4 11:09
 * Description:
 * 不知道该类是怎么调用的
 * 如果不写该类，那么在url跳转测试中，url携带的json是无法解析的
 */
@Route(path = "/service/json")
public class JsonServiceImpl implements SerializationService {
    @Override
    public <T> T json2Object(String input, Class<T> clazz) {
        return new Gson().fromJson(input,clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return new Gson().toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return new Gson().fromJson(input,clazz);
    }

    @Override
    public void init(Context context) {

    }
}
