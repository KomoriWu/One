package com.komoriwu.one.all.detail;

import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.fragment.HomeFragment;
import com.komoriwu.one.all.detail.mvp.CategoriesDetailContract;
import com.komoriwu.one.all.detail.mvp.CategoriesDetailPresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;

public class CategoriesDetailActivity extends DetailBaseActivity<CategoriesDetailPresenter>
        implements CategoriesDetailContract.View {
    public static final String TAG = CategoriesDetailActivity.class.getSimpleName();

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public FragmentPagerItems getPages() {
        String[] tabs = getResources().getStringArray(R.array.categories_tabs);
        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of(tabs[0], HomeFragment.class));
        pages.add(FragmentPagerItem.of(tabs[1], HomeFragment.class));
        pages.add(FragmentPagerItem.of(tabs[2], HomeFragment.class));
        pages.add(FragmentPagerItem.of(tabs[3], HomeFragment.class));
        return pages;
    }

    @Override
    public void loadCategoriesDetail(String id) {
        presenter.loadCategoriesDetail(id);
    }


}
