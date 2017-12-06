package com.komoriwu.one.model.http.api;

import com.komoriwu.one.model.bean.VideoBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by KomoriWu
 * on 2017-12-06.
 */

public interface VideoApis {
    String HOST = "http://baobab.kaiyanapp.com/api/v4/tabs/selected/";

    //获取首页
    @GET(".")
    Flowable<VideoBean> getAllVideo();
}
