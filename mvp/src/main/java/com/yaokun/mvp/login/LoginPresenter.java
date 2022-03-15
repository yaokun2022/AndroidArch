package com.yaokun.mvp.login;

import com.yaokun.mvp.data.RemoteRepository;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;


    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }


    @Override
    public void login(String username, String password) {
        // 数据校验

        // remoteRepository 发起网络请求

        RemoteRepository.login(username, password);

        // 登陆成功保持密码到本地 等等


        // 成功后通知View
        view.loginResult("zhangShan");

    }
}
