package com.komoriwu.one.model.http.api;

import com.komoriwu.one.model.bean.OneIdBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public interface OneApis {
    String HOST = "http://v3.wufazhuce.com:8000/api/onelist/";

    //获取最新 IdList
    @GET("idlist")
    Flowable<OneIdBean> getOneIdList();
}
