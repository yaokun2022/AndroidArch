package com.yk.logindome.utils;

import com.google.gson.Gson;

/**
 * Gson 转换工具
 */
public class GsonUtils {
    private final static Gson GSON = new Gson();

    /**
     *
     * @param o
     */
    public static String toJson(Object o) {
        if (o==null) return null;

        return GSON.toJson(o);
    }

    /**
     *
     * @param json
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> c) {
        if (json==null||c==null) return null;

        return GSON.fromJson(json, c);
    }
}
