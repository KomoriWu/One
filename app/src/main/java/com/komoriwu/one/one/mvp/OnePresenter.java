package com.komoriwu.one.one.mvp;

import android.util.Log;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.utils.RxUtil;

import org.reactivestreams.Publisher;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subscribers.ResourceSubscriber;

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
    public void getOneIdList() {
        addSubscribe(mDataManagerModel.fetchOneIdList()
                .compose(RxUtil.<OneIdBean>rxSchedulerHelper())
                .flatMap(new Function<OneIdBean, Publisher<String>>() {
                    @Override
                    public Publisher<String> apply(@NonNull OneIdBean oneIdBean) throws Exception {
                        List<String> strings = oneIdBean.getData();
                        return Flowable.fromIterable(strings);
                    }
                }).subscribeWith(new ResourceSubscriber<String>() {
                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, s);
                    }


                    @Override
                    public void onError(Throwable t) {
                        Log.d(TAG, t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
