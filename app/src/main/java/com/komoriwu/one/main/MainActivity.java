package com.komoriwu.one.main;

import com.komoriwu.one.R;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.main.mvp.MainPresenter;

public class MainActivity extends MvpBaseActivity<MainPresenter> {
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void init() {

    }


}
