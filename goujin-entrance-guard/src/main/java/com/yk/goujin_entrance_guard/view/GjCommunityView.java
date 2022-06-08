package com.yk.goujin_entrance_guard.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;

import com.yk.goujin_entrance_guard.R;
import com.yk.goujin_entrance_guard.databinding.GjCommunityViewBinding;

public class GjCommunityView extends LinearLayout {

    private GjCommunityViewBinding bind;

    public GjCommunityView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        bind = DataBindingUtil.bind(LayoutInflater.from(getContext()).inflate(R.layout.gj_community_view, null));
        bind.getRoot().setLayoutParams(params);
        setDataString();
        setQeCode();
        showData();
        addView(bind.getRoot());
    }

    private void showData() {

    }

    private void setQeCode() {

    }

    public void setDataString() {

    }

}
