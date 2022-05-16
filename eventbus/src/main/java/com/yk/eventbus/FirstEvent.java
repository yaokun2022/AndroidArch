package com.yk.eventbus;

public class FirstEvent {
    private String msg;

    public FirstEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
