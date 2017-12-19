package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.FindBean;


/**
 * Created by KomoriWu
 * on 2017-12-19.
 */

public interface VideoCardContract {
    interface View extends BaseView {
      void refreshData(FindBean findBean);
    }

    interface Presenter extends BasePresenter<View> {
       void loadRecommend(int id);
    }

}
