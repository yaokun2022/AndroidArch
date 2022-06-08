package com.yk.arouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MyApplication extends Application {
    private boolean isDebug = false;
    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebug) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        //初始化ARouter
        ARouter.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //销毁ARouter
        ARouter.getInstance().destroy();
    }
}
