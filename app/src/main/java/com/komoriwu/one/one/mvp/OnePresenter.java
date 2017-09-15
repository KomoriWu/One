package com.komoriwu.one.one.mvp;

import com.komoriwu.one.base.RxPresenter;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 *  on 2017/9/15.
 */

public class OnePresenter extends RxPresenter<OneContract.View> implements OneContract.Presenter {

    @Inject
    public OnePresenter() {
    }


}
