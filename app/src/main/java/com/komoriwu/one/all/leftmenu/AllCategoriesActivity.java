package com.komoriwu.one.all.leftmenu;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.CategoriesDetailActivity;
import com.komoriwu.one.all.fragment.adapter.BriefAdapter;
import com.komoriwu.one.all.leftmenu.mvp.AllCategoriesContract;
import com.komoriwu.one.all.leftmenu.mvp.AllCategoriesPresenter;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.widget.FZTextView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import butterknife.BindView;

public class AllCategoriesActivity extends MvpBaseActivity<AllCategoriesPresenter> implements
        AllCategoriesContract.View, OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_bold_title)
    FZTextView tvBoldTitle;
    @BindView(R.id.refresh_layout)
    TwinklingRefreshLayout refreshLayout;
    private BriefAdapter mBriefAdapter;

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_all_categories;
    }

    @Override
    public void init() {
        isBack = true;
        initToolbar();
        toolbar.setNavigationIcon(R.mipmap.ic_action_back);
        tvBoldTitle.setVisibility(View.VISIBLE);
        tvBoldTitle.setText(R.string.all_categories);

        refreshLayout.startRefresh();
        initRefreshLayout();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBriefAdapter = new BriefAdapter(this);
        recyclerView.setAdapter(mBriefAdapter);
        mBriefAdapter.setOnItemClickListener(this);
    }

    public void initRefreshLayout() {
        ProgressLayout headerView = new ProgressLayout(this);
        refreshLayout.setHeaderView(headerView);
        refreshLayout.setOverScrollRefreshShow(false);
        refreshLayout.setEnableLoadmore(false);

        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                presenter.loadCategories();
            }

        });

    }

    @Override
    public void refreshData(FindBean findBean) {
        refreshLayout.finishRefreshing();
        refreshLayout.setEnableRefresh(false);
        mBriefAdapter.setAllCategoriesData(findBean.getItemList());
    }

    @Override
    public void showErrorMsg(String msg) {

    }


    @Override
    public void onAllItemClick(ItemListBean itemListBeanX) {
        Intent intent = new Intent(this, CategoriesDetailActivity.class);
        intent.putExtra("id", String.valueOf(itemListBeanX.getData().getId()));
        startActivity(intent);
    }
}
