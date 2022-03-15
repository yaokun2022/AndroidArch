package com.yaokun.mvvm.login;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.yaokun.mvvm.R;
import com.yaokun.mvvm.data.RemoteRepository;
import com.yaokun.mvvm.entity.User;
import com.yaokun.mvvm.utils.PhoneUtils;


public class LoginViewModel extends ViewModel {

    // 用户名
    public MutableLiveData<String> usernameData = new MutableLiveData<>();

    // 密码
    public MutableLiveData<String> passwordData = new MutableLiveData<>();

    // 错误提示
    public MutableLiveData<String> errorHintData = new MutableLiveData<>();

    // 校验手机号码
    public MutableLiveData<Boolean> isPhoneData = new MutableLiveData<>(false);

    // 是否显示密码
    public MutableLiveData<Boolean> isShowPwdData = new MutableLiveData<>(false);

    // 用户信息
    public MutableLiveData<User> userData = new MutableLiveData<>();

    //进度条
    public MutableLiveData<Boolean> isShowProgressBar = new MutableLiveData<>(false);


    public LoginViewModel() {
        usernameData.observeForever(username -> {
            if (PhoneUtils.checkPhone(username)) {
                isPhoneData.setValue(true);
                errorHintData.setValue("");
            } else {
                errorHintData.setValue("请输入正确的手机号码");
                isPhoneData.setValue(false);
            }
        });
    }

    public void toggleShowPwd(){
        isShowPwdData.setValue(!isShowPwdData.getValue());
    }

    // 登陆
    public void login() {
        if(!isPhoneData.getValue()) {
            errorHintData.setValue("请输入正确的手机号码");
            return;
        }

        if (passwordData.getValue()==null || passwordData.getValue().length()<1) {
            errorHintData.setValue("请输入密码");
            return;
        }

        isShowProgressBar.setValue(true);
        RemoteRepository.login(usernameData.getValue(), passwordData.getValue(), new RemoteRepository.Callback() {
            @Override
            public void succeed(User user) {
                userData.setValue(user);
                isShowProgressBar.setValue(false);
            }

            @Override
            public void failed(int errCode, String errMsg) {
                errorHintData.setValue(errMsg + " ["+errCode+"]");
                isShowProgressBar.setValue(false);
            }
        });

    }

}
