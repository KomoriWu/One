package com.komoriwu.one.all.fragment;

import android.content.Intent;

import com.komoriwu.one.all.detail.VideoCardActivity;
import com.komoriwu.one.all.fragment.adapter.DailyAdapter;
import com.komoriwu.one.all.fragment.mvp.DailyPresenter;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.HashMap;

/**
 * Created by KomoriWu
 * on 2017-12-29.
 */

public class DailyFragment extends CommonBaseFragment<DailyPresenter> implements OnItemClickListener {
    private DailyAdapter mDailyAdapter;
    private String mDate;
    private String mNum;

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
                HashMap<String, String> stringHashMap = new HashMap<>();
                stringHashMap.put(Constants.DATE, mDate);
                stringHashMap.put(Constants.NUM, mNum);
                presenter.loadMoreList(stringHashMap);
            }
        });
    }

    public void initRecyclerView() {
        super.initRecyclerView();
        mDailyAdapter = new DailyAdapter(getActivity());
        recyclerView.setAdapter(mDailyAdapter);
    }

    @Override
    public void initListener() {
        super.initListener();
        mDailyAdapter.setOnItemClickListener(this);
    }

    @Override
    public void refreshData(FindBean findBean) {
        super.refreshData(findBean);
        mDailyAdapter.refreshList(findBean.getItemList());
        if (isLoadMore) {
            mDate = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[0];
            mNum = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[1].split(
                    "=")[1];
        }
    }

    @Override
    public void showMoreDate(FindBean findBean) {
        super.showMoreDate(findBean);
        mDailyAdapter.addItemListBeanXES(findBean.getItemList());
        if (isLoadMore) {
            mDate = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[0];
            mNum = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[1].split(
                    "=")[1];
        }
    }

    @Override
    public void onVideoCardItemClick(ItemListBean itemListBeanX) {
        Intent intent = new Intent(getActivity(), VideoCardActivity.class);
        intent.putExtra(Constants.ITEM_LIST_BEAN_X, itemListBeanX);
        startActivity(intent);
    }

    @Override
    public int currentItem() {
        return 2;
    }
}
