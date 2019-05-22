package com.ali.modularization.home.export;

import android.content.Context;
import android.util.Log;

import com.ali.commonlib.export.IHomeExportService;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by mumu on 2019/5/11.
 * 1、需要实现commonLib中实现了IProvider的接口
 * 2、需要定义path
 */
@Route(path = "/home/HomeService")
public class HomeService implements IHomeExportService {
    @Override
    public void sayHello(String message) {
        Log.e("TAG", "我是HomeService 我收到了消息 ：" + message);
    }

    @Override
    public String getMessage() {
        return "我是从HomeService来的消息";
    }

    @Override
    public void init(Context context) {

    }
}
