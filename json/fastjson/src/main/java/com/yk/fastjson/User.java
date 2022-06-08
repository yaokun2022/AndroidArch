package com.yk.fastjson;

public class User {

    public int status;
    public Content content;

    public static class Content {
        public String from;
        public String to;
        public String vendor;
        public String out;
        public int err_no;

        @Override
        public String toString() {
            return "Content{" +
                    "from='" + from + '\'' +
                    ", to='" + to + '\'' +
                    ", vendor='" + vendor + '\'' +
                    ", out='" + out + '\'' +
                    ", err_no=" + err_no +
                    '}';
        }
    }

}
