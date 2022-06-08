package com.yk.bbc.main;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yk.bbc.list.IRouterList;
import com.yk.bbc.my.MyViewModel;

public class MainViewModel extends MyViewModel {
    public void test() {
        ARouter.getInstance().build(IRouterList.LOGIN_ACTIVITY).navigation();
    }
}
