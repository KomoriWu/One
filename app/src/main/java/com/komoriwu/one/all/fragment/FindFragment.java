package com.komoriwu.one.all.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.adapter.FindAdapter;
import com.komoriwu.one.all.fragment.mvp.FindContract;
import com.komoriwu.one.all.fragment.mvp.FindPresenter;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.widget.BallPulseView;
import com.komoriwu.one.widget.listener.HidingScrollBottomListener;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class FindFragment extends MvpBaseFragment<FindPresenter> implements FindContract.View {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    TwinklingRefreshLayout refreshLayout;
    private View mParentView;
    private boolean mIsInit = true;
    private FindAdapter mFindAdapter;


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mParentView == null) {
            mParentView = inflater.inflate(R.layout.fragment_find, container, false);
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

    private void initRefreshLayout() {
        ProgressLayout headerView = new ProgressLayout(getActivity());
        refreshLayout.setHeaderView(headerView);
        refreshLayout.setOverScrollRefreshShow(false);
        refreshLayout.setEnableLoadmore(false);
        BallPulseView loadingView = new BallPulseView(getActivity());
        refreshLayout.setBottomView(loadingView);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                presenter.loadFindList();
            }

//            @Override
//            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
//                super.onLoadMore(refreshLayout);
////                presenter.loadFindMoreList(mStartIndex);
//            }
        });
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFindAdapter = new FindAdapter(getActivity());
        recyclerView.setAdapter(mFindAdapter);
    }
    private void initListener() {
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
        mFindAdapter.setItemListBeanXES(findBean.getItemList());
    }

    @Override
    public void showMoreDate(FindBean findBean) {

    }

    @Override
    public void showUI() {

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
