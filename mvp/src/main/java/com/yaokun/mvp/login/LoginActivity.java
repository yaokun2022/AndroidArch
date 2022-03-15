package com.yaokun.mvp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yaokun.mvp.MainActivity;
import com.yaokun.mvp.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private EditText username;
    private EditText password;
    private Button login;

    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(v -> login());

        setPresenter(new LoginPresenter(this));
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void login() {
        // 数据校验

        presenter.login(username.toString(), password.toString());

    }

    @Override
    public void loginResult(String user) {

        // 登陆成功

        // 跳转
        startActivity(new Intent(this, MainActivity.class));

    }

    @Override
    public void loadUsernamePassword() {

    }
}