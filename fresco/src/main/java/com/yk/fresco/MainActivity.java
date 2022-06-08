package com.yk.fresco;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {
    private SimpleDraweeView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageIv);
        //image.setImageURI("https://img2.woyaogexing.com/2022/05/30/9087250715e86fb2!400x400.jpg");
    }

    public void loadImage(View view) {
        Uri uri = Uri.parse("https://img2.woyaogexing.com/2022/05/30/9087250715e86fb2!400x400.jpg");
        image.setImageURI(uri);


    }
}