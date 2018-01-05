package com.komoriwu.one.model.http.api;

import com.komoriwu.one.model.bean.AuthorDetailBean;
import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.TagsDetailBean;
import com.komoriwu.one.model.bean.VideoBean;

import java.util.List;

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

    //音乐 http://baobab.kaiyanapp.com/api/v5/index/tab/category/20
    @GET("v5/index/tab/category/20" + END)
    Flowable<FindBean> getMusicData();

    //更多音乐 http://baobab.kaiyanapp.com/api/v5/index/tab/category/20?start=10&num=10
    @GET("v5/index/tab/category/20" + END)
    Flowable<FindBean> getMusicMoreData(@Query("start") String start, @Query("num") String num);

    //旅行 http://baobab.kaiyanapp.com/api/v5/index/tab/category/6
    @GET("v5/index/tab/category/6" + END)
    Flowable<FindBean> getTravelData();

    //更多旅行 http://baobab.kaiyanapp.com/api/v5/index/tab/category/6?start=10&num=10
    @GET("v5/index/tab/category/6" + END)
    Flowable<FindBean> getTravelMoreData(@Query("start") String start, @Query("num") String num);

    //科普 http://baobab.kaiyanapp.com/api/v5/index/tab/category/32
    @GET("v5/index/tab/category/32" + END)
    Flowable<FindBean> getScienceData();

    //更多科普 http://baobab.kaiyanapp.com/api/v5/index/tab/category/32?start=10&num=10
    @GET("v5/index/tab/category/32" + END)
    Flowable<FindBean> getScienceMoreData(@Query("start") String start, @Query("num") String num);

    //搞笑 http://baobab.kaiyanapp.com/api/v5/index/tab/category/28
    @GET("v5/index/tab/category/28" + END)
    Flowable<FindBean> getFunnyData();

    //更多搞笑http://baobab.kaiyanapp.com/api/v5/index/tab/category/28?start=10&num=10
    @GET("v5/index/tab/category/28" + END)
    Flowable<FindBean> getFunnyMoreData(@Query("start") String start, @Query("num") String num);

    //时尚 http://baobab.kaiyanapp.com/api/v5/index/tab/category/24
    @GET("v5/index/tab/category/24" + END)
    Flowable<FindBean> getFashionData();

    //更多时尚http://baobab.kaiyanapp.com/api/v5/index/tab/category/24?start=10&num=10
    @GET("v5/index/tab/category/24" + END)
    Flowable<FindBean> getFashionMoreData(@Query("start") String start, @Query("num") String num);

    //运动 http://baobab.kaiyanapp.com/api/v5/index/tab/category/18
    @GET("v5/index/tab/category/18" + END)
    Flowable<FindBean> getSportsData();

    //更多运动http://baobab.kaiyanapp.com/api/v5/index/tab/category/18?start=10&num=10
    @GET("v5/index/tab/category/18" + END)
    Flowable<FindBean> getSportsMoreData(@Query("start") String start, @Query("num") String num);

    //动画 http://baobab.kaiyanapp.com/api/v5/index/tab/category/10
    @GET("v5/index/tab/category/10" + END)
    Flowable<FindBean> getAnimData();

    //更多动画http://baobab.kaiyanapp.com/api/v5/index/tab/category/10?start=10&num=10
    @GET("v5/index/tab/category/10" + END)
    Flowable<FindBean> getAnimMoreData(@Query("start") String start, @Query("num") String num);

    //广告 http://baobab.kaiyanapp.com/api/v5/index/tab/category/14
    @GET("v5/index/tab/category/14" + END)
    Flowable<FindBean> getAdvertData();

    //更多广告http://baobab.kaiyanapp.com/api/v5/index/tab/category/14?start=10&num=10
    @GET("v5/index/tab/category/14" + END)
    Flowable<FindBean> getAdvertMoreData(@Query("start") String start, @Query("num") String num);

    //开胃 http://baobab.kaiyanapp.com/api/v5/index/tab/category/4
    @GET("v5/index/tab/category/4" + END)
    Flowable<FindBean> getAppetizerData();

    //更多开胃http://baobab.kaiyanapp.com/api/v5/index/tab/category/4?start=10&num=10
    @GET("v5/index/tab/category/4" + END)
    Flowable<FindBean> getAppetizerMoreData(@Query("start") String start, @Query("num") String num);

    //生活 http://baobab.kaiyanapp.com/api/v5/index/tab/category/36
    @GET("v5/index/tab/category/36" + END)
    Flowable<FindBean> getLifeData();

    //更多生活http://baobab.kaiyanapp.com/api/v5/index/tab/category/36?start=10&num=10
    @GET("v5/index/tab/category/36" + END)
    Flowable<FindBean> getLifeMoreData(@Query("start") String start, @Query("num") String num);

    //剧情 http://baobab.kaiyanapp.com/api/v5/index/tab/category/12
    @GET("v5/index/tab/category/12" + END)
    Flowable<FindBean> getPlotData();

    //更多剧情http://baobab.kaiyanapp.com/api/v5/index/tab/category/12?start=10&num=10
    @GET("v5/index/tab/category/12" + END)
    Flowable<FindBean> getPlotMoreData(@Query("start") String start, @Query("num") String num);

    //预告 http://baobab.kaiyanapp.com/api/v5/index/tab/category/8
    @GET("v5/index/tab/category/8" + END)
    Flowable<FindBean> getTrailerData();

    //更多预告http://baobab.kaiyanapp.com/api/v5/index/tab/category/8?start=10&num=10
    @GET("v5/index/tab/category/8" + END)
    Flowable<FindBean> getTrailerMoreData(@Query("start") String start, @Query("num") String num);

    //集锦 http://baobab.kaiyanapp.com/api/v5/index/tab/category/34
    @GET("v5/index/tab/category/34" + END)
    Flowable<FindBean> getHighlightsData();

    //更多集锦http://baobab.kaiyanapp.com/api/v5/index/tab/category/34?start=10&num=10
    @GET("v5/index/tab/category/34" + END)
    Flowable<FindBean> getHighlightsMoreData(@Query("start") String start, @Query("num") String num);

    //记录 http://baobab.kaiyanapp.com/api/v5/index/tab/category/22
    @GET("v5/index/tab/category/22" + END)
    Flowable<FindBean> getRecordData();

    //更多记录http://baobab.kaiyanapp.com/api/v5/index/tab/category/22?start=10&num=10
    @GET("v5/index/tab/category/22" + END)
    Flowable<FindBean> getRecordMoreData(@Query("start") String start, @Query("num") String num);

    //游戏 http://baobab.kaiyanapp.com/api/v5/index/tab/category/30
    @GET("v5/index/tab/category/30" + END)
    Flowable<FindBean> getGameData();

    //更多游戏http://baobab.kaiyanapp.com/api/v5/index/tab/category/30?start=10&num=10
    @GET("v5/index/tab/category/30" + END)
    Flowable<FindBean> getGameMoreData(@Query("start") String start, @Query("num") String num);

    //萌宠 http://baobab.kaiyanapp.com/api/v5/index/tab/category/26
    @GET("v5/index/tab/category/26" + END)
    Flowable<FindBean> getCuteData();

    //更多萌宠http://baobab.kaiyanapp.com/api/v5/index/tab/category/26?start=10&num=10
    @GET("v5/index/tab/category/26" + END)
    Flowable<FindBean> getCuteMoreData(@Query("start") String start, @Query("num") String num);

    //综艺 http://baobab.kaiyanapp.com/api/v5/index/tab/category/38
    @GET("v5/index/tab/category/38" + END)
    Flowable<FindBean> getArtsData();

    //更多综艺http://baobab.kaiyanapp.com/api/v5/index/tab/category/38?start=10&num=10
    @GET("v5/index/tab/category/38" + END)
    Flowable<FindBean> getArtsMoreData(@Query("start") String start, @Query("num") String num);

    //所有分类 http://baobab.kaiyanapp.com/api/v4/categories/all
    @GET("v4/categories/all" + END)
    Flowable<FindBean> getAllCategoriesData();

    //分类详情 http://baobab.kaiyanapp.com/api/v4/categories/detail/tab?id=24
    @GET("v4/categories/detail/tab" + END)
    Flowable<CategoryDetailBean> getCategoriesDetailData(@Query("id") String id);

    //分类详情首页 http://baobab.kaiyanapp.com/api/v4/categories/detail/index?id=24
    @GET("v4/categories/detail/index" + END)
    Flowable<FindBean> getCDetailHomeData(@Query("id") String id);

    //分类详情更多首页 http://baobab.kaiyanapp.com/api/v4/categories/detail/index?id=24&page=1&needFilter=true
    @GET("v4/categories/detail/index" + END)
    Flowable<FindBean> getCDetailMoreHomeData(@Query("id") String id, @Query("page") String page);

    //分类详情全部 http://baobab.kaiyanapp.com/api/v4/categories/videoList?id=24
    @GET("v4/categories/videoList" + END)
    Flowable<FindBean> getCDetailALLData(@Query("id") String id);

    //分类详情更多全部 http://baobab.kaiyanapp.com/api/v4/categories/videoList?start=10&num=10&id=24
    @GET("v4/categories/videoList" + END)
    Flowable<FindBean> getCDetailMoreALLData(@Query("id") String id, @Query("start") String start,
                                             @Query("num") String num);

    //分类详情作者 http://baobab.kaiyanapp.com/api/v4/categories/detail/pgcs?id=24
    @GET("v4/categories/detail/pgcs" + END)
    Flowable<FindBean> getCDetailAuthorData(@Query("id") String id);

    //分类详情更多作者 http://baobab.kaiyanapp.com/api/v4/categories/detail/pgcs?id=24&start=5&num=5
    @GET("v4/categories/detail/pgcs" + END)
    Flowable<FindBean> getCDetailMoreAuthorData(@Query("id") String id, @Query("start") String start,
                                                @Query("num") String num);

    //分类详情专辑 http://baobab.kaiyanapp.com/api/v4/categories/detail/playlist?id=24
    @GET("v4/categories/detail/playlist" + END)
    Flowable<FindBean> getCDetailPlayListData(@Query("id") String id);

    //分类详情更多专辑 http://baobab.kaiyanapp.com/api/v4/categories/detail/playlist?id=24&start=5&num=5
    @GET("v4/categories/detail/playlist" + END)
    Flowable<FindBean> getCDetailMorePlayListData(@Query("id") String id, @Query("start") String start,
                                                  @Query("num") String num);

    //详情页面 http://baobab.kaiyanapp.com/api/v2/video/17631
    @GET("v2/video/{id}" + END)
    Flowable<DataBean> getVideoDetailData(@Path("id") String id);

    //热门搜索词 http://baobab.kaiyanapp.com/api/v3/queries/hot
    @GET("v3/queries/hot" + END)
    Flowable<List<String>> getQueriesHotData();

    //搜索 http://baobab.kaiyanapp.com/api/v1/search?query=搜素词
    @GET("v1/search" + END)
    Flowable<FindBean> getQueryData(@Query("query") String query);

    //更多搜索 http://baobab.kaiyanapp.com/api/v1/search?start=10&num=10&query=搜素词
    @GET("v1/search" + END)
    Flowable<FindBean> getMoreQueryData(@Query("query") String query, @Query("start") String start,
                                        @Query("num") String num);

    //标签首页 http://baobab.kaiyanapp.com/api/v1/tag/index?id=460
    @GET("v1/tag/index" + END)
    Flowable<TagsDetailBean> getTagIndexData(@Query("id") String id);

    //标签视频 http://baobab.kaiyanapp.com/api/v1/tag/videos?id=460
    @GET("v1/tag/videos" + END)
    Flowable<FindBean> getTagVideoData(@Query("id") String id);

    //更多标签视频 http://baobab.kaiyanapp.com/api/v1/tag/videos?start=10&num=10&strategy=date&id=460
    @GET("v1/tag/videos" + END)
    Flowable<FindBean> getTagMoreVideoData(@Query("id") String id, @Query("start") String start,
                                           @Query("num") String num, @Query("strategy") String strategy);

    //标签动态 http://baobab.kaiyanapp.com/api/v1/tag/dynamics?id=460
    @GET("v1/tag/dynamics" + END)
    Flowable<FindBean> getTagDynamicsData(@Query("id") String id);

    //更多标签动态 http://baobab.kaiyanapp.com/api/v1/tag/dynamics?start=10&num=10&strategy=date&id=460
    @GET("v1/tag/dynamics" + END)
    Flowable<FindBean> getTagMoreDynamicsData(@Query("id") String id, @Query("start") String start,
                                              @Query("num") String num, @Query("strategy") String strategy);

    //作者详情 http://baobab.kaiyanapp.com/api/v5/userInfo/tab?id=2172&userType=PGC
    @GET("v5/userInfo/tab" + END)
    Flowable<AuthorDetailBean> getAuthorDetailIndexData(@Query("id") String id,
                                                        @Query("userType") String userType);

    //作者详情首页 http://baobab.kaiyanapp.com/api/v5/userInfo/tab/index?id=2164&userType=PGC
    @GET("v5/userInfo/tab/index" + END)
    Flowable<FindBean> getAuthorIndexData(@Query("id") String id,
                                          @Query("userType") String userType);

    //作者详情视频 http://baobab.kaiyanapp.com/api/v4/pgcs/videoList?id=2164
    @GET("v4/pgcs/videoList" + END)
    Flowable<FindBean> getAuthorVideoData(@Query("id") String id);

    //作者详情更多视频 http://baobab.kaiyanapp.com/api/v4/pgcs/videoList?start=10&num=10&id=2164&strategy=date
    @GET("v4/pgcs/videoList" + END)
    Flowable<FindBean> getAuthorMoreVideoData(@Query("id") String id, @Query("start") String start,
                                              @Query("num") String num, @Query("strategy") String strategy);

    //作者详情动态 http://baobab.kaiyanapp.com/api/v5/userInfo/tab/dynamics?id=2164&userType=PGC
    @GET("v5/userInfo/tab/dynamics" + END)
    Flowable<FindBean> getAuthorDynamicsData(@Query("id") String id,
                                             @Query("userType") String userType);

    //作者详情动态 http://baobab.kaiyanapp.com/api/v5/userInfo/tab/dynamics?start=10&num=10&id=2164&userType=PGC
    @GET("v5/userInfo/tab/dynamics" + END)
    Flowable<FindBean> getAuthorMoreDynamicsData(@Query("id") String id, @Query("start") String start,
                                                 @Query("num") String num, @Query("userType") String userType);


}