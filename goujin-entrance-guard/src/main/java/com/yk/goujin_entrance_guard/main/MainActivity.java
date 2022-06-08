package com.yk.goujin_entrance_guard.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yk.goujin_entrance_guard.R;
import com.yk.goujin_entrance_guard.databinding.ActivityMainBinding;
import com.yk.goujin_entrance_guard.my.MyActivity;

/***
 * 主界面
 *
 */
public class MainActivity extends MyActivity<ActivityMainBinding, MainViewModel> {

    /**
     * 布局文件
     *
     * @return layoutId
     */
    @Override
    protected int myView() {
        return R.layout.activity_main;
    }

    /**
     * 业务逻辑
     *
     * @param bind Binding
     * @param vm   ViewModel
     */
    @Override
    protected void myCreate(@NonNull ActivityMainBinding bind, @NonNull MainViewModel vm) {


    }

}