package com.komoriwu.one.widget.listener;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.komoriwu.one.application.MyApplication;

import io.reactivex.Flowable;

public abstract class HidingScrollBottomListener extends RecyclerView.OnScrollListener {
    private static final String TAG = HidingScrollBottomListener.class.getSimpleName();
    private Context mContext;
    private static final int HIDE_THRESHOLD = 20;//滑动隐藏的阈值
    private static final int DATE_THRESHOLD = 1000;//滑动检查date的阈值
    private int mScrolledDistance = 0;//滑动距离差
    private int mScrolledDistanceCount = 0;//滑动总距离
    private boolean mControlsVisible = true;//控件的显示状态

    public HidingScrollBottomListener(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 向下滑动隐藏控件, 向上滑动显示控件
     * dy, 向下滑动为正值, 向上滑动为负值
     */
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        mScrolledDistanceCount += Math.abs(dy);
        if (mScrolledDistanceCount > DATE_THRESHOLD) {
            onUpdateDate();
            mScrolledDistanceCount = 0;
        }


        int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).
                findFirstVisibleItemPosition();

        if (firstVisibleItem == 0) {//如果已经滑动到最顶端
            if (!mControlsVisible) {
                onShow();
                mControlsVisible = true;
            }
        } else {//当前Item不是第一条
            if (mScrolledDistance > HIDE_THRESHOLD && mControlsVisible) {//向下滑动
                onHide();
                mControlsVisible = false;
                mScrolledDistance = 0;
            } else if (mScrolledDistance < -HIDE_THRESHOLD && !mControlsVisible) {//向上滑动
                onShow();
                mControlsVisible = true;
                mScrolledDistance = 0;
            }
        }
        if ((mControlsVisible && dy > 0) || (!mControlsVisible && dy < 0)) {
            mScrolledDistance += dy;
        }
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            Glide.with(mContext).resumeRequests();
        } else {
            Glide.with(mContext).pauseRequests();
        }
    }

    public abstract void onHide();//在onHide()方法里面实现控件隐藏功能

    public abstract void onShow();//在onShow()方法里面实现控件显示功能

    public abstract void onUpdateDate();

}