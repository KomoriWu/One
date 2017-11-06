package com.komoriwu.one.one.mvp;

import android.util.Log;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.model.http.CommonSubscriber;
import com.komoriwu.one.model.http.reponse.MyHttpResponse;
import com.komoriwu.one.utils.RxUtil;

import org.reactivestreams.Publisher;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class OnePresenter extends RxPresenter<OneContract.View> implements OneContract.Presenter {
    public static final String TAG = OnePresenter.class.getSimpleName();
    private DataManagerModel mDataManagerModel;

    @Inject
    public OnePresenter(DataManagerModel mDataManagerModel) {
        this.mDataManagerModel = mDataManagerModel;
    }


    @Override
    public void getOneList(final OneContract.LoadOneListData loadOneListData) {
        addSubscribe(mDataManagerModel.fetchOneId()
                .compose(RxUtil.<OneIdBean>rxSchedulerHelper())
                .flatMap(new Function<OneIdBean, Publisher<String>>() {
                    @Override
                    public Publisher<String> apply(@NonNull OneIdBean oneIdBean) throws Exception {
                        List<String> strings = oneIdBean.getData();
                        return Flowable.just(strings.get(0));
                    }
                }).subscribeWith(new CommonSubscriber<String>(view) {
                    @Override
                    public void onNext(String id) {
                        getOneListById(id,loadOneListData);
                    }
                }));
    }

    private void getOneListById(final String id, final OneContract.LoadOneListData loadOneListData) {
        addSubscribe(mDataManagerModel.getOneList(id)
                .compose(RxUtil.<MyHttpResponse<OneListBean>>rxSchedulerHelper())
                .flatMap(new Function<MyHttpResponse<OneListBean>, Publisher<OneListBean>>() {
                    @Override
                    public Publisher<OneListBean> apply(@NonNull MyHttpResponse<OneListBean> listBean)
                            throws Exception {
                        return Flowable.just(listBean.getData());
                    }
                }).subscribeWith(new CommonSubscriber<OneListBean>(view) {
                    @Override
                    public void onNext(OneListBean oneListBean) {
                        loadOneListData.onSuccess(oneListBean);
                    }
                }));
    }
}
