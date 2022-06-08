package com.yk.butterknife;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;

/***
 *
 * Buffterknife 注解库
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.button)
    Button username;
    @BindView(R.id.textView)
    TextView password;

    @BindString(R.string.app_name)String appName;

    @OnTextChanged(R.id.textView)
    void TextChanged(){
        Toast.makeText(this,"文本改变",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button)
    void submit() {
        // TODO call server...
        Toast.makeText(this, "绑定成功:" + appName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        // TODO Use fields...
    }
}