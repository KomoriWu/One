package com.komoriwu.one.all.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.VideoCardActivity;
import com.komoriwu.one.all.fragment.adapter.FindHotSortAdapter;
import com.komoriwu.one.all.fragment.adapter.FindRecentProjectAdapter;
import com.komoriwu.one.all.fragment.adapter.FindRecentTopicAdapter;
import com.komoriwu.one.all.fragment.adapter.FindScrollAdapter;
import com.komoriwu.one.all.fragment.adapter.FollowCardAdapter;
import com.komoriwu.one.all.fragment.adapter.SmallCardAdapter;
import com.komoriwu.one.all.fragment.mvp.FindContract;
import com.komoriwu.one.all.fragment.mvp.FindPresenter;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.application.GlideApp;
import com.komoriwu.one.application.MyApplication;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.event.ScrollYEvent;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.BallPulseView;
import com.komoriwu.one.widget.DCTextView;
import com.komoriwu.one.widget.FZTextView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by KomoriWu
 * on 2017-12-13.
 */

public class FindFragment extends MvpBaseFragment<FindPresenter> implements FindContract.View, OnItemClickListener {
    private static final String TAG = FindFragment.class.getSimpleName();
    @BindView(R.id.refresh_layout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.rv_scroll)
    RecyclerView rvScroll;
    @BindView(R.id.rv_hot_sort)
    RecyclerView rvHotSort;
    @BindView(R.id.rv_recent_project)
    RecyclerView rvRecentProject;
    @BindView(R.id.rv_recent_topic)
    RecyclerView rvRecentTopic;
    @BindView(R.id.rv_small_card)
    RecyclerView rvSmallCard;
    @BindView(R.id.rv_follow_card)
    RecyclerView rvFollowCard;
    @BindView(R.id.nsv_scroller)
    NestedScrollView nsvScroller;
    @BindView(R.id.tv_hot_sort)
    FZTextView tvHotSort;
    @BindView(R.id.tv_all_categories)
    FZTextView tvAllCategories;
    @BindView(R.id.tv_recent_project)
    FZTextView tvRecentProject;
    @BindView(R.id.tv_recent_topic)
    FZTextView tvRecentTopic;
    @BindView(R.id.tv_forward)
    FZTextView tvForward;
    @BindView(R.id.iv_card_cover)
    ImageView ivCardCover;
    @BindView(R.id.tv_time)
    DCTextView tvTime;
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    @BindView(R.id.tv_title)
    FZTextView tvTitle;
    @BindView(R.id.tv_description)
    FZTextView tvDescription;
    @BindView(R.id.tv_all_small_card)
    FZTextView tvAllSmallCard;
    @BindView(R.id.tv_follow_category)
    FZTextView tvFollowCategory;
    private FindScrollAdapter mFindScrollAdapter;
    private FindHotSortAdapter mFindHotSortAdapter;
    private FindRecentProjectAdapter mFindRecentProjectAdapter;
    private FindRecentTopicAdapter mFindRecentTopicAdapter;
    private SmallCardAdapter mSmallCardAdapter;
    private FollowCardAdapter mFollowCardAdapter;
    private boolean mIsBottomShow = true;
    private int mStartIndex = 10;
    private boolean mIsInit = true;
    private View mParentView;
    private List<FindBean.ItemListBeanX> mItemListBeanXES;

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
            nsvScroller.setVisibility(View.INVISIBLE);

