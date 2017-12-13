package com.komoriwu.one.me.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

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


    @Override
    public void loadVideoData() {
        view.showRefresh();
        addSubscribe(mDataManagerModel.getAllVideo()
                .compose(RxUtil.<VideoBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<VideoBean>(view) {
                    @Override
                    public void onNext(VideoBean videoBean) {
                        view.refreshVideoData(videoBean);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.hideRefresh();
                    }
                }));
    }

    @Override
    public void loadVideoData(String date, String num, String page) {
        view.showRefresh();
        addSubscribe(mDataManagerModel.getAllVideo(date, num, page)
                .compose(RxUtil.<VideoBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<VideoBean>(view) {
                    @Override
                    public void onNext(VideoBean videoBean) {
                        view.refreshVideoData(videoBean);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.hideRefresh();
                    }
                }));
    }
}
