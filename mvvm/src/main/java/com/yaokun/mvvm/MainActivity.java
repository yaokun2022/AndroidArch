package com.yaokun.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.content.Intent;
import android.os.Bundle;

import com.yaokun.mvvm.databinding.ActivityLoginBinding;
import com.yaokun.mvvm.login.LoginActivity;
import com.yaokun.mvvm.login.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startActivity(new Intent(this, LoginActivity.class));

    }
}