            initRefreshLayout();
            initRecyclerView();
            initListener();
        }
    }


    private void initRefreshLayout() {
        ProgressLayout headerView = new ProgressLayout(getActivity());
        refreshLayout.setHeaderView(headerView);
        refreshLayout.setOverScrollRefreshShow(false);
        BallPulseView loadingView = new BallPulseView(getActivity());
        refreshLayout.setBottomView(loadingView);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                presenter.loadFindList();
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                presenter.loadFindMoreList(mStartIndex);
            }
        });
    }

    private void initRecyclerView() {
        rvScroll.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.
                HORIZONTAL, false));
        RecyclerView.ItemDecoration decoration = ItemDecorations.horizontal(getActivity())
                .type(Constants.ALL_VIEW_TAPE, R.drawable.shape_decoration_flush_orange_h_8)
                .last(R.drawable.shape_decoration_flush_orange_w_8)
                .create();
        mFindScrollAdapter = new FindScrollAdapter(getActivity());
        rvScroll.setAdapter(mFindScrollAdapter);
        rvScroll.addItemDecoration(decoration);

        rvHotSort.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFindHotSortAdapter = new FindHotSortAdapter(getActivity());
        rvHotSort.setAdapter(mFindHotSortAdapter);
        rvHotSort.setNestedScrollingEnabled(false);

        rvRecentProject.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.
                HORIZONTAL, false));
        mFindRecentProjectAdapter = new FindRecentProjectAdapter(getActivity());
        rvRecentProject.setAdapter(mFindRecentProjectAdapter);
        rvRecentProject.addItemDecoration(decoration);

        rvRecentTopic.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.
                HORIZONTAL, false));
        mFindRecentTopicAdapter = new FindRecentTopicAdapter(getActivity());
        rvRecentTopic.setAdapter(mFindRecentTopicAdapter);
        rvRecentTopic.addItemDecoration(decoration);

        rvSmallCard.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSmallCardAdapter = new SmallCardAdapter(getActivity(), this);
        rvSmallCard.setAdapter(mSmallCardAdapter);
        rvSmallCard.setNestedScrollingEnabled(false);

        rvFollowCard.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFollowCardAdapter = new FollowCardAdapter(getActivity(), this);
        rvFollowCard.setAdapter(mFollowCardAdapter);
        rvFollowCard.setNestedScrollingEnabled(false);
    }

    private void initListener() {
        nsvScroller.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX,
                                       int oldScrollY) {
                if (scrollY - oldScrollY > 20 && mIsBottomShow) {  //隐藏
                    mIsBottomShow = false;
                    ((MainActivity) getActivity()).changeRadioGState(false);

                } else if (scrollY - oldScrollY < -20 && !mIsBottomShow) {    //出现
                    mIsBottomShow = true;
                    ((MainActivity) getActivity()).changeRadioGState(true);
                }

            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();

            }
        });
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void refreshData(FindBean findBean) {
        mItemListBeanXES = findBean.getItemList();
        mFindScrollAdapter.setRvData(mItemListBeanXES.get(0).getData().getItemList());
        mFindHotSortAdapter.setHotSortData(mItemListBeanXES);
        mFindRecentProjectAdapter.setRvData(mItemListBeanXES.get(6).getData().getItemList());
        mFindRecentTopicAdapter.setRvData(mItemListBeanXES.get(7).getData().getItemList());

        tvForward.setText(mItemListBeanXES.get(8).getData().getText());
        Utils.displayImage(getActivity(), mItemListBeanXES.get(9).getData().getContent().getData().
                getCover().getFeed(), ivCardCover);
        tvTime.setText(Utils.durationFormat(mItemListBeanXES.get(9).getData().getContent().getData().
                getDuration()));
        Utils.displayImage(getActivity(), mItemListBeanXES.get(9).getData().getHeader().getIcon(),
                ivCover, true);
        tvTitle.setText(mItemListBeanXES.get(9).getData().getHeader().getTitle());
        tvDescription.setText(mItemListBeanXES.get(9).getData().getHeader().getDescription());

        mSmallCardAdapter.setSmallCardData(mItemListBeanXES);
        tvAllSmallCard.setText(mItemListBeanXES.get(12).getData().getText());

        tvFollowCategory.setText(mItemListBeanXES.get(13).getData().getText());
        mFollowCardAdapter.setSmallCardData(mItemListBeanXES);
    }

    @Override
    public void showMoreDate(FindBean findBean) {
        mFollowCardAdapter.addSmallCardData(findBean.getItemList());
        mStartIndex += 10;
        MyApplication.getRefWatcher().watch(this);
    }

    @Override
    public void showUI() {
        nsvScroller.setVisibility(View.VISIBLE);
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

    @Subscribe
    public void onEventMainThread(ScrollYEvent scrollYEvent) {
        nsvScroller.setScrollY(0);
        refreshLayout.startRefresh();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != mParentView) {
            ((ViewGroup) mParentView.getParent()).removeView(mParentView);
            mIsInit = false;
        }
    }


    @Override
    public void onVideoCardItemClick(FindBean.ItemListBeanX itemListBeanX) {
        Intent intent = new Intent(getActivity(), VideoCardActivity.class);
        intent.putExtra(Constants.ITEM_LIST_BEAN_X, itemListBeanX);
        startActivity(intent);
    }


    @OnClick(R.id.iv_card_cover)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_card_cover:
                onVideoCardItemClick(mItemListBeanXES.get(9));
                break;
        }
    }
}
