package com.komoriwu.one.all.detail.mvp;

import android.app.Activity;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by KomoriWu
 * on 2017-12-19.
 */


public class VideoCardPresenter extends RxPresenter<VideoCardContract.View> implements
        VideoCardContract.Presenter {
    private DataManagerModel mDataManagerModel;

    private boolean mIsShowHeadUi=true;

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

    @Override
    public void showHeadUI() {
        addSubscribe(Flowable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (mIsShowHeadUi)
                            view.showHeadUI();
                    }
                }));
    }

    @Override
    public void requestPermissions(Activity activity, String[] permissions) {
        RxPermissions rxPermission = new RxPermissions(activity);
        rxPermission.requestEach(permissions)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            // 用户已经同意该权限
                            view.permissionGranted();
                        }
                    }
                });

    }

    @Override
    public void setIsShowHeadUi(boolean mIsShowHeadUi) {
        this.mIsShowHeadUi = mIsShowHeadUi;
    }
}
