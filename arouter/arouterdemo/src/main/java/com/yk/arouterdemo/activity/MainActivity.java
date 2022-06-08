package com.yk.arouterdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yk.arouterdemo.R;
import com.yk.arouterdemo.aroutTable.IRouterList;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 实现路由跳转
 */

//绑定路由表
@Route(path = IRouterList.MAIN_ACTIVITY_URL)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用butterknife
        ButterKnife.bind(this);

        //注册路由
        ARouter.getInstance().inject(this);
    }

    @OnClick(R.id.button4)
    public void firstSkip(View view) {
        //路由跳转方式 第一种，直接使用路由地址的方式来跳转
//        ARouter.getInstance().build(IRouterList.SECOND_ACTIVITY_URL).navigation();
        //第二种，使用Uri的方式来进行跳转
//        Uri uri = Uri.parse(IRouterList.SECOND_ACTIVITY_URL);
//        ARouter.getInstance().build(uri).navigation();
        //第三种，在跳转的时候加上跳转监听
        Uri uri = Uri.parse(IRouterList.SECOND_ACTIVITY_URL);
        ARouter.getInstance()
                .build(uri)
                .navigation(this, new NavigationCallback() {
                    //创建
                    @Override
                    public void onFound(Postcard postcard) {
                        Toast.makeText(MainActivity.this, "onFound", Toast.LENGTH_SHORT).show();
                    }

                    //丢失
                    @Override
                    public void onLost(Postcard postcard) {
                        Toast.makeText(MainActivity.this, "onLost", Toast.LENGTH_SHORT).show();
                    }

                    //到达
                    @Override
                    public void onArrival(Postcard postcard) {
                        Toast.makeText(MainActivity.this, "onArrival", Toast.LENGTH_SHORT).show();
                    }

                    //中断
                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Toast.makeText(MainActivity.this, "onInterrupt", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    //Butterknife绑定方法
    @OnClick({R.id.firstBtn, R.id.secondBtn, R.id.thirdBtn})
    public void onViewClicked(View view) {
        String url = "";
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.firstBtn:
                url = IRouterList.MAIN_FRAGMENT_URL;
                break;
            case R.id.secondBtn:
                url = IRouterList.SECOND_FRAGMENT_URL;
                break;
            case R.id.thirdBtn:
                url = IRouterList.THIRD_FRAGMENT_URL;
                break;
        }
        Fragment fragment = (Fragment) ARouter.getInstance().build(url)
                .withBoolean("loginResult", true)
                .withDouble("amount", 20000.5)
                .withString("name", "张超")
                .withInt("age", 28)
                .navigation();
        //跳转
//        Fragment fragment = (Fragment) ARouter.getInstance()
//                .build(url)
//                .withString("name", "我是MainActivity传递过来的")
//                .navigation();
//        fragment显示位置
        transaction.replace(R.id.showFragment, fragment);
        transaction.commit();

    }


}