package com.komoriwu.one.all.detail.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.VideoCardActivity;
import com.komoriwu.one.all.detail.fragment.mvp.HomeContract;
import com.komoriwu.one.all.detail.fragment.mvp.HomePresenter;
import com.komoriwu.one.all.fragment.adapter.CommonAdapter;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by KomoriWu
 * on 2017-12-31.
 */

public class HomeFragment extends MvpBaseFragment<HomePresenter> implements OnItemClickListener,
        HomeContract.View {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private View mParentView;
    public boolean mIsInit = true;
    private CommonAdapter mCommonAdapter;

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
            presenter.loadList(FragmentPagerItem.getPosition(getArguments()), "24");
        }
    }

    public void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCommonAdapter = new CommonAdapter(getActivity());
        recyclerView.setAdapter(mCommonAdapter);
        mCommonAdapter.setOnItemClickListener(this);
    }

    @Override
    public void refreshData(FindBean findBean) {
        mCommonAdapter.refreshList(findBean.getItemList());
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
    }
}
