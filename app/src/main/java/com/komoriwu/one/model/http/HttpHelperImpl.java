package com.komoriwu.one.model.http;

import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.model.http.api.OneApis;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class HttpHelperImpl implements HttpHelper {
    private OneApis mOneApis;

    @Inject
    public HttpHelperImpl(OneApis mOneApis) {
        this.mOneApis = mOneApis;
    }

    @Override
    public Flowable<OneIdBean> fetchOneIdList() {
        return mOneApis.getOneIdList();
    }
}
