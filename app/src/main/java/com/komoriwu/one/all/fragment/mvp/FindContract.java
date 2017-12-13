package com.komoriwu.one.all.fragment.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;


/**
 * Created by KomoriWu
 * on 2017-12-13.
 */
public interface FindContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }

}
