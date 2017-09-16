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
    String HOST = "http://news-at.zhihu.com/api/4/";

    //获取最新 IdList
    @GET("news/latest")
    Flowable<OneIdBean> getOneIdList();
}
