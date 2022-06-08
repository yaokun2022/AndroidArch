package com.yk.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request();
    }

    private void request() {
        Retrofit retrofit = RetrofitServer.GetRequest(RetrofitServer.BASE_URL);
        GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);
        Call<Translation> call = request.getCall();
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                Log.d("TAG", "建立咖啡: " + response.body().status);
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {

            }
        });

    }
}