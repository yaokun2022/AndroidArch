package com.yk.soundpool;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.HashMap;

/**
 * 播放提示音
 * SoundPool适合短且对反应速度比较高的情况（游戏音效或按键声等）
 * 文件大小一般控制在几十K到几百K，最好不超过1M
 *
 * Author yk
 * Date 2022/5/10
 */
public class SoundUtils {
    // 缓存播放资源
    private static final HashMap<Integer, Integer> SOUND_IDS = new HashMap<>();
    // 播放器
    private static final SoundPool soundPool;

    static {
        // 播放器初始化
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setLegacyStreamType(AudioManager.STREAM_MUSIC)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(attributes)
                .build();
    }

    /**
     * 播放
     *
     * @param context context
     * @param rawId rawId
     * @param priority 优先级
     */
    public static int play(Context context, int rawId, int priority) {
        Integer soundId = SOUND_IDS.get(rawId);
        if (soundId==null) {
            // 加载音频回调
            soundPool.setOnLoadCompleteListener((soundPool, sampleId, status) -> {
                // 加载成功
                if (status==0) {
                    play(context, rawId, priority);
                }
            });
            soundId = soundPool.load(context, rawId, priority);
            SOUND_IDS.put(rawId, soundId);
        }

        return soundPool.play(soundId,1,1, 1, 0, 1);
    }

    /**
     * 播放
     *
     * @param context context
     * @param rawId rawId
     */
    public static int play(Context context, int rawId) {
       return play(context, rawId, 1);
    }

    /**
     * 停止播放
     *
     * @param rawId rawId
     */
    public static void stopByRawId(int rawId) {
        Integer soundId = SOUND_IDS.get(rawId);
        if (soundId!=null) {
            soundPool.stop(soundId);
        }
    }

    /**
     * 停止播放
     *
     * @param soundId soundId
     */
    public static void stop(int soundId) {
        soundPool.stop(soundId);
    }
}
