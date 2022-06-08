package com.yk.eventbus;

import android.util.Log;

public class SomethingEvent {

    public void doSomething(SomethingEvent event){
        // to do something
        Log.d("TAG", "doSomething: " + event);
    }
}
