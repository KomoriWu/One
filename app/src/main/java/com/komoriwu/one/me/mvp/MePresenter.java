package com.komoriwu.one.me.mvp;

import com.komoriwu.one.base.RxPresenter;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 *  on 2017/9/15.
 */

public class MePresenter extends RxPresenter<MeContract.View> implements MeContract.Presenter {

    @Inject
    public MePresenter() {
    }


}
