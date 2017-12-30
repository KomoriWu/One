package com.komoriwu.one.all.leftmenu.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017-12-30.
 */


public class AllCategoriesPresenter extends RxPresenter<AllCategoriesContract.View> implements
        AllCategoriesContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public AllCategoriesPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }


    @Override
    public void loadCategories() {
        addSubscribe(mDataManagerModel.getAllCategoriesData()
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
