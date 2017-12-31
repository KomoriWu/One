package com.komoriwu.one.all.detail;

import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.fragment.HomeFragment;
import com.komoriwu.one.all.detail.mvp.CategoriesDetailContract;
import com.komoriwu.one.all.detail.mvp.CategoriesDetailPresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

public class CategoriesDetailActivity extends MvpBaseActivity<CategoriesDetailPresenter>
        implements CategoriesDetailContract.View {
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
    @BindView(R.id.tv_name)
    FZTextView tvName;
    @BindView(R.id.tv_description)
    FZTextView tvDescription;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;

    private AppBarState mState;

    private enum AppBarState {
        EXPANDED,
        COLLAPSED,
        MIDDLE
    }

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
        initListener();
        presenter.loadCategoriesDetail("24");

    }

    private void initToolB() {
        setSupportActionBar(toolbar);
        setTitle("");
        toolbar.setNavigationIcon(R.mipmap.ic_action_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initTab() {
        String[] tabs = getResources().getStringArray(R.array.categories_tabs);
        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of(tabs[0], HomeFragment.class));
        pages.add(FragmentPagerItem.of(tabs[1], HomeFragment.class));
        pages.add(FragmentPagerItem.of(tabs[2], HomeFragment.class));
        pages.add(FragmentPagerItem.of(tabs[3], HomeFragment.class));
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                pages);
        viewPager.setAdapter(adapter);
        tabViewPager.setViewPager(viewPager);
    }

    private void initListener() {
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    if (mState != AppBarState.EXPANDED) {
                        mState = AppBarState.EXPANDED;//修改状态标记为展开
                        tvBoldTitle.setVisibility(View.GONE);
                        toolbar.setNavigationIcon(R.mipmap.ic_action_back_white);
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    if (mState != AppBarState.COLLAPSED) {
                        mState = AppBarState.COLLAPSED;//修改状态标记为折叠
                        tvBoldTitle.setVisibility(View.VISIBLE);
                        toolbar.setNavigationIcon(R.mipmap.ic_action_back);
                    }
                } else {
                    if (mState != AppBarState.MIDDLE) {
                        if (mState == AppBarState.COLLAPSED) {
                            tvBoldTitle.setVisibility(View.GONE);
                            toolbar.setNavigationIcon(R.mipmap.ic_action_back_white);
                        }
                        mState = AppBarState.MIDDLE;//修改状态标记为中间
                    }
                }
            }

        });
    }

    @Override
    public void refreshData(CategoryDetailBean.CategoryInfoBean categoryInfoBean) {
        tvBoldTitle.setText(categoryInfoBean.getName());
        Utils.displayImage(this, categoryInfoBean.getHeaderImage(), ivCoverBg);
        tvName.setText(categoryInfoBean.getName());
        tvDescription.setText(categoryInfoBean.getDescription());
    }

    @Override
    public void showErrorMsg(String msg) {

    }


}
