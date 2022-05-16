package com.yk.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //播放raw文件夹中文件
    public void rawPlay(View view) {
        MediaPlayer player = MediaPlayer.create(this, R.raw.input_error);
        player.start();// 不需要调用 prepare(); create() 方法帮忙调用了。
    }
    MediaPlayer mediaPlayer = new MediaPlayer();
    public void uriPlay(View view){

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String url = "http://data.huiyi8.com/yinxiao/wav/85764.wav";
//                    String url = "http://szls.skyinfor.cn:21001/api/public/storage/event/20210420/312d9c5f6e04eacb1155f83e6bd4e935.mp3";

                    if (mediaPlayer.isPlaying()) {
                        return;
                    }

                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepare(); // might take long! (for buffering, etc)
                    mediaPlayer.start();
//
//                    MediaPlayer mediaPlayer = new MediaPlayer();
//                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//
//                    mediaPlayer.setDataSource(getApplicationContext(), myUri);
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}