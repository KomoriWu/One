package com.komoriwu.one.one.detail.mvp;

import android.util.Log;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.CommentBean;
import com.komoriwu.one.model.bean.ContentListBean;
import com.komoriwu.one.model.bean.MovieDetailBean;
import com.komoriwu.one.model.bean.MusicDetailBean;
import com.komoriwu.one.model.bean.ReadDetailBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.model.http.reponse.MyHttpResponse;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.RxUtil;

import org.reactivestreams.Publisher;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by KomoriWu
 * on 2017-11-10.
 */

public class ReadDetailPresenter extends RxPresenter<ReadDetailContract.View> implements
        ReadDetailContract.Presenter {
    public static final String TAG = ReadDetailPresenter.class.getSimpleName();
    private DataManagerModel mDataManagerModel;

    @Inject
    public ReadDetailPresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }

    @Override
    public void loadDetail(ContentListBean contentListBean) {
        String itemId = contentListBean.getItemId();
        switch (Integer.parseInt(contentListBean.getCategory())) {
            case Constants.CATEGORY_MUSIC:
                loadMusicDetail(itemId);
                break;
            case Constants.CATEGORY_MOVIE:
                loadMovieDetail(itemId);
                break;
            default:
                loadReadDetail(itemId);
                break;
        }
        loadReadComment(itemId);
    }

    @Override
    public void loadReadDetail(String itemId) {
        addSubscribe(mDataManagerModel.getReadDetail(itemId)
                .compose(RxUtil.<MyHttpResponse<ReadDetailBean>>rxSchedulerHelper())
                .flatMap(new Function<MyHttpResponse<ReadDetailBean>, Publisher<ReadDetailBean>>() {
                    @Override
                    public Publisher<ReadDetailBean> apply(@NonNull MyHttpResponse<ReadDetailBean>
                                                                   httpResponse) throws Exception {
                        return Flowable.just(httpResponse.getData());
                    }
                }).subscribeWith(new CommonSubscriber<ReadDetailBean>(view) {
                    @Override
                    public void onNext(ReadDetailBean readDetailBean) {
                        view.showReadData(readDetailBean);
                    }
                }));
    }


    @Override
    public void loadMovieDetail(String itemId) {
        addSubscribe(mDataManagerModel.getMovieDetail(itemId)
                .compose(RxUtil.<MyHttpResponse<MovieDetailBean>>rxSchedulerHelper())
                .flatMap(new Function<MyHttpResponse<MovieDetailBean>, Publisher<MovieDetailBean>>() {
                    @Override
                    public Publisher<MovieDetailBean> apply(@NonNull MyHttpResponse<MovieDetailBean>
                                                                    httpResponse) throws Exception {
                        return Flowable.just(httpResponse.getData());
                    }
                }).subscribeWith(new CommonSubscriber<MovieDetailBean>(view) {
                    @Override
                    public void onNext(MovieDetailBean movieDetailBean) {
                        view.showMovieData(movieDetailBean);
                    }
                }));
    }

    @Override
    public void loadMusicDetail(String itemId) {
        addSubscribe(mDataManagerModel.getMusicDetail(itemId)
                .compose(RxUtil.<MyHttpResponse<MusicDetailBean>>rxSchedulerHelper())
                .flatMap(new Function<MyHttpResponse<MusicDetailBean>, Publisher<MusicDetailBean>>() {
                    @Override
                    public Publisher<MusicDetailBean> apply(@NonNull MyHttpResponse<MusicDetailBean>
                                                                    httpResponse) throws Exception {
                        return Flowable.just(httpResponse.getData());
                    }
                }).subscribeWith(new CommonSubscriber<MusicDetailBean>(view) {
                    @Override
                    public void onNext(MusicDetailBean musicDetailBean) {
                        view.showMusicData(musicDetailBean);
                    }
                }));
    }

    @Override
    public void loadReadComment(String itemId) {
        addSubscribe(mDataManagerModel.geReadCommentDetail(itemId)
                .compose(RxUtil.<MyHttpResponse<CommentBean>>rxSchedulerHelper())
                .flatMap(new Function<MyHttpResponse<CommentBean>, Publisher<CommentBean>>() {
                    @Override
                    public Publisher<CommentBean> apply(@NonNull MyHttpResponse<CommentBean>
                                                                httpResponse) throws Exception {
                        return Flowable.just(httpResponse.getData());
                    }
                }).subscribeWith(new CommonSubscriber<CommentBean>(view) {
                    @Override
                    public void onNext(CommentBean commentBean) {
                        view.showReadCommend(commentBean);
                    }
                }));
    }
}
