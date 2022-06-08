package com.yk.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Json解析
 */

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void senRequestWithOkHttp(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://127.0.0.1/get_data.json")
                        .build();
                try {
                        Response response = client.newCall(request).execute();
                        Log.d(TAG, "response : " + response);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}