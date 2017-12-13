package com.komoriwu.one.all.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.VideoBean;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class AllPresenter extends RxPresenter<AllContract.View> implements AllContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public AllPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }

}
