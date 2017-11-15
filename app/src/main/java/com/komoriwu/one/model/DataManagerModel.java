package com.komoriwu.one.model;

import com.komoriwu.one.model.bean.MovieDetailBean;
import com.komoriwu.one.model.bean.MusicDetailBean;
import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.model.bean.ReadDetailBean;
import com.komoriwu.one.model.db.DBHelper;
import com.komoriwu.one.model.http.HttpHelper;
import com.komoriwu.one.model.http.reponse.MyHttpResponse;
import com.komoriwu.one.model.prefs.PreferencesHelper;

import io.reactivex.Flowable;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class DataManagerModel implements HttpHelper, DBHelper, PreferencesHelper {
    private HttpHelper mHttpHelper;
    private DBHelper mDBDbHelper;
    private PreferencesHelper mPreferencesHelper;

    public DataManagerModel(HttpHelper mHttpHelper, DBHelper mDBDbHelper, PreferencesHelper
            mPreferencesHelper) {
        this.mHttpHelper = mHttpHelper;
        this.mDBDbHelper = mDBDbHelper;
        this.mPreferencesHelper = mPreferencesHelper;
    }

    @Override
    public Flowable<OneIdBean> fetchOneId() {
        return mHttpHelper.fetchOneId();
    }

    @Override
    public Flowable<MyHttpResponse<OneListBean>> getOneList(String id) {
        return mHttpHelper.getOneList(id);
    }

    @Override
    public Flowable<MyHttpResponse<ReadDetailBean>> getReadDetail(String itemId) {
        return mHttpHelper.getReadDetail(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<MovieDetailBean>> getMovieDetail(String itemId) {
        return mHttpHelper.getMovieDetail(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<MusicDetailBean>> getMusicDetail(String itemId) {
        return mHttpHelper.getMusicDetail(itemId);
    }
}
