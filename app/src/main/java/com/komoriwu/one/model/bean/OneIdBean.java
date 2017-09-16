package com.komoriwu.one.model.bean;

import java.util.List;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class OneIdBean {
    private int res;
    private List<String> data;

    public OneIdBean() {
    }

    public OneIdBean(int res, List<String> data) {
        this.res = res;
        this.data = data;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "OneIdBean{" +
                "res=" + res +
                ", data=" + data +
                '}';
    }
}
