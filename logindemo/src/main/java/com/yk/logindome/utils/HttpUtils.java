package com.yk.logindome.utils;


import androidx.annotation.NonNull;

import com.yk.logindome.Data;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUtils {
    private static final OkHttpClient CLIENT = new OkHttpClient();

    public static <T> void get(String url, Map<String, Object> params, Callback<T> callback) {

        Request request = new Request.Builder()
                .url(url)
                .build();

        CLIENT.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailed(201, e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();

                    Data<T> data = GsonUtils.fromJson(json, Data.class);

                    if (data.status==200) {
                        callback.onSuccess(data.data);
                    } else {
                        callback.onFailed(data.status, data.msg);
                    }
                }
            }
        });
    }

    public static <T> void post(String url, Map<String, Object> params, Callback<T> callback) {
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        String json = GsonUtils.toJson(params);
        RequestBody requestBody = RequestBody.create(mediaType, json);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        CLIENT.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailed(201, e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();



                    Data<T> data = GsonUtils.fromJson(json, Data.class);

                    if (data.status==200) {
                        callback.onSuccess(data.data);
                    } else {
                        callback.onFailed(data.status, data.msg);
                    }
                }
            }
        });
    }

    public static void put() {

    }

    public static void delete() {

    }


    public interface Callback<T> {

        public void onSuccess(T t);

        public void onFailed(int errCode, String errMsg);

    }
}
