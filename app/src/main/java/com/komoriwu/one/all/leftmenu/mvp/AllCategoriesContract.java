package com.komoriwu.one.all.leftmenu.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.FindBean;

/**
 * Created by KomoriWu
 * on 2017-12-30.
 */


public interface AllCategoriesContract {
    interface View extends BaseView {
      void refreshData(FindBean findBean);
    }

    interface Presenter extends BasePresenter<View> {
       void loadCategories();
    }

}
