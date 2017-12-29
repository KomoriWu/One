package com.komoriwu.one.all.fragment;

import com.komoriwu.one.all.fragment.adapter.RecommendAdapter;
import com.komoriwu.one.all.fragment.mvp.RecommendPresenter;
import com.komoriwu.one.model.bean.FindBean;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public class RecommendFragment extends CommonBaseFragment<RecommendPresenter> {
    private RecommendAdapter mRecommendAdapter;
    private int mPage = 0;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void initRefreshLayout() {
        super.initRefreshLayout();
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                presenter.loadList();
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                presenter.loadMoreList(mPage);
            }
        });
    }

    public void initRecyclerView() {
        super.initRecyclerView();
        mRecommendAdapter = new RecommendAdapter(getActivity());
        recyclerView.setAdapter(mRecommendAdapter);
    }

    @Override
    public void refreshData(FindBean findBean) {
        super.refreshData(findBean);
        mRecommendAdapter.refreshList(findBean.getItemList());
        if (isLoadMore) {
            mPage = Integer.parseInt(findBean.getNextPageUrl().split("=")[1]);
        }
    }

    @Override
    public void showMoreDate(FindBean findBean) {
        super.showMoreDate(findBean);
        mRecommendAdapter.addItemListBeanXES(findBean.getItemList());
        if (isLoadMore) {
            mPage = Integer.parseInt(findBean.getNextPageUrl().split("=")[1]);
        }
    }

}
