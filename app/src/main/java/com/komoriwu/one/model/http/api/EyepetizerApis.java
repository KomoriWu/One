package com.komoriwu.one.model.http.api;

import com.komoriwu.one.model.bean.FindBean;
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

public interface EyepetizerApis {
    String HOST = "http://baobab.kaiyanapp.com/api/";
    String END = "?vc=230&deviceModel=MI";

    //获取首页
    @GET("v4/tabs/selected")
    Flowable<VideoBean> getAllVideo();

    //获取更多视频 ?date=1512349200000&num=2&page=2
    @GET("v4/tabs/selected")
    Flowable<VideoBean> getAllVideo(@Query("date") String date, @Query("num") String num,
                                    @Query("page") String page);

    //获取find
    @GET("v5/index/tab/discovery"+END)
    Flowable<FindBean> getFindData();

    //load more http://baobab.kaiyanapp.com/api/v5/index/tab/discovery?start=20&num=10
    @GET("v5/index/tab/discovery")
    Flowable<FindBean> getFindMoreData(@Query("start") String start, @Query("num") String num);

}