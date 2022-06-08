package com.yk.goujin_entrance_guard.door;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yk.goujin_entrance_guard.R;
import com.yk.goujin_entrance_guard.databinding.ActivityOperDoorBinding;
import com.yk.goujin_entrance_guard.my.MyActivity;

public class OpenDoorActivity extends MyActivity<ActivityOperDoorBinding, OpenDoorViewModel> {

    /**
     * 布局文件
     *
     * @return layoutId
     */
    @Override
    protected int myView() {
        return R.layout.activity_oper_door;
    }

    /**
     * 业务逻辑
     *
     * @param bind Binding
     * @param vm   ViewModel
     */
    @Override
    protected void myCreate(@NonNull ActivityOperDoorBinding bind, @NonNull OpenDoorViewModel vm) {

    }

}