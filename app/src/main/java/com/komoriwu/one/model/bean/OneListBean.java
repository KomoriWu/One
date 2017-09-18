package com.komoriwu.one.model.bean;

/**
 * Created by KomoriWu
 * on 2017/9/16.
 */

public class OneListBean {
    private String id;
    private String date;

    public OneListBean(String id, String date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OneListBean{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
