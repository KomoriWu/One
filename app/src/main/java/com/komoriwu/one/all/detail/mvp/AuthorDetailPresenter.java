package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.AuthorDetailBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2018-01-05.
 */


public class AuthorDetailPresenter extends RxPresenter<DetailBaseContract.View> implements
        DetailBaseContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public AuthorDetailPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }


    @Override
    public void loadDetailIndex(String id) {
        view.showProgress();
        mDataManagerModel.setAuthorId(id);
        addSubscribe(mDataManagerModel.getAuthorDetailIndexData(id)
                .compose(RxUtil.<AuthorDetailBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<AuthorDetailBean>(view) {
                    @Override
                    public void onNext(AuthorDetailBean authorDetailBean) {
                        view.refreshAuthorData(authorDetailBean.getPgcInfo());
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.hideProgress();
                    }
                }));
    }
}
