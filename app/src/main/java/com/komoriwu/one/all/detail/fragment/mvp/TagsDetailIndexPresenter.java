package com.komoriwu.one.all.detail.fragment.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2018-01-05.
 */


public class TagsDetailIndexPresenter extends RxPresenter<DetailIndexContract.View> implements
        DetailIndexContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public TagsDetailIndexPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }

    @Override
    public void loadList(int position) {
        addSubscribe(mDataManagerModel.getTagDetailData(position, mDataManagerModel.
                getTagsId())
                .compose(RxUtil.<FindBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<FindBean>(view) {
                    @Override
                    public void onNext(FindBean findBean) {
                        if (view != null) {
                            view.refreshData(findBean);
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                }));
    }

    @Override
    public void loadMoreList(int position, HashMap<String, String> stringHashMap) {
        addSubscribe(mDataManagerModel.getTagDetailMoreData(position, mDataManagerModel.
                getTagsId(), stringHashMap)
                .compose(RxUtil.<FindBean>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<FindBean>(view) {
                    @Override
                    public void onNext(FindBean findBean) {
                        if (view != null) {
                            view.showMoreDate(findBean);
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }

                }));
    }
}
