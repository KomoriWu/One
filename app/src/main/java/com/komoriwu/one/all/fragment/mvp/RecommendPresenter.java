package com.komoriwu.one.all.fragment.mvp;

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
        loadData("0");
    }

    @Override
    public void loadMoreList(HashMap<String, String> stringHashMap) {
        loadData(stringHashMap.get(Constants.PAGE));
    }

    private void loadData(final String page) {
        addSubscribe(mDataManagerModel.getRecommendData(page)
                .compose(RxUtil.<FindBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<FindBean>(view) {
                    @Override
                    public void onNext(FindBean findBean) {
                        if (page.equals("0")) {
                            view.refreshData(findBean);
                        } else {
                            view.showMoreDate(findBean);
                        }

                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.hideRefresh(page.equals("0"));
                    }
                }));
    }

}
