package com.komoriwu.one.all.leftmenu;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.adapter.BriefAdapter;
import com.komoriwu.one.all.leftmenu.mvp.AllCategoriesContract;
import com.komoriwu.one.all.leftmenu.mvp.AllCategoriesPresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.widget.FZTextView;

import butterknife.BindView;

public class AllCategoriesActivity extends MvpBaseActivity<AllCategoriesPresenter> implements
        AllCategoriesContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_bold_title)
    FZTextView tvBoldTitle;
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
        presenter.loadCategories();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBriefAdapter = new BriefAdapter(this);
        recyclerView.setAdapter(mBriefAdapter);
    }

    @Override
    public void refreshData(FindBean findBean) {
        mBriefAdapter.setAllCategoriesData(findBean.getItemList());
    }

    @Override
    public void showErrorMsg(String msg) {

    }

}
