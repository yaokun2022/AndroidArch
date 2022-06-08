package com.yk.logindome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.yk.logindome.utils.GsonUtils;
import com.yk.logindome.utils.HttpUtils;
import com.yk.logindome.utils.SpUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/***
 * 登录界面
 */
public class MainActivity extends AppCompatActivity {

    /**
     * username 用户名
     * password 密码
     * username_et 用户名输入
     * password_et 密码输入
     * rememberPwd 记住密码选项框
     * loginBtn 登录按钮
     */
    private String username;
    private String password;
    private EditText usernameEt;
    private EditText passwordEt;
    private CheckBox rememberPwd;
    private boolean isCheck = false;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpUtils.init(this);

        //获取控件
        usernameEt = findViewById(R.id.username);
        passwordEt = findViewById(R.id.password);
        rememberPwd = findViewById(R.id.rememberPwd);
        loginBtn = findViewById(R.id.loginBtn);

        /**
         * 获取数据
         */
        username = SpUtils.getString("username", "");
        password = SpUtils.getString("password", "");
        isCheck = SpUtils.getBoolean("isCheck", false);


        //设置初始数据为SharedPreferences中的数据
        rememberPwd.setChecked(isCheck);
        usernameEt.setText(username);
        passwordEt.setText(password);


        //记住密码框选择状态
        rememberPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isCheck = true;
                    Toast.makeText(MainActivity.this, "记住密码", Toast.LENGTH_SHORT).show();
                } else {
                    isCheck = false;
                    Toast.makeText(MainActivity.this, "不记住密码", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //点击登录按钮，发送登录请求
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取账号和密码
                username = usernameEt.getText().toString().trim();
                password = passwordEt.getText().toString().trim();
                //判断账号密码是否为空
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "用户名或者密码，不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (username.equals("yk") && password.equals("123456")){
                    SpUtils.put("username", username);
                    SpUtils.put("password", password);
                    SpUtils.put("isCheck", isCheck);
                    Intent intent = new Intent(MainActivity.this, LoginSuss.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"用户名或密码错误。",Toast.LENGTH_LONG).show();
                }
//
//
//
//                Repository.login(username, password, new HttpUtils.Callback<User>() {
//                    @Override
//                    public void onSuccess(User user) {
//
//                    }
//
//                    @Override
//                    public void onFailed(int errCode, String errMsg) {
//
//                    }
//                });
            }
        });
    }


}