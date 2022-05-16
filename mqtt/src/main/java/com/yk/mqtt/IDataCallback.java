package com.yk.mqtt;

public interface IDataCallback {

    void onData(String topic, String data);
}
