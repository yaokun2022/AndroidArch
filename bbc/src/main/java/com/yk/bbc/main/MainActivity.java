package com.yk.bbc.main;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yk.bbc.R;
import com.yk.bbc.databinding.ActivityMainBinding;
import com.yk.bbc.list.IRouterList;
import com.yk.bbc.login.LoginActivity;
import com.yk.bbc.my.MyActivity;
@Route(path = IRouterList.MAIN_ACTIVITY)
public class MainActivity extends MyActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected int myView() {
        return R.layout.activity_main;
    }

    @Override
    protected void myCreate(@NonNull ActivityMainBinding bind, @NonNull MainViewModel vm) {
        bind.setVm(vm);
//        go(LoginActivity.class);

    }

}