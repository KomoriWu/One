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

    //发现
    @GET("v5/index/tab/discovery" + END)
    Flowable<FindBean> getFindData();

    //更多发现 http://baobab.kaiyanapp.com/api/v5/index/tab/discovery?start=20&num=10
    @GET("v5/index/tab/discovery")
    Flowable<FindBean> getFindMoreData(@Query("start") String start, @Query("num") String num);

    //推荐 http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=0&deviceModel=MI%205
    @GET("v5/index/tab/allRec" + END)
    Flowable<FindBean> getRecommendData(@Query("page") String page);

    //详细页面获取推荐 http://baobab.kaiyanapp.com/api/v4/video/related?id=67546&vc=230&deviceModel=MI
    @GET("v4/video/related" + END)
    Flowable<FindBean> getDetailRecommendData(@Query("id") String id);

    //日报 http://baobab.kaiyanapp.com/api/v5/index/tab/feed
    @GET("v5/index/tab/feed" + END)
    Flowable<FindBean> getDailyData();

    //更多日报 http://baobab.kaiyanapp.com/api/v5/index/tab/feed?date=1514336400000&num=2
    @GET("v5/index/tab/feed" + END)
    Flowable<FindBean> getDailyMoreData(@Query("date") String date, @Query("num") String num);

    //创意 http://baobab.kaiyanapp.com/api/v5/index/tab/category/2
    @GET("v5/index/tab/category/2" + END)
    Flowable<FindBean> getCreativeData();

    //更多创意 http://baobab.kaiyanapp.com/api/v5/index/tab/category/2?start=10&num=10
    @GET("v5/index/tab/category/2" + END)
    Flowable<FindBean> getCreativeMoreData(@Query("start") String start, @Query("num") String num);

}