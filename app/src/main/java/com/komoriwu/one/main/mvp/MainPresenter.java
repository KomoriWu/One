package com.komoriwu.one.main.mvp;

import com.komoriwu.one.base.RxPresenter;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017-08-15.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }


}
