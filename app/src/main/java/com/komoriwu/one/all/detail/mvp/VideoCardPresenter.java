package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017-12-19.
 */


public class VideoCardPresenter extends RxPresenter<VideoCardContract.View> implements
        VideoCardContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public VideoCardPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }


}
