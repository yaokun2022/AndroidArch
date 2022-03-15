package com.yaokun.mvvm.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.yaokun.mvvm.MainActivity;
import com.yaokun.mvvm.R;
import com.yaokun.mvvm.data.RemoteRepository;
import com.yaokun.mvvm.databinding.ActivityLoginBinding;
import com.yaokun.mvvm.entity.User;
import com.yaokun.mvvm.utils.PhoneUtils;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel viewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setVm(viewModel);

        binding.login.setVisibility(View.VISIBLE);

        viewModel.isShowPwdData.observe(this, aBoolean -> {
            if (aBoolean) {
                binding.pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                binding.pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        viewModel.userData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Toast.makeText(LoginActivity.this, "登陆成功：" + user.username, Toast.LENGTH_SHORT).show();

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

    }


}