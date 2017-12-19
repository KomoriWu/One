package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

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


    @Override
    public void loadRecommend(int id) {
        addSubscribe(mDataManagerModel.getRecommendData(id+"")
                .compose(RxUtil.<FindBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<FindBean>(view) {
                    @Override
                    public void onNext(FindBean findBean) {
                        view.refreshData(findBean);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                }));
    }
}
