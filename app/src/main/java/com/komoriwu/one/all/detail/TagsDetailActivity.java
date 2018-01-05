package com.komoriwu.one.all.detail;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.fragment.CategoriesDetailIndexFragment;
import com.komoriwu.one.all.detail.fragment.TagsDetailIndexFragment;
import com.komoriwu.one.all.detail.mvp.DetailBaseContract;
import com.komoriwu.one.all.detail.mvp.TagsDetailPresenter;
import com.komoriwu.one.model.bean.TagsDetailInfo;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class TagsDetailActivity extends DetailBaseActivity<TagsDetailPresenter>
        implements DetailBaseContract.View {
    public static final String TAG = TagsDetailActivity.class.getSimpleName();

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public FragmentPagerItems getPages() {
        String[] tabs = getResources().getStringArray(R.array.tags_tabs);
        FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of(tabs[0], TagsDetailIndexFragment.class));
        pages.add(FragmentPagerItem.of(tabs[1], TagsDetailIndexFragment.class));
        return pages;
    }

    @Override
    public void loadCategoriesDetail(String id) {
        presenter.loadDetailIndex(id);
    }

    @Override
    public void refreshTagsData(TagsDetailInfo.TagInfoBean tagInfoBean) {
        tvBoldTitle.setText(tagInfoBean.getName());
        tvName.setText(tagInfoBean.getName());
        initUi(true, tagInfoBean.getName(), tagInfoBean.getHeaderImage(),
               "");
    }
}
