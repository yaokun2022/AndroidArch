package com.yk.okhttp;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Okhttp
 */
public class OkhttpExample {
    final OkHttpClient client = new OkHttpClient();

    /***
     *
     * 获取网络地址
     * @param url
     * @return
     * @throws IOException
     */
    public String[] run(String url) throws IOException {
        final String[] urlStr = {""};
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("TAG", "网络获取失败: " + e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.d("TAG", "网络请求成功了: " + call);
                urlStr[0] = response.body().toString();
            }
        });
            return urlStr;
    }

}