package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.TagsDetailInfo;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.utils.RxUtil;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2018-01-05.
 */


public class TagsDetailPresenter extends RxPresenter<DetailBaseContract.View> implements
        DetailBaseContract.Presenter {
    private DataManagerModel mDataManagerModel;

    @Inject
    public TagsDetailPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }


    @Override
    public void loadDetailIndex(String id) {
        view.showProgress();
        mDataManagerModel.setTagsId(id);
        addSubscribe(mDataManagerModel.getTagDetailIndexData(id)
                .compose(RxUtil.<TagsDetailInfo>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<TagsDetailInfo>(view) {
                    @Override
                    public void onNext(TagsDetailInfo tagsDetailInfo) {
                        view.refreshTagsData(tagsDetailInfo.getTagInfo());
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.hideProgress();
                    }
                }));
    }
}
