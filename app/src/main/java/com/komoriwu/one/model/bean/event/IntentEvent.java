package com.komoriwu.one.model.bean.event;

import com.komoriwu.one.model.bean.ItemListBean;

/**
 * Created by KomoriWu
 * on 2018-01-03.
 */


public class IntentEvent {
    private int flag;
    private boolean isCommon;
    private ItemListBean itemListBean;

    public IntentEvent(int flag, ItemListBean itemListBean) {
        this.flag = flag;
        this.itemListBean = itemListBean;
        this.isCommon=true;
    }

    public IntentEvent(int flag, boolean isCommon, ItemListBean itemListBean) {
        this.flag = flag;
        this.isCommon = isCommon;
        this.itemListBean = itemListBean;
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
