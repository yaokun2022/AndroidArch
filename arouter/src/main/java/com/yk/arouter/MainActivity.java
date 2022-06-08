package com.yk.arouter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.OnClick;

@Route(path = IARouterConfig.HOME_MAIN_ACTIVITY_URL)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.getInstance().inject(this);
    }

    @OnClick(R.id.btn)
    public void jump(View view) {
        ARouter.getInstance().build(IARouterConfig.HOME_MAIN2_ACTIVITY_URL).navigation();
    }
}