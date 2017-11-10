package com.komoriwu.one.one.detail.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;

/**
 * Created by KomoriWu
 * on 2017-11-10.
 */

public class ReadDetailContract {
    public interface View extends BaseView {
        void showContent(String content);
    }

    public  interface Presenter extends BasePresenter<View> {
        void loadReadDetail(int position);
        void loadMovieDetail(int position);
    }
}
