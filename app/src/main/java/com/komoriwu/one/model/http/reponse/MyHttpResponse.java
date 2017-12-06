package com.komoriwu.one.model.http.reponse;

import com.komoriwu.one.model.bean.VideoBean;

import java.util.List;

/**
 * Created by KomoriWu
 * on 2017/9/16.
 */

public class MyHttpResponse<T> {
    private int res;
    private T data;

    public MyHttpResponse(int res, T data) {
        this.res = res;
        this.data = data;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
