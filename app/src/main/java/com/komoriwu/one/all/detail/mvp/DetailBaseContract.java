package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.komoriwu.one.model.bean.TagsDetailInfo;

/**
 * Created by KomoriWu
 * on 2017-12-30.
 */


public interface DetailBaseContract {
    interface View extends BaseView {
        void showProgress();

        void hideProgress();

        void refreshTagsData(TagsDetailInfo.TagInfoBean tagInfoBean);
        void refreshCategories(CategoryDetailBean.CategoryInfoBean categoryInfoBean);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDetailIndex(String id);
    }

}
