package com.komoriwu.one.model.http;

import com.komoriwu.one.model.bean.CommentBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.MovieDetailBean;
import com.komoriwu.one.model.bean.MoviePhotoBean;
import com.komoriwu.one.model.bean.MusicDetailBean;
import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.model.bean.QuestionDetailBean;
import com.komoriwu.one.model.bean.ReadDetailBean;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.model.http.api.EyepetizerApis;
import com.komoriwu.one.model.http.api.OneApis;
import com.komoriwu.one.model.http.reponse.MyHttpResponse;

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

}
