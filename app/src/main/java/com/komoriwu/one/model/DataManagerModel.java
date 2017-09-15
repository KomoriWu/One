package com.komoriwu.one.model;

import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.model.db.DBHelper;
import com.komoriwu.one.model.http.HttpHelper;
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
    public Flowable<OneIdBean> fetchOneIdList() {
        return mHttpHelper.fetchOneIdList();
    }
}
