package com.komoriwu.one.main.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;


/**
 * Created by KomoriWu
 * on 2017-08-15.
 */

public interface MainContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }

}
