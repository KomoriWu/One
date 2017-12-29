package com.komoriwu.one.all.fragment;

import com.komoriwu.one.all.fragment.mvp.CommonContract;
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
 * on 2017-12-29.
 */

public class DailyPresenter extends RxPresenter<CommonContract.View> implements
        CommonContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public DailyPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }

    @Override
    public void loadList() {
        addSubscribe(mDataManagerModel.getDailyData()
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
    public void loadMoreList(HashMap<String, String> stringHashMap) {
        addSubscribe(mDataManagerModel.getDailyMoreData(stringHashMap.get(Constants.DATE),
                stringHashMap.get(Constants.NUM))
                .compose(RxUtil.<FindBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<FindBean>(view) {
                    @Override
                    public void onNext(FindBean findBean) {
                        view.showMoreDate(findBean);

                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.hideRefresh(false);
                    }
                }));
    }

}
