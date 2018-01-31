package com.komoriwu.one.me.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 *  on 2017/9/15.
 */

public class MePresenter extends RxPresenter<MeContract.View> implements MeContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public MePresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }


}
