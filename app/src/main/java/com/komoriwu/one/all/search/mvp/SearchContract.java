package com.komoriwu.one.all.search.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.FindBean;

import java.util.HashMap;
import java.util.List;


/**
 * Created by KomoriWu
 * on 2018-01-03.
 */


public interface SearchContract {
    interface View extends BaseView {
        void hideRefresh(boolean isRefresh);
        void showTags(List<String> stringList);
        void refreshData(FindBean findBean);
        void showMoreDate(FindBean findBean);
    }

    interface Presenter extends BasePresenter<View> {
        void loadTagsList();
        void loadQueryList(String tag);
        void loadMoreQueryList(HashMap<String, String> stringHashMap);
    }

}
