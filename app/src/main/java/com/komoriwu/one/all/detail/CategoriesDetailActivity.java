package com.komoriwu.one.all.detail;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.mvp.CategoriesDetailPresenter;
import com.komoriwu.one.all.fragment.CategoryFragment;
import com.komoriwu.one.all.fragment.DailyFragment;
import com.komoriwu.one.all.fragment.FindFragment;
import com.komoriwu.one.all.fragment.RecommendFragment;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.widget.FZTextView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesDetailActivity extends MvpBaseActivity<CategoriesDetailPresenter> {
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tv_bold_title)
    FZTextView tvBoldTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_cover_bg)
    ImageView ivCoverBg;
    @BindView(R.id.tab_view_pager)
    SmartTabLayout tabViewPager;

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_categories_detail;
    }

    @Override
    public void init() {
        initToolB();
        initTab();
    }

    private void initToolB() {
        setSupportActionBar(toolbar);
        setTitle("");
        toolbar.setNavigationIcon(R.mipmap.ic_action_back);
        tvBoldTitle.setText(R.string.all_categories);
    }

    private void initTab() {
        String[] tabs = getResources().getStringArray(R.array.tabs);
        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of(tabs[0], FindFragment.class));
        pages.add(FragmentPagerItem.of(tabs[1], RecommendFragment.class));
        pages.add(FragmentPagerItem.of(tabs[2], DailyFragment.class));
        pages.add(FragmentPagerItem.of(tabs[4], DailyFragment.class));
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                pages);
        viewPager.setAdapter(adapter);
        tabViewPager.setViewPager(viewPager);
    }

    @Override
    public void showErrorMsg(String msg) {

    }


}
