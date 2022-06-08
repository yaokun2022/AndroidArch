package com.yk.bbc.login;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SPUtils;
import com.yk.bbc.list.IRouterList;
import com.yk.bbc.R;
import com.yk.bbc.databinding.ActivityLoginBinding;
import com.yk.bbc.my.MyActivity;
@Route(path = IRouterList.LOGIN_ACTIVITY)
public class LoginActivity extends MyActivity<ActivityLoginBinding, LoginViewModel> {

    @Override
    protected int myView() {
        return R.layout.activity_login;
    }

    @Override
    protected void myCreate(@NonNull ActivityLoginBinding bind, @NonNull LoginViewModel vm) {
        bind.setVm(vm);
//        ARouter.getInstance().inject(this);
        bind.username.setText(SPUtils.getInstance().getString("username"));
        bind.username.setText(SPUtils.getInstance().getString("password"));
    }

}