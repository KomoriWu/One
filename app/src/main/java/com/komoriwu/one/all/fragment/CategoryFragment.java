package com.komoriwu.one.all.fragment;

import com.komoriwu.one.all.fragment.mvp.CategoryPresenter;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

import java.util.HashMap;

/**
 * Created by KomoriWu
 * on 2017-12-29.
 */

public class CategoryFragment extends CommonBaseFragment<CategoryPresenter> implements
        OnItemClickListener {
    private String mStart;
    private String mNum;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void init() {
        presenter.setPosition(FragmentPagerItem.getPosition(getArguments()));
        super.init();
    }

    @Override
    public void refreshData(FindBean findBean) {
        super.refreshData(findBean);
        if (isLoadMore) {
            mStart = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[0];
            mNum = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[1].split(
                    "=")[1];
        }
    }

    @Override
    public void showMoreDate(FindBean findBean) {
        super.showMoreDate(findBean);
        if (isLoadMore) {
            mStart = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[0];
            mNum = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[1].split(
                    "=")[1];
        }
    }


    @Override
    public void onLoadList() {
        presenter.loadList();
    }

    @Override
    public void onLoadMoreList() {
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put(Constants.START, mStart);
        stringHashMap.put(Constants.NUM, mNum);
        presenter.loadMoreList(stringHashMap);
    }
}
