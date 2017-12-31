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


public class CategoriesDetailPresenter extends RxPresenter<CategoriesDetailContract.View> implements
        CategoriesDetailContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public CategoriesDetailPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }


    @Override
    public void loadCategoriesDetail(String id) {
        mDataManagerModel.setCategoriesId(id);
        addSubscribe(mDataManagerModel.getCategoriesDetailData(id)
                .compose(RxUtil.<CategoryDetailBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<CategoryDetailBean>(view) {
                    @Override
                    public void onNext(CategoryDetailBean categoryDetailBean) {
                        view.refreshData(categoryDetailBean.getCategoryInfo());
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                }));
    }
}
