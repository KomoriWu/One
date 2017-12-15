package com.komoriwu.one.model.bean.event;

/**
 * Created by KomoriWu
 * on 2017-12-15.
 */

public class ScrollYEvent {
    private int flag;

    public ScrollYEvent(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
