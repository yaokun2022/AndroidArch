package com.yk.arouterdemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yk.arouterdemo.R;
import com.yk.arouterdemo.aroutTable.IRouterList;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = IRouterList.MAIN_FRAGMENT_URL)
public class FirstFragment extends Fragment {

    @Autowired()
    @BindView(R.id.button5)
    TextView tv;
    @Autowired(name = "name")
    String name;
    @Autowired(name = "age")
    int age;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("TAG", "onCreateView: --->" + name);
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

}



