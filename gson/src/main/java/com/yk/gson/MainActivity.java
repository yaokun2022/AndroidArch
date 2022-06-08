package com.yk.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //字符串转json
        Gson gson = new Gson();
        String json = "{\"name\":\"yk\",\"age\":18,\"sex\":true}";
        Person person = new Person();
        //将json字符串装换成java对象
        person = gson.fromJson(json, Person.class);
        Log.d(TAG, "name: " + person.getName());
        Log.d(TAG, "age: " + person.getAge());
        Log.d(TAG, "sex: " + person.isSex());
        Log.d(TAG, "sex: " + json);

        //json格式的数组组装成

    }
}