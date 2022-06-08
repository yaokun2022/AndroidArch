package com.yk.bbc.my;

import androidx.databinding.ViewDataBinding;

import com.bigoat.bbc.base.BaseFragment;
import com.bigoat.bbc.base.BaseViewModel;

public abstract class MyFragment<Binding extends ViewDataBinding, ViewMode extends BaseViewModel> extends BaseFragment<Binding, ViewMode> {
}
