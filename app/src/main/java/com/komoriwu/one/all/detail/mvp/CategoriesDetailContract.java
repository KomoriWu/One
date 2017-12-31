package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.CategoryDetailBean;

/**
 * Created by KomoriWu
 * on 2017-12-30.
 */


public interface CategoriesDetailContract {
    interface View extends BaseView {
      void refreshData(CategoryDetailBean.CategoryInfoBean categoryInfoBean);
    }

    interface Presenter extends BasePresenter<View> {
       void loadCategoriesDetail(String id);
    }

}
