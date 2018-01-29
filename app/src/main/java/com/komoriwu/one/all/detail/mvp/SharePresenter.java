package com.komoriwu.one.all.detail.mvp;

import android.support.annotation.NonNull;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by KomoriWu
 * on 2018-01-29.
 */

public class SharePresenter extends RxPresenter<ShareContract.View> implements
        ShareContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public SharePresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }

    @Override
    public void bottomShow() {
        Flowable.timer(50, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        view.bottomShow();
                    }
                });
    }

    @Override
    public void bottomHide() {
        view.bottomHide();
        Flowable.timer(100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        view.onBack();
                    }
                });
    }
}
