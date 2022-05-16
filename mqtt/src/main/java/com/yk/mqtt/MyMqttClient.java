package com.yk.mqtt;

import android.content.Context;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MyMqttClient {
    //正在连接服务器
    private boolean connecting = false;
    private MqttAndroidClient mqttAndroidClient = null;
    private Integer connectTimeout = 20;

    //连接到服务器
    public void connectToServer(
            Context context,
            String host,
            String clientId,
            MqttConnectOptions options,
            IConnectionCallback connectionCallback,
            IDataCallback dataCallback){
        if(mqttAndroidClient == null){
            mqttAndroidClient = new MqttAndroidClient(context,options.getServerURIs()[0],clientId);
            mqttAndroidClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    connectionCallback.onFailed(cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    String data = new String(message.getPayload());

                    dataCallback.onData(topic, data);

                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });

            try {
                mqttAndroidClient.connect(options, context, new IMqttActionListener() {
                    @Override
                    public void onSuccess(IMqttToken asyncActionToken) {
                        try {

                            connectionCallback.onSucceed();

                            mqttAndroidClient.subscribe("88888888", 1);
                        } catch (MqttException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(IMqttToken asyncActionToken, Throwable e) {
                        connectionCallback.onFailed(e.getMessage());

                    }
                });
            } catch (MqttException e) {
                e.printStackTrace();
                connectionCallback.onFailed(e.getMessage());
            }
        }
    }


    public void publish(String topic, int qos, String content) {
        if (mqttAndroidClient!=null) {
            MqttMessage mqttMessage = new MqttMessage();
            mqttMessage.setQos(qos);
            mqttMessage.setPayload(content.getBytes());
            try {
                mqttAndroidClient.publish(topic, mqttMessage);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    //是否建立连接
    public boolean hasConnected(){
        if (mqttAndroidClient.isConnected()) {
            return true;
        }
        return false;
    }
    //断开连接
    public void disConnectFromServer(){
//        if (mqttAndroidClient)
    }
}
