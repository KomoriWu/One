package com.komoriwu.one.all.detail.mvp;

import android.support.annotation.NonNull;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
    public void loadVideoData(String id) {
        addSubscribe(mDataManagerModel.getVideoDetailData(id)
                .compose(RxUtil.<DataBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<DataBean>(view) {
                    @Override
                    public void onNext(DataBean dataBean) {
                        view.showVideoData(dataBean);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                }));
    }

    @Override
    public void loadRecommend(int id) {
        addSubscribe(mDataManagerModel.getDetailRecommendData(String.valueOf(id))
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
