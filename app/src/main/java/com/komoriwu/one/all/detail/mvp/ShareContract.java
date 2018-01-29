package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.AuthorDetailBean;
import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.komoriwu.one.model.bean.TagsDetailBean;

/**
 * Created by KomoriWu
 * on 2018-01-29.
 */

public interface ShareContract {
    interface View extends BaseView {
        void bottomShow();

        void bottomHide();
        void onBack();
    }

    interface Presenter extends BasePresenter<View> {
        void bottomShow();
        void bottomHide();
    }

}
