package com.yk.arouterdemo.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yk.arouterdemo.R;
import com.yk.arouterdemo.aroutTable.IRouterList;

@Route(path = IRouterList.SECOND_FRAGMENT_URL)
public class SecondFragment extends Fragment {

    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
}
