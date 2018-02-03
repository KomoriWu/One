package com.komoriwu.one.all.detail.mvp;

import android.app.Activity;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;


/**
 * Created by KomoriWu
 * on 2017-12-19.
 */

public interface VideoCardContract {
    interface View extends BaseView {
        void showVideoData(DataBean dataBean);

        void refreshData(FindBean findBean);

        void permissionGranted();

        void showHeadUI();

        void hideProgress();
    }

    interface Presenter extends BasePresenter<View> {
        void loadVideoData(String id);

        void loadRecommend(int id);

        void showHeadUI();

        void setIsShowHeadUi(boolean isShowHeadUi);

        void requestPermissions(Activity activity, final String[] permissions);
    }

}
