package com.komoriwu.one.all.fragment;

import android.content.Intent;

import com.komoriwu.one.all.detail.VideoCardActivity;
import com.komoriwu.one.all.fragment.mvp.RecommendPresenter;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.HashMap;

/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public class RecommendFragment extends CommonBaseFragment<RecommendPresenter> implements
        OnItemClickListener {
    private String mPage;

    @Override
    protected void setInject() {
        getFragmentComponent().inject(this);
    }


    @Override
    public void onLoadList() {
        presenter.loadList();
    }

    @Override
    public void onLoadMoreList() {
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put(Constants.PAGE, mPage);
        presenter.loadMoreList(stringHashMap);
    }
    @Override
    public void refreshData(FindBean findBean) {
        super.refreshData(findBean);
        if (isLoadMore) {
            mPage = findBean.getNextPageUrl().split("=")[1];
        }
    }

    @Override
    public void showMoreDate(FindBean findBean) {
        super.showMoreDate(findBean);
        if (isLoadMore) {
            mPage = findBean.getNextPageUrl().split("=")[1];
        }
    }


}
