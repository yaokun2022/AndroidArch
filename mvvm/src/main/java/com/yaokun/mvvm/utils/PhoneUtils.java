package com.yaokun.mvvm.utils;

/**
 * 手机号码工具
 */
public class PhoneUtils {
    private static final String PHONE_RE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";

    public static boolean checkPhone(String phone) {
        if (phone == null) return false;
        return phone.matches(PHONE_RE);
    }
}
