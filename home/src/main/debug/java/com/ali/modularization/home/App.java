package com.ali.modularization.home;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by mumu on 2019/5/16.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
