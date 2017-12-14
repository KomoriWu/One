package com.komoriwu.one.all.fragment.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.FindBean;


/**
 * Created by KomoriWu
 * on 2017-12-13.
 */
public interface FindContract {
    interface View extends BaseView {
        void showRefresh();

        void hideRefresh();

        void refreshData(FindBean findBean);
    }

    interface Presenter extends BasePresenter<View> {
        void loadFindList();
    }

}
