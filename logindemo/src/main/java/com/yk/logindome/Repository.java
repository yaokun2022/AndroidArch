package com.yk.logindome;


import android.content.Intent;
import android.widget.Toast;

import com.yk.logindome.utils.HttpUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    public static final String LOGIN_URL = "http://mock.bigoat.com/mock/620e59762f09d576049aa3a9/park/login";
    public static final String CHANGE_PWD_URL = "http://mock.bigoat.com/mock/620e59762f09d576049aa3a9/park/change";
    public static final String ARTICLE_LIST_URL = "http://mock.bigoat.com/mock/620e59762f09d576049aa3a9/park/articelList";


    public static void login(String username, String password, HttpUtils.Callback<User> callback) {
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
        param.put("password", password);

        HttpUtils.post(LOGIN_URL, param, callback);
    }

    public static void changePassword(String username, String cPwd, String nPwd, String rPwd, HttpUtils.Callback<User> callback) {
        Map<String, Object> param = new HashMap<>();
        param.put("username", username);
        param.put("cPwd", cPwd);
        param.put("nPwd", nPwd);
        param.put("rPwd", rPwd);

        HttpUtils.post(CHANGE_PWD_URL, param, callback);
    }

    public static void getArticleList(String title, int size, int page, HttpUtils.Callback<List<Article>> callback) {
        Map<String, Object> param = new HashMap<>();
        param.put("title", title);
        param.put("size", size);
        param.put("page", page);


        HttpUtils.get(ARTICLE_LIST_URL, param, callback);
    }
}
