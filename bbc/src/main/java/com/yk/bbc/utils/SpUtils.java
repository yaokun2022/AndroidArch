package com.yk.bbc.utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SP 工具
 */
public class SpUtils {
    private static final String NAME = "data";

    private static SharedPreferences SP;

    // 初始化
    public static void init(Context context) {
        SP = context.getSharedPreferences(NAME, MODE_PRIVATE);
    }


    public static void put(String key, String value) {
        SP.edit().putString(key, value).apply();
    }

    public static void put(String key, Boolean value) {
        SP.edit().putBoolean(key, value).apply();
    }

    //TODO 更多类型存储



    public static String getString(String key, String defValue) {
        return SP.getString(key, defValue);
    }

    public static boolean getBoolean(String key, Boolean defValue) {
        return SP.getBoolean(key, defValue);
    }

    // TODO 更多类型读取




    public static void remove(String key) {
        SP.edit().remove(key).apply();
    }
}
