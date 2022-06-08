package com.yk.goujin_entrance_guard.view;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import com.yk.goujin_entrance_guard.R;
import com.yk.goujin_entrance_guard.databinding.HomeAdvertisingViewBinding;

public class AdvertisingView extends ConstraintLayout {

    private HomeAdvertisingViewBinding bind;

    public AdvertisingView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        initUrl();
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        bind = DataBindingUtil.bind(LayoutInflater.from(getContext()).inflate(R.layout.home_advertising_view, null));
        bind.getRoot().setLayoutParams(params);

    }

    private void initUrl() {

    }
}
