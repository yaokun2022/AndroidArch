package com.yaokun.androidnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadJson(View view) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   //请求路径
                   URL url = new URL("http://mock.bigoat.com/mock/620e59762f09d576049aa3a9/park/login");
                   HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                   //请求时间
                   httpURLConnection.setConnectTimeout(10000);
                   //请求方式
                   httpURLConnection.setRequestMethod("POST");
                   //设置文本语言
                   httpURLConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
                   //接受内容
                   httpURLConnection.setRequestProperty("Accept", "*/*");

                   httpURLConnection.connect();
                   //获取结果码
                   int responseCode = httpURLConnection.getResponseCode();

                   if (responseCode == 200) {
                       //获取头部信息
                       Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                       Set<Map.Entry<String, List<String>>> entries = headerFields.entrySet();
                       for (Map.Entry<String, List<String>> entry : entries) {
                           Log.e("TAG", entry.getKey() + " == " + entry.getValue());
                       }
                       //获取body信息
                       InputStream inputStream = httpURLConnection.getInputStream();
                       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                       String s = bufferedReader.readLine();
                       Log.e("TAG", "s: "+s );

                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }
}