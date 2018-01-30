package com.komoriwu.one.model.bean.event;

import android.app.Activity;

import com.komoriwu.one.model.bean.ItemListBean;

/**
 * Created by KomoriWu
 * on 2018-01-03.
 */


public class IntentEvent {
    private int flag;
    private boolean isCommon;
    private ItemListBean itemListBean;
    private Activity activity;

    public IntentEvent(Activity activity,int flag, ItemListBean itemListBean) {
        this.flag = flag;
        this.itemListBean = itemListBean;
        this.activity=activity;
        this.isCommon=true;
    }

    public IntentEvent(Activity activity,int flag, boolean isCommon, ItemListBean itemListBean) {
        this.flag = flag;
        this.isCommon = isCommon;
        this.activity=activity;
        this.itemListBean = itemListBean;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public boolean isCommon() {
        return isCommon;
    }

    public void setCommon(boolean common) {
        isCommon = common;
    }

    public ItemListBean getItemListBean() {
        return itemListBean;
    }

    public void setItemListBean(ItemListBean itemListBean) {
        this.itemListBean = itemListBean;
    }


    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
