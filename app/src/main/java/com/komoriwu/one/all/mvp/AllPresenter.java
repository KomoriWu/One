package com.komoriwu.one.all.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

import org.reactivestreams.Publisher;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

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


    @Override
    public void getVideoData() {
        addSubscribe(mDataManagerModel.getAllVideo()
                .compose(RxUtil.<VideoBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<VideoBean>(view) {
                    @Override
                    public void onNext(VideoBean videoBean) {
                        view.showVideoData(videoBean);
                    }
                }));
    }
}
