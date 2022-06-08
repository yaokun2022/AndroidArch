package com.yk.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private down01Fragment down01Fragment;
    private down02Fragment down02Fragment;

    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initFragment() {
        Log.i(TAG, "initFragment: ");
        //fragmentTransaction=getFragmentManager().beginTransaction();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        down01Fragment = new down01Fragment();
        down02Fragment = new down02Fragment();
        fragmentTransaction.replace(R.id.fragment_down,down01Fragment);
        fragmentTransaction.show(down01Fragment);
        fragmentTransaction.commit();

    }

    private void initView() {
        Log.i(TAG, "initView: ");
        button1 = findViewById(R.id.bt_1);
        button2 = findViewById(R.id.bt_2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.bt_1:
                Toast.makeText(MainActivity.this, "11111", Toast.LENGTH_SHORT).show();
                fragmentTransaction.replace(R.id.fragment_down, down01Fragment);//replace的形式是每次都刷新，add show不会刷新，只是hide隐藏起来
                fragmentTransaction.show(down01Fragment);
                fragmentTransaction.hide(down02Fragment);
                fragmentTransaction.commit();
                break;
            case R.id.bt_2:
                Toast.makeText(MainActivity.this, "22222", Toast.LENGTH_SHORT).show();
                fragmentTransaction.replace(R.id.fragment_down, down02Fragment);//replace的形式是每次都刷新，add show不会刷新，只是hide隐藏起来
                fragmentTransaction.show(down02Fragment);
                fragmentTransaction.hide(down01Fragment);
                fragmentTransaction.commit();
                break;
        }
    }
//
//    private void showFragment(int index, int FragmentId, Fragment fragment) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        switch (index) {
//            case 0:
//                if (fragment != null && fragment.isAdded()) {
//                    transaction.replace(FragmentId, fragment);
//                }
//                hideAllFragment(transaction);
//                transaction.show(fragment);
//                transaction.commit();
//
//        }
//
//    }

}
