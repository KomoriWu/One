package com.komoriwu.one.one.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.OneListBean;


/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public interface OneContract {
    interface View extends BaseView {
        void showRefresh();

        void hideRefresh();

        void refreshData(OneListBean oneListBean);
    }

    interface Presenter extends BasePresenter<View> {
        void loadOneList(int page);
    }

}
