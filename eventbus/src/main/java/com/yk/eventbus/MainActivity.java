package com.yk.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void EventMessage(EventMessage event){
        Toast.makeText(MainActivity.this,"get: " + event.msg,Toast.LENGTH_SHORT).show();

    }
    @Subscribe
    public void handleSomething(SomethingEvent event){
        doSomething(event);
    }

    private void doSomething(SomethingEvent event) {
        //to do something
    }

    @Override
    protected void onStart() {
        EventBus.getDefault().register(MainActivity.this);
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册
        EventBus.getDefault().unregister(this);
    }
}