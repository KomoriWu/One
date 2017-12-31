package com.komoriwu.one.all.detail.fragment;

import com.komoriwu.one.all.detail.fragment.mvp.HomeContract;
import com.komoriwu.one.all.detail.fragment.mvp.HomePresenter;
import com.komoriwu.one.all.fragment.CommonBaseFragment;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;

import java.util.HashMap;

/**
 * Created by KomoriWu
 * on 2017-12-31.
 */

public class HomeFragment extends CommonBaseFragment<HomePresenter> implements OnItemClickListener,
        HomeContract.View {
    private String mDate;
    private String mNum;

    @Override
    protected void setInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void initListener() {
        commonAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onLoadList() {
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put(Constants.ID, "24");
        presenter.loadList(stringHashMap);
    }

    @Override
    public void onLoadMoreList() {
//        presenter.loadMoreList(stringHashMap);
    }

    @Override
    public void refreshData(FindBean findBean) {
        super.refreshData(findBean);
        refreshLayout.setEnableRefresh(false);
//        if (isLoadMore) {
//            mDate = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[0];
//            mNum = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[1].split(
//                    "=")[1];
//        }
    }

    @Override
    public void showMoreDate(FindBean findBean) {
        super.showMoreDate(findBean);
        if (isLoadMore) {
            mDate = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[0];
            mNum = Utils.formatUrl(findBean.getNextPageUrl()).split("&")[1].split(
                    "=")[1];
        }
    }


}
