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
 * on 2017-12-29.
 */

public class CategoryPresenter extends RxPresenter<CommonContract.View> implements
        CommonContract.Presenter {
    private DataManagerModel mDataManagerModel;
    private int position;

    @Inject
    public CategoryPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void loadList() {
        addSubscribe(mDataManagerModel.getCategoryData(position)
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
        addSubscribe(mDataManagerModel.getCategoryMoreData(position, stringHashMap.get(Constants.
                START), stringHashMap.get(Constants.NUM))
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
