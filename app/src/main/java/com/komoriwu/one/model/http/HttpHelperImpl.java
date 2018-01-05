package com.komoriwu.one.model.http;

import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.komoriwu.one.model.bean.CommentBean;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.MovieDetailBean;
import com.komoriwu.one.model.bean.MoviePhotoBean;
import com.komoriwu.one.model.bean.MusicDetailBean;
import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.model.bean.QuestionDetailBean;
import com.komoriwu.one.model.bean.ReadDetailBean;
import com.komoriwu.one.model.bean.TagsDetailInfo;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.model.http.api.EyepetizerApis;
import com.komoriwu.one.model.http.api.OneApis;
import com.komoriwu.one.model.http.reponse.MyHttpResponse;
import com.komoriwu.one.utils.Constants;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class HttpHelperImpl implements HttpHelper {
    private OneApis mOneApis;
    private EyepetizerApis mEyepetizerApis;

    @Inject
    public HttpHelperImpl(OneApis mOneApis, EyepetizerApis mEyepetizerApis) {
        this.mOneApis = mOneApis;
        this.mEyepetizerApis = mEyepetizerApis;
    }


    @Override
    public Flowable<OneIdBean> fetchOneId() {
        return mOneApis.getOneId();
    }

    @Override
    public Flowable<MyHttpResponse<OneListBean>> getOneList(String id) {
        return mOneApis.getOneList(id);
    }

    @Override
    public Flowable<MyHttpResponse<ReadDetailBean>> getReadDetail(String itemId) {
        return mOneApis.getReadDetail(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<CommentBean>> geReadCommentDetail(String itemId) {
        return mOneApis.geReadCommentDetail(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<MovieDetailBean>> getMovieDetail(String itemId) {
        return mOneApis.geMovieDetail(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<MusicDetailBean>> getMusicDetail(String itemId) {
        return mOneApis.geMusicDetail(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<MoviePhotoBean>> geMoviePhoto(String itemId) {
        return mOneApis.geMoviePhoto(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<QuestionDetailBean>> geQuestionDetail(String itemId) {
        return mOneApis.geQuestionDetail(itemId);
    }

    @Override
    public Flowable<VideoBean> getAllVideo() {
        return mEyepetizerApis.getAllVideo();
    }

    @Override
    public Flowable<VideoBean> getAllVideo(String date, String num, String page) {
        return mEyepetizerApis.getAllVideo(date, num, page);
    }

    @Override
    public Flowable<FindBean> getFindData() {
        return mEyepetizerApis.getFindData();
    }

    @Override
    public Flowable<FindBean> getFindMoreData(String start) {
        return mEyepetizerApis.getFindMoreData(start, "10");
    }

    @Override
    public Flowable<FindBean> getRecommendData(String page) {
        return mEyepetizerApis.getRecommendData(page);
    }

    @Override
    public Flowable<FindBean> getDetailRecommendData(String id) {
        return mEyepetizerApis.getDetailRecommendData(id);
    }

    @Override
    public Flowable<FindBean> getDailyData() {
        return mEyepetizerApis.getDailyData();
    }

    @Override
    public Flowable<FindBean> getDailyMoreData(String date, String num) {
        return mEyepetizerApis.getDailyMoreData(date, num);
    }

    @Override
    public Flowable<FindBean> getCategoryData(int position) {
        switch (position) {
            case 3:
                return mEyepetizerApis.getCreativeData();
            case 4:
                return mEyepetizerApis.getMusicData();
            case 5:
                return mEyepetizerApis.getTravelData();
            case 6:
                return mEyepetizerApis.getScienceData();
            case 7:
                return mEyepetizerApis.getFunnyData();
            case 8:
                return mEyepetizerApis.getFashionData();
            case 9:
                return mEyepetizerApis.getSportsData();
            case 10:
                return mEyepetizerApis.getAnimData();
            case 11:
                return mEyepetizerApis.getAdvertData();
            case 12:
                return mEyepetizerApis.getAppetizerData();
            case 13:
                return mEyepetizerApis.getLifeData();
            case 14:
                return mEyepetizerApis.getPlotData();
            case 15:
                return mEyepetizerApis.getTrailerData();
            case 16:
                return mEyepetizerApis.getHighlightsData();
            case 17:
                return mEyepetizerApis.getRecordData();
            case 18:
                return mEyepetizerApis.getGameData();
            case 19:
                return mEyepetizerApis.getCuteData();
            case 20:
                return mEyepetizerApis.getArtsData();
        }
        return null;
    }

    @Override
    public Flowable<FindBean> getCategoryMoreData(int position, String start, String num) {
        switch (position) {
            case 3:
                return mEyepetizerApis.getCreativeMoreData(start, num);
            case 4:
                return mEyepetizerApis.getMusicMoreData(start, num);
            case 5:
                return mEyepetizerApis.getTravelMoreData(start, num);
            case 6:
                return mEyepetizerApis.getScienceMoreData(start, num);
            case 7:
                return mEyepetizerApis.getFunnyMoreData(start, num);
            case 8:
                return mEyepetizerApis.getFashionMoreData(start, num);
            case 9:
                return mEyepetizerApis.getSportsMoreData(start, num);
            case 10:
                return mEyepetizerApis.getAnimMoreData(start, num);
            case 11:
                return mEyepetizerApis.getAdvertMoreData(start, num);
            case 12:
                return mEyepetizerApis.getAppetizerMoreData(start, num);
            case 13:
                return mEyepetizerApis.getLifeMoreData(start, num);
            case 14:
                return mEyepetizerApis.getPlotMoreData(start, num);
            case 15:
                return mEyepetizerApis.getTravelMoreData(start, num);
            case 16:
                return mEyepetizerApis.getHighlightsMoreData(start, num);
            case 17:
                return mEyepetizerApis.getRecordMoreData(start, num);
            case 18:
                return mEyepetizerApis.getGameMoreData(start, num);
            case 19:
                return mEyepetizerApis.getCuteMoreData(start, num);
            case 20:
                return mEyepetizerApis.getArtsMoreData(start, num);
        }
        return null;
    }

    @Override
    public Flowable<FindBean> getAllCategoriesData() {
        return mEyepetizerApis.getAllCategoriesData();
    }

    @Override
    public Flowable<CategoryDetailBean> getCategoriesDetailIndexData(String id) {
        return mEyepetizerApis.getCategoriesDetailData(id);
    }


    @Override
    public Flowable<FindBean> getCDetailData(int position, String id) {
        switch (position) {
            case 0:
                return mEyepetizerApis.getCDetailHomeData(id);
            case 1:
                return mEyepetizerApis.getCDetailALLData(id);
            case 2:
                return mEyepetizerApis.getCDetailAuthorData(id);
            case 3:
                return mEyepetizerApis.getCDetailPlayListData(id);
        }
        return null;
    }

    @Override
    public Flowable<FindBean> getCDetailMoreData(int position, String id, HashMap<String, String>
            stringHashMap) {
        switch (position) {
            case 0:
                return mEyepetizerApis.getCDetailMoreHomeData(id, stringHashMap.get(Constants.
                        PAGE));
            case 1:
                return mEyepetizerApis.getCDetailMoreALLData(id, stringHashMap.get(Constants.
                        START), stringHashMap.get(Constants.NUM));
            case 2:
                return mEyepetizerApis.getCDetailMoreAuthorData(id, stringHashMap.get(Constants.
                        START), stringHashMap.get(Constants.NUM));
            case 3:
                return mEyepetizerApis.getCDetailMorePlayListData(id, stringHashMap.get(Constants.
                        START), stringHashMap.get(Constants.NUM));
        }
        return null;
    }

    @Override
    public Flowable<DataBean> getVideoDetailData(String id) {
        return mEyepetizerApis.getVideoDetailData(id);
    }

    @Override
    public Flowable<List<String>> getQueriesHotData() {
        return mEyepetizerApis.getQueriesHotData();
    }

    @Override
    public Flowable<FindBean> getQueryData(String query) {
        return mEyepetizerApis.getQueryData(query);
    }

    @Override
    public Flowable<FindBean> getMoreQueryData(String query, String start, String num) {
        return mEyepetizerApis.getMoreQueryData(query, start, num);
    }

    @Override
    public Flowable<TagsDetailInfo> getTagDetailIndexData(String id) {
        return mEyepetizerApis.getTagIndexData(id);
    }


    @Override
    public Flowable<FindBean> getTagDetailData(int position, String id) {
        switch (position) {
            case 0:
                return mEyepetizerApis.getTagVideoData(id);
            case 1:
                return mEyepetizerApis.getTagDynamicsData(id);
        }
        return null;
    }

    @Override
    public Flowable<FindBean> getTagDetailMoreData(int position, String id, HashMap<String, String>
            stringHashMap) {
        switch (position) {
            case 0:
                return mEyepetizerApis.getTagMoreVideoData(id, stringHashMap.get(Constants.START),
                        stringHashMap.get(Constants.NUM), "date");
            case 1:
                return mEyepetizerApis.getTagMoreDynamicsData(id, stringHashMap.get(Constants.START),
                        stringHashMap.get(Constants.NUM), "date");
        }
        return null;
    }
}
