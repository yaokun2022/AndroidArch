package com.yk.mqtt;

public interface IConnectionCallback {

    void onFailed(String err);

    void onSucceed();
}
