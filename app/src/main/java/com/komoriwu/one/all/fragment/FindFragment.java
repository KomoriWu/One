package com.komoriwu.one.all.fragment;

import android.os.Bundle;
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
import com.komoriwu.one.model.bean.FindBean;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017-12-13.
 */

public class FindFragment extends MvpBaseFragment<FindPresenter> implements FindContract.View {

    @BindView(R.id.rv_scroll)
    RecyclerView rvScroll;
    @BindView(R.id.rv_hot_sort)
    RecyclerView rvHotSort;
    private FindScrollAdapter mFindScrollAdapter;
    private FindHotSortAdapter mFindHotSortAdapter;

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
    }


    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void refreshData(FindBean findBean) {
        mFindScrollAdapter.setRvScrollData(findBean.getItemList().get(0).getData().getItemList());
        mFindHotSortAdapter.setHotSortData(findBean.getItemList());
    }

    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh() {

    }

}
