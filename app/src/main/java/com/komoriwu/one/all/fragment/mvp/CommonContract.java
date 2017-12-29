package com.komoriwu.one.all.fragment.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.FindBean;

import java.util.HashMap;


/**
 * Created by KomoriWu
 * on 2017-12-13.
 */
public interface CommonContract {

    interface View extends BaseView {
        void showRefresh();

        void hideRefresh(boolean isRefresh);

        void refreshData(FindBean findBean);

        void showMoreDate(FindBean findBean);
    }

    interface Presenter extends BasePresenter<View> {
        void loadList();

        void loadMoreList(HashMap<String, String> stringHashMap);
    }

}
