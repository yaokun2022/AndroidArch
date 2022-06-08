package com.yk.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRequest_Interface {
    @GET("/test/test.json")
    Call<Translation> getCall();

}
