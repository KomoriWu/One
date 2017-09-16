package com.komoriwu.one.model.http;

import com.komoriwu.one.base.BaseView;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by KomoriWu
 * on 2017/9/16.
 */

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mBaseView;
    private String mErrorMsg;
    private boolean mIsShowErrorState = true;

    public CommonSubscriber(BaseView mBaseView) {
        this.mBaseView = mBaseView;
    }

    public CommonSubscriber(BaseView mBaseView, String mErrorMsg) {
        this.mBaseView = mBaseView;
        this.mErrorMsg = mErrorMsg;
    }

    public CommonSubscriber(BaseView mBaseView, boolean mIsShowErrorState) {
        this.mBaseView = mBaseView;
        this.mIsShowErrorState = mIsShowErrorState;
    }

    public CommonSubscriber(BaseView mBaseView, String mErrorMsg, boolean mIsShowErrorState) {
        this.mBaseView = mBaseView;
        this.mErrorMsg = mErrorMsg;
        this.mIsShowErrorState = mIsShowErrorState;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable t) {
        if (mBaseView == null) {
            return;
        }
        mBaseView.showErrorMsg(t.getMessage());

    }
}
