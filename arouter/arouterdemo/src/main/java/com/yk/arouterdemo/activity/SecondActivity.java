package com.yk.arouterdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yk.arouterdemo.R;
import com.yk.arouterdemo.aroutTable.IRouterList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/***
 * 路由跳转
 */
@Route(path = IRouterList.SECOND_ACTIVITY_URL)
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //注册butterknife
        ButterKnife.bind(this);
        //注册路由
        ARouter.getInstance().inject(this);


    }

}