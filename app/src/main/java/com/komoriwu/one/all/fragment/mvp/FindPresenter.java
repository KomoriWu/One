package com.komoriwu.one.all.fragment.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017-12-13.
 */

public class FindPresenter extends RxPresenter<FindContract.View> implements FindContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public FindPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }

}
