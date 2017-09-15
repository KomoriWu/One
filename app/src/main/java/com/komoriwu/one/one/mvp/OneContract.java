package com.komoriwu.one.one.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;


/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public interface OneContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
        void getOneIdList();
    }

}
