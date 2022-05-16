package com.yk.mqtt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttService;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMqtt("mqtt.bigoat.com", "admin", "123", true);
    }

    public void initMqtt(String host, String user, String pwd, boolean reconnection) {
        MqttConnectOptions options = new MqttConnectOptions();
        //默认为true，表示非持久订阅，无论服务端或者客户端重启，不会保持状态，重启后指定消息也无法送达
        // 设置为false，表示持久订阅，服务端与客户端重启或重链，指定消息可以送达
//        options.isCleanSession = false;
        options.setCleanSession(false);
        //链接的用户名(账号名)
//        options.userName = user;
        options.setUserName(user);
        //链接的用户密码(账户密码)
//        options.password = password.toCharArray()
        options.setPassword(pwd.toCharArray());
        //链接超时值s，默认30s，为0时，等待网络状态，即成功或失败
//        options.connectionTimeout = connectTimeout
        options.setConnectionTimeout(30);
        //默认60s，检测服务端是否可用，为0时则禁止客户端保活，保活间隔内，没有消息的情况下客户端会通过ping来检测链接是否保持
//        options.keepAliveInterval = keepAliveInterval
        options.setKeepAliveInterval(60);
        //是否开启自动重连接，初始尝试重连是等待1s，失败情况下，延迟加倍，直到2分钟。
//        options.isAutomaticReconnect = true
        options.setAutomaticReconnect(reconnection);

        options.setServerURIs(new String[]{"tcp://"+host+":"+1883});

        MyMqttClient client = new MyMqttClient();
        client.connectToServer(
                this,
                host,
                "test",
                options,
                new IConnectionCallback() {

                    @Override
                    public void onFailed(String err) {
                        Log.e("MQTTTest", "Mqtt连接失败：" + err);


                    }

                    @Override
                    public void onSucceed() {
                        Log.e("MQTTTest", "Mqtt连接成功");

                        new Thread(){
                            @Override
                            public void run() {
                                while (true) {
                                    client.publish("online", 1, "zaix");
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }.start();
                    }
                },
                new IDataCallback() {

                    @Override
                    public void onData(String topic, String data) {
                        Log.d("MQTTTest", "topic: " + data);

                        if ("1".equals(data)) {
                            client.publish("12345", 1, "Hello !");
                        }
                    }

                });
    }

    public void startMqtt(View view) {
        initMqtt("mqtt.bigoat.com", "admin", "123", true);
    }
}