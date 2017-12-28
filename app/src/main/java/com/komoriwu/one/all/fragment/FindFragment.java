package com.komoriwu.one.all.fragment;

import com.komoriwu.one.all.fragment.adapter.FindAdapter;
import com.komoriwu.one.all.fragment.mvp.FindPresenter;
import com.komoriwu.one.all.fragment.mvp.RecommendPresenter;
import com.komoriwu.one.model.bean.FindBean;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public class FindFragment extends CommonBaseFragment<FindPresenter> {
    private FindAdapter mFindAdapter;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void initRefreshLayout() {
        super.initRefreshLayout();
//        refreshLayout.setEnableLoadmore(false);
        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                presenter.loadFindList();
            }
        });
    }

    public void initRecyclerView() {
        super.initRecyclerView();
        mFindAdapter = new FindAdapter(getActivity());
        recyclerView.setAdapter(mFindAdapter);
    }

    @Override
    public void refreshData(FindBean findBean) {
        super.refreshData(findBean);
        mFindAdapter.setItemListBeanXES(findBean.getItemList());
    }

    @Override
    public void showMoreDate(FindBean findBean) {
        super.showMoreDate(findBean);
    }

}
