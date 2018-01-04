package com.komoriwu.one.all.detail;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.fragment.HomeFragment;
import com.komoriwu.one.all.detail.mvp.CategoriesDetailContract;
import com.komoriwu.one.all.detail.mvp.CategoriesDetailPresenter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class TagsDetailActivity extends DetailBaseActivity<CategoriesDetailPresenter>
        implements CategoriesDetailContract.View {
    public static final String TAG = TagsDetailActivity.class.getSimpleName();

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public FragmentPagerItems getPages() {
        String[] tabs = getResources().getStringArray(R.array.tags_tabs);
        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of(tabs[0], HomeFragment.class));
        pages.add(FragmentPagerItem.of(tabs[1], HomeFragment.class));
        return pages;
    }

    @Override
    public void loadCategoriesDetail(String id) {
        presenter.loadCategoriesDetail(id);
    }


}
