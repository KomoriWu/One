package com.komoriwu.one.one.detail.mvp;

import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.BaseView;
import com.komoriwu.one.model.bean.ContentListBean;
import com.komoriwu.one.model.bean.MovieDetailBean;
import com.komoriwu.one.model.bean.MusicDetailBean;
import com.komoriwu.one.model.bean.ReadDetailBean;

/**
 * Created by KomoriWu
 * on 2017-11-10.
 */

public class ReadDetailContract {
    public interface View extends BaseView {
        void showReadData(ReadDetailBean readDetailBean);
        void showMovieData(MovieDetailBean readDetailBean);
        void showMusicData(MusicDetailBean musicDetailBean);
    }

    public  interface Presenter extends BasePresenter<View> {
        void loadDetail(ContentListBean contentListBean);
        void loadReadDetail(String itemId);
        void loadMovieDetail(String itemId);
        void loadMusicDetail(String itemId);
    }
}
