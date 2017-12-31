package com.komoriwu.one.all.detail.fragment.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.FindBean;

import java.util.HashMap;

/**
 * Created by KomoriWu
 * on 2017-12-31.
 */


public interface HomeContract {
    interface View extends BaseView {
      void refreshData(FindBean findBean);
        void hideRefresh(boolean isRefresh);
    }

    interface Presenter extends BasePresenter<View> {
       void loadList(int position ,String id);
       void loadMoreList();
    }

}
