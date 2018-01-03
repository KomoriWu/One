package com.komoriwu.one.all.search.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2018-01-03.
 */


public class SearchPresenter extends RxPresenter<SearchContract.View> implements SearchContract.
        Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public SearchPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }


    @Override
    public void loadTags() {
        addSubscribe(mDataManagerModel.getQueriesHotData()
                .compose(RxUtil.<List<String>>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<List<String>>(view) {
                    @Override
                    public void onNext(List<String> stringList) {
                        view.showTags(stringList);

                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                }));
    }

    @Override
    public void loadQueryList(String tag) {
        addSubscribe(mDataManagerModel.getQueryData(tag)
                .compose(RxUtil.<FindBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<FindBean>(view) {
                    @Override
                    public void onNext(FindBean findBean) {
                        view.showQueryList(findBean);

                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                }));
    }
}
