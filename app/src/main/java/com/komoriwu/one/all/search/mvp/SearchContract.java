package com.komoriwu.one.all.search.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.FindBean;

import java.util.List;


/**
 * Created by KomoriWu
 * on 2018-01-03.
 */


public interface SearchContract {
    interface View extends BaseView {
        void showTags(List<String> stringList);
        void showQueryList(FindBean findBean);
    }

    interface Presenter extends BasePresenter<View> {
        void loadTags();
        void loadQueryList(String tag);
    }

}
