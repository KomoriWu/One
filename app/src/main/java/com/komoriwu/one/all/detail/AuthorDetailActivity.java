package com.komoriwu.one.all.detail;

import android.os.Bundle;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.fragment.TagsDetailIndexFragment;
import com.komoriwu.one.all.detail.mvp.DetailBaseContract;
import com.komoriwu.one.all.detail.mvp.TagsDetailPresenter;
import com.komoriwu.one.model.bean.TagsDetailInfo;
import com.komoriwu.one.widget.DCTextView;
import com.komoriwu.one.widget.FZTextView;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthorDetailActivity extends DetailBaseActivity<TagsDetailPresenter>
        implements DetailBaseContract.View {
    public static final String TAG = AuthorDetailActivity.class.getSimpleName();
    @BindView(R.id.tv_focus_num)
    FZTextView tvFocusNum;
    @BindView(R.id.tv_video_num)
    DCTextView tvVideoNum;
    @BindView(R.id.tv_like_num)
    DCTextView tvLikeNum;
    @BindView(R.id.tv_share_num)
    DCTextView tvShareNum;

    @Override
    public int getLayout() {
        return R.layout.activity_author_detail;
    }

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
