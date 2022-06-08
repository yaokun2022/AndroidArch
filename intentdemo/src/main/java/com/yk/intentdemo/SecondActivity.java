package com.yk.intentdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ed = findViewById(R.id.editTextTextPersonName2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            Intent intent = new Intent();
            String s = data.getExtras().getString("text");
            intent.putExtra("text",s);
            setResult(3,intent);
            finish();
        }
    }

    public void test(View view) {
        Intent intent = new Intent();
        String s = ed.getText().toString();
        intent.putExtra("text", s);
        setResult(1,intent);
    }

    public void test1(View view) {
        Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
        startActivity(intent);
    }
}