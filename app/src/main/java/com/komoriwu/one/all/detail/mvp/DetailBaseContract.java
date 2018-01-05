package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.AuthorDetailBean;
import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.komoriwu.one.model.bean.TagsDetailBean;

/**
 * Created by KomoriWu
 * on 2017-12-30.
 */


public interface DetailBaseContract {
    interface View extends BaseView {
        void showProgress();

        void hideProgress();

        void refreshTagsData(TagsDetailBean.TagInfoBean tagInfoBean);

        void refreshCategoriesData(CategoryDetailBean.CategoryInfoBean categoryInfoBean);

        void refreshAuthorData(AuthorDetailBean.PgcInfoBean pgcInfoBean);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDetailIndex(String id);
    }

}
