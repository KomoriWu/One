package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017-12-30.
 */


public class CategoriesDetailPresenter extends RxPresenter<DetailBaseContract.View> implements
        DetailBaseContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public CategoriesDetailPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }


    @Override
    public void loadDetailIndex(String id) {
        view.showProgress();
        mDataManagerModel.setCategoriesId(id);
        addSubscribe(mDataManagerModel.getCategoriesDetailIndexData(id)
                .compose(RxUtil.<CategoryDetailBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<CategoryDetailBean>(view) {
                    @Override
                    public void onNext(CategoryDetailBean categoryDetailBean) {
                        view.refreshCategoriesData(categoryDetailBean.getCategoryInfo());
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.hideProgress();
                    }
                }));
    }
}
