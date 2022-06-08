package com.yk.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        et = findViewById(R.id.editTextTextPersonName);
    }

    public void test(View view) {
        Intent intent = new Intent();
        String s = et.getText().toString();
        intent.putExtra("text",s);
        setResult(3,intent);
        finish();
    }
}