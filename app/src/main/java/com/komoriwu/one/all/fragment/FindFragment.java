package com.komoriwu.one.all.fragment;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.mvp.FindContract;
import com.komoriwu.one.all.fragment.mvp.FindPresenter;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.widget.FZTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by KomoriWu
 * on 2017-12-13.
 */

public class FindFragment extends MvpBaseFragment<FindPresenter> implements FindContract.View {

    @BindView(R.id.rv_scroll)
    RecyclerView rvScroll;
    @BindView(R.id.rv_hot_sort)
    RecyclerView rvHotSort;
    @BindView(R.id.rv_recent_project)
    RecyclerView rvRecentProject;
    @BindView(R.id.rv_recent_topic)
    RecyclerView rvRecentTopic;
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
    private FindScrollAdapter mFindScrollAdapter;
    private FindHotSortAdapter mFindHotSortAdapter;
    private FindRecentProjectAdapter mFindRecentProjectAdapter;
    private FindRecentTopicAdapter mFindRecentTopicAdapter;
    private boolean mIsBottomShow = true;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find, null);
    }

    @Override
    public void init() {
        presenter.loadFindList();
        initRecyclerView();
        initListener();
    }

    private void initRecyclerView() {
        rvScroll.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.
                HORIZONTAL, false));
        RecyclerView.ItemDecoration decoration = ItemDecorations.horizontal(getActivity())
                .first(R.drawable.shape_decoration_flush_orange_h_16)
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
        });
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void refreshData(FindBean findBean) {
        mFindScrollAdapter.setRvData(findBean.getItemList().get(0).getData().getItemList());
        mFindHotSortAdapter.setHotSortData(findBean.getItemList());
        mFindRecentProjectAdapter.setRvData(findBean.getItemList().get(6).getData().getItemList());
        mFindRecentTopicAdapter.setRvData(findBean.getItemList().get(7).getData().getItemList());
    }

    @Override
    public void showUI() {
        tvHotSort.setVisibility(View.VISIBLE);
        tvAllCategories.setVisibility(View.VISIBLE);
        tvRecentProject.setVisibility(View.VISIBLE);
        tvRecentTopic.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh() {

    }

}
