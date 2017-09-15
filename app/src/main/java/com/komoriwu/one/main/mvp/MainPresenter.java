package com.komoriwu.one.main.mvp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.komoriwu.one.R;
import com.komoriwu.one.base.RxPresenter;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 *  on 2017/9/15.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }


    @Override
    public void switchNavView(int id) {
        switch (id) {
            case R.id.rb_one:
                view.switchOneView();
                break;
            case R.id.rb_all:
                view.switchAllView();
                break;
            case R.id.rb_me:
                view.switchMeView();
                break;
        }
    }


}
