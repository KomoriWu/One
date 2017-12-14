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
import com.komoriwu.one.model.http.reponse.MyHttpResponse;

import io.reactivex.Flowable;
import retrofit2.http.Query;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public interface HttpHelper {
    Flowable<OneIdBean> fetchOneId();

    Flowable<MyHttpResponse<OneListBean>> getOneList(String id);

    Flowable<MyHttpResponse<ReadDetailBean>> getReadDetail(String itemId);

    Flowable<MyHttpResponse<CommentBean>> geReadCommentDetail(String itemId);

    Flowable<MyHttpResponse<MovieDetailBean>> getMovieDetail(String itemId);

    Flowable<MyHttpResponse<MusicDetailBean>> getMusicDetail(String itemId);

    Flowable<MyHttpResponse<MoviePhotoBean>> geMoviePhoto(String itemId);

    Flowable<MyHttpResponse<QuestionDetailBean>> geQuestionDetail(String itemId);

    Flowable<VideoBean> getAllVideo();

    Flowable<VideoBean> getAllVideo(String date, String num, String page);

    Flowable<FindBean> getFindData();
}
