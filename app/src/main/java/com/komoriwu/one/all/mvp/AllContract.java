package com.komoriwu.one.all.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.VideoBean;


/**
 * Created by KomoriWu
 *  on 2017/9/15.
 */

public interface AllContract {
    interface View extends BaseView {
        void showVideoData(VideoBean videoBean);
    }

    interface Presenter extends BasePresenter<View> {
        void getVideoData();
    }

}
