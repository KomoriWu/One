package com.komoriwu.one.model;

import com.komoriwu.one.model.bean.AuthorDetailBean;
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
import com.komoriwu.one.model.bean.TagsDetailBean;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.model.db.DBHelper;
import com.komoriwu.one.model.http.HttpHelper;
import com.komoriwu.one.model.http.reponse.MyHttpResponse;
import com.komoriwu.one.model.prefs.PreferencesHelper;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class DataManagerModel implements HttpHelper, DBHelper, PreferencesHelper {
    private HttpHelper mHttpHelper;
    private DBHelper mDBDbHelper;
    private PreferencesHelper mPreferencesHelper;

    public DataManagerModel(HttpHelper mHttpHelper, DBHelper mDBDbHelper, PreferencesHelper
            mPreferencesHelper) {
        this.mHttpHelper = mHttpHelper;
        this.mDBDbHelper = mDBDbHelper;
        this.mPreferencesHelper = mPreferencesHelper;
    }

    @Override
    public Flowable<OneIdBean> fetchOneId() {
        return mHttpHelper.fetchOneId();
    }

    @Override
    public Flowable<MyHttpResponse<OneListBean>> getOneList(String id) {
        return mHttpHelper.getOneList(id);
    }

    @Override
    public Flowable<MyHttpResponse<ReadDetailBean>> getReadDetail(String itemId) {
        return mHttpHelper.getReadDetail(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<CommentBean>> geReadCommentDetail(String itemId) {
        return mHttpHelper.geReadCommentDetail(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<MovieDetailBean>> getMovieDetail(String itemId) {
        return mHttpHelper.getMovieDetail(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<MusicDetailBean>> getMusicDetail(String itemId) {
        return mHttpHelper.getMusicDetail(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<MoviePhotoBean>> geMoviePhoto(String itemId) {
        return mHttpHelper.geMoviePhoto(itemId);
    }

    @Override
    public Flowable<MyHttpResponse<QuestionDetailBean>> geQuestionDetail(String itemId) {
        return mHttpHelper.geQuestionDetail(itemId);
    }

    @Override
    public Flowable<VideoBean> getAllVideo() {
        return mHttpHelper.getAllVideo();
    }

    @Override
    public Flowable<VideoBean> getAllVideo(String date, String num, String page) {
        return mHttpHelper.getAllVideo(date, num, page);
    }

    @Override
    public Flowable<FindBean> getFindData() {
        return mHttpHelper.getFindData();
    }

    @Override
    public Flowable<FindBean> getFindMoreData(String start) {
        return mHttpHelper.getFindMoreData(start);
    }

    @Override
    public Flowable<FindBean> getRecommendData(String page) {
        return mHttpHelper.getRecommendData(page);
    }

    @Override
    public Flowable<FindBean> getDetailRecommendData(String id) {
        return mHttpHelper.getDetailRecommendData(id);
    }

    @Override
    public Flowable<FindBean> getDailyData() {
        return mHttpHelper.getDailyData();
    }

    @Override
    public Flowable<FindBean> getDailyMoreData(String date, String num) {
        return mHttpHelper.getDailyMoreData(date, num);
    }

    @Override
    public Flowable<FindBean> getCategoryData(int position) {
        return mHttpHelper.getCategoryData(position);
    }

    @Override
    public Flowable<FindBean> getCategoryMoreData(int position, String start, String num) {
        return mHttpHelper.getCategoryMoreData(position, start, num);
    }

    @Override
    public Flowable<FindBean> getAllCategoriesData() {
        return mHttpHelper.getAllCategoriesData();
    }

    @Override
    public Flowable<CategoryDetailBean> getCategoriesDetailIndexData(String id) {
        return mHttpHelper.getCategoriesDetailIndexData(id);
    }

    @Override
    public Flowable<FindBean> getCDetailData(int position, String id) {
        return mHttpHelper.getCDetailData(position, id);
    }


    @Override
    public Flowable<FindBean> getCDetailMoreData(int position, String id, HashMap<String, String>
            stringHashMap) {
        return mHttpHelper.getCDetailMoreData(position, id, stringHashMap);
    }

    @Override
    public Flowable<DataBean> getVideoDetailData(String id) {
        return mHttpHelper.getVideoDetailData(id);
    }

    @Override
    public Flowable<List<String>> getQueriesHotData() {
        return mHttpHelper.getQueriesHotData();
    }

    @Override
    public Flowable<FindBean> getQueryData(String query) {
        return mHttpHelper.getQueryData(query);
    }

    @Override
    public Flowable<TagsDetailBean> getTagDetailIndexData(String id) {
        return mHttpHelper.getTagDetailIndexData(id);
    }

    @Override
    public Flowable<FindBean> getTagDetailData(int position, String id) {
        return mHttpHelper.getTagDetailData(position, id);
    }

    @Override
    public Flowable<FindBean> getTagDetailMoreData(int position, String id, HashMap<String, String>
            stringHashMap) {
        return mHttpHelper.getTagDetailMoreData(position, id, stringHashMap);
    }

    @Override
    public Flowable<AuthorDetailBean> getAuthorDetailData(String id) {
        return mHttpHelper.getAuthorDetailData(id);
    }

    @Override
    public Flowable<FindBean> getMoreQueryData(String query, String start, String num) {
        return mHttpHelper.getMoreQueryData(query, start, num);
    }

    @Override
    public String getCategoriesId() {
        return mPreferencesHelper.getCategoriesId();
    }

    @Override
    public void setCategoriesId(String id) {
        mPreferencesHelper.setCategoriesId(id);
    }

    @Override
    public String getTagsId() {
        return mPreferencesHelper.getTagsId();
    }

    @Override
    public void setTagsId(String id) {
        mPreferencesHelper.setTagsId(id);
    }

    @Override
    public String getAuthorId() {
        return mPreferencesHelper.getAuthorId();
    }

    @Override
    public void setAuthorId(String id) {
        mPreferencesHelper.setTagsId(id);
    }


}
