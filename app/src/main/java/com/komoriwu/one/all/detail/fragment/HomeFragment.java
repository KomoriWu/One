package com.komoriwu.one.all.detail.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.VideoCardActivity;
import com.komoriwu.one.all.detail.fragment.mvp.HomeContract;
import com.komoriwu.one.all.detail.fragment.mvp.HomePresenter;
import com.komoriwu.one.all.fragment.adapter.CommonAdapter;
import com.komoriwu.one.all.listener.OnItemVideoClickListener;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017-12-31.
 */

public class HomeFragment extends MvpBaseFragment<HomePresenter> implements OnItemVideoClickListener,
        HomeContract.View {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private View mParentView;
    public boolean mIsInit = true;
    private LinearLayoutManager mLinearLayoutManager;
    private CommonAdapter mCommonAdapter;
    private boolean mIsLoadMore;
    private HashMap<String, String> mStringHashMap;
    private int mPosition;

    @Override
    protected void setInject() {
        getFragmentComponent().inject(this);
    }


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mParentView == null) {
            mParentView = inflater.inflate(R.layout.recycler_view, container, false);
        }
        return mParentView;
    }

    @Override
    public void init() {
        if (mIsInit) {
            initRecyclerView();
            initListener();
            mStringHashMap = new HashMap<>();
            mPosition = FragmentPagerItem.getPosition(getArguments());
            presenter.loadList(mPosition);
        }
    }

    public void initRecyclerView() {
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        mCommonAdapter = new CommonAdapter(getActivity());
        recyclerView.setAdapter(mCommonAdapter);
    }

    private void initListener() {
        mCommonAdapter.setOnItemVideoClickListener(this);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastVisiblePosition = mLinearLayoutManager.findLastVisibleItemPosition();
                    if (lastVisiblePosition >= mLinearLayoutManager.getItemCount() - 2) {
                        if (mIsLoadMore) {
                            presenter.loadMoreList(mPosition, mStringHashMap);
                        } else {
                            showSnackBar(R.string.the_end);
                        }
                    }
                }
            }
        });
    }


    @Override
    public void refreshData(FindBean findBean) {
        mCommonAdapter.refreshList(findBean.getItemList());
        setStringHashMap(findBean.getNextPageUrl());
    }

    @Override
    public void showMoreDate(FindBean findBean) {
        mCommonAdapter.addItemListBeanXES(findBean.getItemList());
        setStringHashMap(findBean.getNextPageUrl());
    }

    public void setStringHashMap(String url) {
        mIsLoadMore = !TextUtils.isEmpty(url);
        if (mIsLoadMore) {
            if (mPosition == 0) {
                mStringHashMap.put(Constants.PAGE, Utils.formatUrl(url).split("&")[0]);
            } else {
                String start = Utils.formatUrl(url).split("&")[0];
                String num = Utils.formatUrl(url).split("&")[1].split("=")[1];
                mStringHashMap.put(Constants.START, start);
                mStringHashMap.put(Constants.NUM, num);
            }
        }
    }

    @Override
    public void hideRefresh(boolean isRefresh) {

    }


    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != mParentView) {
            ((ViewGroup) mParentView.getParent()).removeView(mParentView);
            mIsInit = false;
        }
    }


    @Override
    public void onAllItemClick(ItemListBean itemListBeanX) {
        Intent intent = new Intent(getActivity(), VideoCardActivity.class);
        intent.putExtra(Constants.ITEM_LIST_BEAN_X, itemListBeanX);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.screen_bottom_in, R.anim.screen_null);
    }


}
