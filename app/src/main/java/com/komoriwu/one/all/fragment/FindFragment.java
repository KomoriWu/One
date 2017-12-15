package com.komoriwu.one.all.fragment;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.adapter.FindHotSortAdapter;
import com.komoriwu.one.all.fragment.adapter.FindRecentProjectAdapter;
import com.komoriwu.one.all.fragment.adapter.FindRecentTopicAdapter;
import com.komoriwu.one.all.fragment.adapter.FindScrollAdapter;
import com.komoriwu.one.all.fragment.adapter.SmallCardAdapter;
import com.komoriwu.one.all.fragment.mvp.FindContract;
import com.komoriwu.one.all.fragment.mvp.FindPresenter;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.DCTextView;
import com.komoriwu.one.widget.FZTextView;

import java.util.List;

import butterknife.BindView;
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
    @BindView(R.id.rv_small_card)
    RecyclerView rvSmallCard;
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
    private FindScrollAdapter mFindScrollAdapter;
    private FindHotSortAdapter mFindHotSortAdapter;
    private FindRecentProjectAdapter mFindRecentProjectAdapter;
    private FindRecentTopicAdapter mFindRecentTopicAdapter;
    private SmallCardAdapter mSmallCardAdapter;
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
        nsvScroller.setVisibility(View.INVISIBLE);
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

        rvSmallCard.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSmallCardAdapter = new SmallCardAdapter(getActivity());
        rvSmallCard.setAdapter(mSmallCardAdapter);
        rvSmallCard.setNestedScrollingEnabled(false);
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
        List<FindBean.ItemListBeanX> itemListBeanXES=findBean.getItemList();
        mFindScrollAdapter.setRvData(itemListBeanXES.get(0).getData().getItemList());
        mFindHotSortAdapter.setHotSortData(itemListBeanXES);
        mFindRecentProjectAdapter.setRvData(itemListBeanXES.get(6).getData().getItemList());
        mFindRecentTopicAdapter.setRvData(itemListBeanXES.get(7).getData().getItemList());

        tvForward.setText(itemListBeanXES.get(8).getData().getText());
        Utils.displayImage(getActivity(), itemListBeanXES.get(9).getData().getContent().getData().
                getCover().getFeed(), ivCardCover);
        tvTime.setText(Utils.durationFormat( itemListBeanXES.get(9).getData().getContent().getData().
                getDuration()));
        Utils.displayImage(getActivity(), itemListBeanXES.get(9).getData().getHeader().getIcon(),
                ivCover,  Utils.getImageOptions(R.mipmap.ic_launcher_round, 360));
        tvTitle.setText(itemListBeanXES.get(9).getData().getHeader().getTitle());
        tvDescription.setText(itemListBeanXES.get(9).getData().getHeader().getDescription());

        mSmallCardAdapter.setSmallCardData(itemListBeanXES);
    }

    @Override
    public void showUI() {
        nsvScroller.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh() {

    }

}
