package com.komoriwu.one.all.detail;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.fragment.CategoriesDetailIndexFragment;
import com.komoriwu.one.all.detail.mvp.DetailBaseContract;
import com.komoriwu.one.all.detail.mvp.CategoriesDetailPresenter;
import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class CategoriesDetailActivity extends DetailBaseActivity<CategoriesDetailPresenter>
        implements DetailBaseContract.View {
    public static final String TAG = CategoriesDetailActivity.class.getSimpleName();

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public FragmentPagerItems getPages() {
        String[] tabs = getResources().getStringArray(R.array.categories_tabs);
        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of(tabs[0], CategoriesDetailIndexFragment.class));
        pages.add(FragmentPagerItem.of(tabs[1], CategoriesDetailIndexFragment.class));
        pages.add(FragmentPagerItem.of(tabs[2], CategoriesDetailIndexFragment.class));
        pages.add(FragmentPagerItem.of(tabs[3], CategoriesDetailIndexFragment.class));
        return pages;
    }

    @Override
    public void loadCategoriesDetail(String id) {
        presenter.loadDetailIndex(id);
    }

    @Override
    public void refreshCategoriesData(CategoryDetailBean.CategoryInfoBean categoryInfoBean) {
        super.refreshCategoriesData(categoryInfoBean);
        initUi(false, categoryInfoBean.getName(), categoryInfoBean.getHeaderImage(),
                categoryInfoBean.getDescription());
    }
}
