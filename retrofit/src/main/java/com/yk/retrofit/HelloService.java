package com.yk.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HelloService {
    @GET("test/machineinfo.json")
    Call<MachineInfo> testHttpGet();
}