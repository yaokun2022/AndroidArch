package com.yk.retrofitdemo;

public class Translation {
    //been 返回数据类
    public int status;
    public Content content;

    public static class Content {
        public String from;
        public String to;
        public String vendor;
        public String out;
        public int err_no;
    }
}
