package com.komoriwu.one.model.http;

import com.komoriwu.one.model.bean.MovieDetailBean;
import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.model.bean.ReadDetailBean;
import com.komoriwu.one.model.http.reponse.MyHttpResponse;

import io.reactivex.Flowable;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public interface HttpHelper {
    Flowable<OneIdBean> fetchOneId();

    Flowable<MyHttpResponse<OneListBean>> getOneList(String id);

    Flowable<MyHttpResponse<ReadDetailBean>> getReadDetail(String itemId);
    Flowable<MyHttpResponse<MovieDetailBean>> getMovieDetail(String itemId);
}
