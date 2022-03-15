package com.yaokun.mvvm.data;

import com.yaokun.mvvm.entity.User;

public class RemoteRepository {

    public static void login(String username, String password, Callback callback) {
        if (username.equals("18096051254") && password.equals("123456")) {
            callback.succeed(new User(username));
        } else {
            callback.failed(-1, "登陆失败！");
        }

    }


    public interface Callback {
        public void succeed(User user);
        public void failed(int errCode, String errMsg);
    }

}
