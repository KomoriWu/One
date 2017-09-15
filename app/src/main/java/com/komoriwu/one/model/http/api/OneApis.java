package com.komoriwu.one.model.http.api;

import com.komoriwu.one.model.bean.OneIdBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public interface OneApis {
    //android
    String HOST="http://v3.wufazhuce.com:8000/api/onelist/idlist/?channel=wdj&version=4.0.2" +
            "&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=";

    //获取最新 IdList
    @GET("android")
    Flowable<OneIdBean> getOneIdList();
}
