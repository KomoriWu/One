package com.komoriwu.one.model.http.api;

import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.model.http.reponse.MyHttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by KomoriWu
 * on 2017-12-06.
 */

public interface VideoApis {
    String HOST = "http://baobab.kaiyanapp.com/api/v4/tabs/";

    //获取首页
    @GET("selected")
    Flowable<VideoBean> getAllVideo();

    //获取更多视频 ?date=1512349200000&num=2&page=2
    @GET("selected")
    Flowable<VideoBean> getAllVideo(@Query("date") String date,@Query("num") String num,
                                    @Query("page") String page);
}