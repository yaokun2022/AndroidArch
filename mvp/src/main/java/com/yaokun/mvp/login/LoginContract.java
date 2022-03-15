package com.yaokun.mvp.login;

/**
 * View 和 Presenter 关联接口
 */
public interface LoginContract {

    public interface View {
        void setPresenter(Presenter presenter);

        void login();

        void loginResult(String user);


        void loadUsernamePassword();
    }

    public interface Presenter {

        void login(String username, String password);

    }
}
