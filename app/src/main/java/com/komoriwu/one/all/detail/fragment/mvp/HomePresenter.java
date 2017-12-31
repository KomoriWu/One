package com.komoriwu.one.all.detail.fragment.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.RxUtil;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017-12-31.
 */


public class HomePresenter extends RxPresenter<HomeContract.View> implements
        HomeContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public HomePresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }

    @Override
    public void loadList(int position) {
        addSubscribe(mDataManagerModel.getCDetailData(position, mDataManagerModel.
                getCategoriesId())
                .compose(RxUtil.<FindBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<FindBean>(view) {
                    @Override
                    public void onNext(FindBean findBean) {
                        view.refreshData(findBean);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.hideRefresh(true);
                    }
                }));
    }

    @Override
    public void loadMoreList() {

    }
}
