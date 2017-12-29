package com.komoriwu.one.all.fragment;

import android.content.Intent;

import com.komoriwu.one.all.detail.VideoCardActivity;
import com.komoriwu.one.all.fragment.adapter.FindAdapter;
import com.komoriwu.one.all.fragment.mvp.FindPresenter;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public class FindFragment extends CommonBaseFragment<FindPresenter> implements OnItemClickListener {
    private FindAdapter mFindAdapter;

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
        });
    }

    public void initRecyclerView() {
        super.initRecyclerView();
        mFindAdapter = new FindAdapter(getActivity());
        recyclerView.setAdapter(mFindAdapter);
    }

    @Override
    public void initListener() {
        super.initListener();
        mFindAdapter.setOnItemClickListener(this);
    }

    @Override
    public void refreshData(FindBean findBean) {
        super.refreshData(findBean);
        mFindAdapter.refreshList(findBean.getItemList());

    }

    @Override
    public void showMoreDate(FindBean findBean) {
        super.showMoreDate(findBean);
    }

    @Override
    public void onVideoCardItemClick(ItemListBean itemListBeanX) {
        Intent intent=new Intent(getActivity(),VideoCardActivity.class);
        intent.putExtra(Constants.ITEM_LIST_BEAN_X,itemListBeanX);
        startActivity(intent);
    }
}
