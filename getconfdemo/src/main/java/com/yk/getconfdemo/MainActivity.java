package com.yk.getconfdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    private static final String URL = "http://192.168.2.112:9999/api/initialization/getMachineStatus";
    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final Gson GSON = new Gson();
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    MachineInfo info = new MachineInfo();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String json = "{\n" +
//                "\"name\":\"yk\",\n" +
//                "\"age\":18,\n" +
//                "\"sex\":\"男\"\n" +
//                "}";
//        User user = GSON.fromJson(json, User.class);
    }

    public void getConfig(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MachineStatus status = new MachineStatus();
                status.setMachineCode("90864650052378087");
                String json = GSON.toJson(status);
                Log.d(TAG, "json: " + json);

                RequestBody body = RequestBody.create(json, JSON);
                Request request = new Request.Builder()
                        .url(URL)
                        .post(body)
                        .build();
                Response response = null;

                try {
                    response = CLIENT.newCall(request).execute();
                    String Json = response.body().string();
                    MachineInfo info = GSON.fromJson(Json, MachineInfo.class);

                    MediaType JSON = MediaType.parse("application/json;charset=utf-8");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}