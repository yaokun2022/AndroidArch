package com.yk.soundpool;

import android.content.Context;
import android.util.Log;

/**
 * 语音播报
 *
 * Author yk
 * Date 2022/5/10
 */
public class VoiceManager {
    private static final String TAG = VoiceManager.class.getSimpleName();

    // 请在刷卡区使用门禁卡刷卡确认
    public static final int SWIPING_CARD = R.raw.auth_account_slot_card;
    // 授权失败，请重试
    public static final int AUTH_FAIL = R.raw.auth_face_fail;
    // 授权失败，门禁卡与录入信息不匹配请联系物管
    public static final int AUTH_FAIL_2 = R.raw.auth_fail;
    // 授权成功，请扫描下载够进手机应用
    public static final int AUTH_SUCCESS = R.raw.auth_face_success;
    // 提交成功，请在手机上输入门禁卡对应的房号
    public static final int AUTH_SUCCESS_2 = R.raw.auth_face_success;

    private static Context context;

    public static void init(Context context) {
        VoiceManager.context = context;
    }

    /**
     * 播放raw音频
     *
     * @param rawId rawId
     */
    public static void play(int rawId) {
        if (context==null) {
            Log.e(TAG, "Context is null play failed: " + rawId);
            return;
        }

        int result = SoundUtils.play(context, rawId);
    }

    /**
     * 停止播放
     *
     * @param rawId
     */
    public static void stop(int rawId) {
        SoundUtils.stopByRawId(rawId);
    };

}
