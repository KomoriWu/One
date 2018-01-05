package com.komoriwu.one.all.detail;

import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.mvp.DetailBaseContract;
import com.komoriwu.one.base.BasePresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.CategoryDetailBean;
import com.komoriwu.one.model.bean.TagsDetailInfo;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public abstract class DetailBaseActivity<T extends BasePresenter> extends MvpBaseActivity<T>
        implements DetailBaseContract.View {
    public static final String TAG = DetailBaseActivity.class.getSimpleName();
    public ViewPager viewPager;
    public Button btnFocus;
    public FZTextView tvBoldTitle;
    public Toolbar toolbar;
    public ImageView ivCoverBg;
    public SmartTabLayout tabViewPager;
    public FZTextView tvName;
    public FZTextView tvDescription;
    public AppBarLayout appBar;
    private AppBarState mState;

    public abstract FragmentPagerItems getPages();

    public abstract void loadCategoriesDetail(String id);

    private enum AppBarState {
        EXPANDED,
        COLLAPSED,
        MIDDLE
    }

    @Override
    public int getLayout() {
        return R.layout.activity_categories_detail;
    }

    @Override
    public void init() {
        viewPager = findViewById(R.id.view_pager);
        btnFocus = findViewById(R.id.btn_focus);
        tvBoldTitle = findViewById(R.id.tv_bold_title);
        toolbar = findViewById(R.id.toolbar);
        ivCoverBg = findViewById(R.id.iv_cover_bg);
        tabViewPager = findViewById(R.id.tab_view_pager);
        tvName = findViewById(R.id.tv_name);
        tvDescription = findViewById(R.id.tv_description);
        appBar = findViewById(R.id.app_bar);

        initToolB();
        initTab();
        initListener();

        //加载封面数据
        loadCategoriesDetail(getIntent().getStringExtra(Constants.ID));
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
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                getPages());
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
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void refreshCategories(CategoryDetailBean.CategoryInfoBean categoryInfoBean) {

    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void refreshTagsData(TagsDetailInfo.TagInfoBean tagInfoBean) {

    }

    public void initUi(boolean isShowBtn,String title,String imgUrl,String description) {
        tvDescription.setVisibility(isShowBtn?View.GONE:View.VISIBLE);
        btnFocus.setVisibility(isShowBtn?View.VISIBLE:View.GONE);
        tvBoldTitle.setText(title);
        Utils.displayImage(this, imgUrl, ivCoverBg, getResources().getColor(R.color.
                detail_index_bg3));
        tvName.setText(title);
        tvDescription.setText(description);
    }

}
