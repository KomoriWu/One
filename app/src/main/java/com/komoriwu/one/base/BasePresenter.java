package com.komoriwu.one.base;

/**
 * Created by KomoriWu
 * on 2017-08-15.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}