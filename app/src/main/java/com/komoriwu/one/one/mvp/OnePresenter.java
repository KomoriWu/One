package com.komoriwu.one.one.mvp;

import android.util.Log;

import com.komoriwu.one.base.RxPresenter;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.bean.OneIdBean;
import com.komoriwu.one.utils.RxUtil;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
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
    public void getOneIdList() {
        addSubscribe(mDataManagerModel.fetchOneIdList()
                .compose(RxUtil.<OneIdBean>rxSchedulerHelper())
                .map(new Function<OneIdBean, OneIdBean>() {
                    @Override
                    public OneIdBean apply(@NonNull OneIdBean oneIdBean) throws Exception {
                        return oneIdBean;
                    }
                }).subscribe(new Consumer<OneIdBean>() {
                    @Override
                    public void accept(OneIdBean oneIdBean) throws Exception {
                        Log.d(TAG, oneIdBean.toString());
                    }
                }));
    }
}
