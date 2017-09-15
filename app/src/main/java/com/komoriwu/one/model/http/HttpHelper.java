package com.komoriwu.one.model.http;

import com.komoriwu.one.model.bean.OneIdBean;

import io.reactivex.Flowable;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public interface HttpHelper {
    Flowable<OneIdBean> fetchOneIdList();
}
