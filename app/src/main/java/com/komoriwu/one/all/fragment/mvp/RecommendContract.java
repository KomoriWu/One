package com.komoriwu.one.all.fragment.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.FindBean;


/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public interface RecommendContract {
    interface View extends BaseView {
        void showRefresh();

        void hideRefresh(boolean isRefresh);

        void refreshData(FindBean findBean);

        void showMoreDate(FindBean findBean);
        void showUI();
    }

    interface Presenter extends BasePresenter<View> {
        void loadFindList();
        void loadFindMoreList(int start);
    }

}
