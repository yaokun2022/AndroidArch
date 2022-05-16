package com.yk.soundpool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VoiceManager.init(getApplicationContext());
    }

    public void card(View view) {
        VoiceManager.play(VoiceManager.SWIPING_CARD);
    }

    public void failedReplace(View view) {
        VoiceManager.play(VoiceManager.AUTH_FAIL);
    }

    public void authSuccess(View view) {
        VoiceManager.play(VoiceManager.AUTH_SUCCESS);
    }
}