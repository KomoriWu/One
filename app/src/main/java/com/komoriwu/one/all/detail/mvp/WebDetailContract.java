package com.komoriwu.one.all.detail.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;


/**
 * Created by KomoriWu
 * on 2018-01-06.
 */

public interface WebDetailContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }

}
