package com.komoriwu.one.all.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.mvp.CommonContract;
import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.widget.BallPulseView;
import com.komoriwu.one.widget.listener.HidingScrollBottomListener;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public abstract class CommonBaseFragment<T extends BasePresenter> extends MvpBaseFragment<T>
        implements CommonContract.View {
    public RecyclerView recyclerView;
    public TwinklingRefreshLayout refreshLayout;
    private View mParentView;
    private boolean mIsInit = true;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mParentView == null) {
            mParentView = inflater.inflate(R.layout.fragment_find, container, false);
            recyclerView = mParentView.findViewById(R.id.recycler_view);
            refreshLayout = mParentView.findViewById(R.id.refresh_layout);
        }
        return mParentView;
    }

    @Override
    public void init() {
        if (mIsInit) {
            refreshLayout.startRefresh();
            initRefreshLayout();
            initRecyclerView();
            initListener();
        }
    }

    public void initRefreshLayout() {
        ProgressLayout headerView = new ProgressLayout(getActivity());
        refreshLayout.setHeaderView(headerView);
        refreshLayout.setOverScrollRefreshShow(false);
        refreshLayout.setEnableLoadmore(false);
        BallPulseView loadingView = new BallPulseView(getActivity());
        refreshLayout.setBottomView(loadingView);
    }

    public void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void initListener() {
        recyclerView.addOnScrollListener(new HidingScrollBottomListener(getActivity()) {
            @Override
            public void onHide() {
                ((MainActivity) getActivity()).changeRadioBtnState(false);
            }

            @Override
            public void onShow() {
                ((MainActivity) getActivity()).changeRadioBtnState(true);
            }

            @Override
            public void onUpdateDate() {

            }

        });
    }

    @Override
    public void refreshData(FindBean findBean) {

    }

    @Override
    public void showMoreDate(FindBean findBean) {

    }


    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh(boolean isRefresh) {
        if (isRefresh) {
            refreshLayout.finishRefreshing();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshLayout.finishLoadmore();
                }
            }, 1500);
        }
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != mParentView) {
            ((ViewGroup) mParentView.getParent()).removeView(mParentView);
            mIsInit = false;
        }
    }

}
