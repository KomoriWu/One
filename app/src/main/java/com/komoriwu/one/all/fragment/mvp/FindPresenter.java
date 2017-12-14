package com.komoriwu.one.all.fragment.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

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
    @Override
    public void loadFindList() {
        addSubscribe(mDataManagerModel.getFindData()
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
