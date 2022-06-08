package com.yk.bbc.login;


import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bigoat.bbc.base.BaseLiveData;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.yk.bbc.list.IRouterList;
import com.yk.bbc.my.MyViewModel;

public class LoginViewModel extends MyViewModel {
    public BaseLiveData<String> username = new BaseLiveData<>();//用户名
    public BaseLiveData<String> password = new BaseLiveData<>();//密码
    public BaseLiveData<Boolean> showPassword = new BaseLiveData<>(false);//是否显示密码
    public BaseLiveData<Boolean> agreement = new BaseLiveData<>(false);//是否同意

    public BaseLiveData<Boolean> loginBtnEnable = new BaseLiveData<>(false);//登录按钮是否可以点击

    @Override
    protected void onCreate() {
        username.observeForever(s -> loginBtnEnable.setValue((!StringUtils.isTrimEmpty(s) && !StringUtils.isTrimEmpty(password.value()))));
        password.observeForever(s -> loginBtnEnable.setValue((!StringUtils.isTrimEmpty(s) && !StringUtils.isTrimEmpty(username.value()))));
    }

    public void changeShowPwd() {
        showPassword.value(!showPassword.value());

    }

    public void login() {
        if (!agreement.value()) {
            Log.d("TAG", "login: 请勾选阅读条例");
            return;
        }
        //TODO
        if (!(username.value().equals("abc") && password.value().equals("123"))) {
            showToastInfo("用户名或密码不正确");
        } else {
            ARouter.getInstance().build(IRouterList.MAIN_ACTIVITY).navigation();
            SPUtils.getInstance().put("username", username.value());
            SPUtils.getInstance().put("password", password.value());

        }
    }
}
