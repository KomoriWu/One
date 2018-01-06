package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2018-01-06.
 */


public class WebDetailPresenter extends RxPresenter<WebDetailContract.View> implements WebDetailContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public WebDetailPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }


}
