package com.yk.fastjson;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HttpServes {
    @GET("/test/test.json")
    Call<User> getCall();
}
