package com.yk.bbc.application;


import com.alibaba.android.arouter.launcher.ARouter;
import com.bigoat.bbc.base.BaseApplication;
import com.blankj.utilcode.util.SPUtils;

public class MyApp extends BaseApplication {
    private boolean isDebug = false;

    /**
     * 执行初始化操作
     */
    @Override
    public void myCreate() {
//        if (isDebug) {
//            ARouter.openDebug();
//            ARouter.openLog();
//        }
        //初始化路由
        ARouter.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //销毁路由
        ARouter.getInstance().destroy();
    }
}
