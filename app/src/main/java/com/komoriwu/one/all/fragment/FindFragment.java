package com.komoriwu.one.all.fragment;

import android.content.Intent;

import com.komoriwu.one.all.detail.CategoriesDetailActivity;
import com.komoriwu.one.all.fragment.mvp.FindPresenter;
import com.komoriwu.one.all.listener.OnItemCategoryClickListener;
import com.komoriwu.one.all.listener.OnItemVideoClickListener;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;

import java.util.HashMap;

/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public class FindFragment extends CommonBaseFragment<FindPresenter> implements
        OnItemVideoClickListener, OnItemCategoryClickListener {
    private String mStart;

    @Override
    protected void setInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void initListener() {
        super.initListener();
        commonAdapter.setOnItemCategoryClickListener(this);

    }

    @Override
    public void onLoadList() {
        presenter.loadList();
    }

    @Override
    public void onLoadMoreList() {
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put(Constants.START, mStart);
        presenter.loadMoreList(stringHashMap);
    }

    @Override
    public void refreshData(FindBean findBean) {
        super.refreshData(findBean);
        if (isLoadMore) {
            mStart = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[0];
        }
    }

    @Override
    public void showMoreDate(FindBean findBean) {
        super.showMoreDate(findBean);
        if (isLoadMore) {
            mStart = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[0];
        }
    }

    @Override
    public void onCategoryItemClick(ItemListBean itemListBeanX) {
        Intent intent = new Intent(getActivity(), CategoriesDetailActivity.class);
        intent.putExtra(Constants.ID, String.valueOf(itemListBeanX.getData().getId()));
        startActivity(intent);
    }


}
