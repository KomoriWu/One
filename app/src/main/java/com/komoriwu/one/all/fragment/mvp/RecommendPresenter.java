package com.komoriwu.one.all.fragment.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public class RecommendPresenter extends RxPresenter<CommonContract.View> implements
        CommonContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public RecommendPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }

    @Override
    public void loadList() {
        loadData(0);
    }

    @Override
    public void loadMoreList(int page) {
        loadData(page);
    }

    private void loadData(final int page) {
        addSubscribe(mDataManagerModel.getRecommendData(String.valueOf(page))
                .compose(RxUtil.<FindBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<FindBean>(view) {
                    @Override
                    public void onNext(FindBean findBean) {
                        if (page==0){
                            view.refreshData(findBean);
                        }else {
                            view.showMoreDate(findBean);
                        }

                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.hideRefresh(page==0);
                    }
                }));
    }

}
