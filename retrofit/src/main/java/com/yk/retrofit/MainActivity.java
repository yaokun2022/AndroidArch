package com.yk.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import okhttp3.MediaType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final MediaType JSON = MediaType.parse("application/json;charset=UTF-8");

    private Button button;
    private TextView tv;
    private final static String BASE_URL = "http://192.168.2.118:8081/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        tv = findViewById(R.id.showMsg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRequest();
            }
        });
    }

    private void doRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //创建调用接口
        HelloService helloService = retrofit.create(HelloService.class);
        //调用接口方法，访问url
        Call<MachineInfo> call = helloService.testHttpGet();
        //请求处理
        call.enqueue(new Callback<MachineInfo>() {
            @Override
            public void onResponse(Call<MachineInfo> call, Response<MachineInfo> response) {
                tv.setText(response.body().data.communityAddress);
            }

            @Override
            public void onFailure(Call<MachineInfo> call, Throwable t) {
                Toast.makeText(MainActivity.this, "网络请求失败--->:" + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });

    }
}