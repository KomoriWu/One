package com.komoriwu.one.all.search;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.adapter.CommonAdapter;
import com.komoriwu.one.all.search.mvp.SearchContract;
import com.komoriwu.one.all.search.mvp.SearchPresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.BallPulseView;
import com.komoriwu.one.widget.FZTextView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

public class SearchActivity extends MvpBaseActivity<SearchPresenter> implements SearchContract.View {

    @BindView(R.id.tv_cancel)
    FZTextView tvCancel;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.layout_tag)
    TagContainerLayout tagContainerLayout;
    @BindView(R.id.layout_search)
    RelativeLayout layoutSearch;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    TwinklingRefreshLayout refreshLayout;
    private CommonAdapter mCommonAdapter;
    private String mCurrentSearchText;
    private boolean mIsLoadMore;
    private HashMap<String, String> mStringHashMap;

    @Override
    public int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void init() {
        mStringHashMap = new HashMap<>();
        Utils.setInputActive(SearchActivity.this, etSearch, true);
        presenter.loadTagsList();
        initRefreshLayout();
        initRecyclerView();
        initListener();
    }

    public void initRefreshLayout() {
        ProgressLayout headerView = new ProgressLayout(this);
        refreshLayout.setHeaderView(headerView);
        refreshLayout.setOverScrollRefreshShow(false);
        refreshLayout.setEnableLoadmore(false);
        BallPulseView loadingView = new BallPulseView(this);
        refreshLayout.setBottomView(loadingView);

        refreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                presenter.loadQueryList(mCurrentSearchText);
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                    presenter.loadMoreQueryList(mStringHashMap);
            }
        });

    }

    public void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ((DefaultItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        mCommonAdapter = new CommonAdapter(this);
        recyclerView.setAdapter(mCommonAdapter);
    }

    private void initListener() {
        tagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                etSearch.setText(text);
                etSearch.setSelection(text.length());

                startSearch(text);
            }

            @Override
            public void onTagLongClick(int position, String text) {

            }

            @Override
            public void onTagCrossClick(int position) {

            }
        });

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    startSearch(etSearch.getText().toString());
                }

                return false;
            }
        });
    }

    private void startSearch(String text) {
        mCurrentSearchText = text;
        layoutSearch.setVisibility(View.GONE);
        refreshLayout.setVisibility(View.VISIBLE);
        Utils.setInputActive(SearchActivity.this, etSearch, false);
        refreshLayout.startRefresh();
    }

    @Override
    public void hideRefresh(boolean isRefresh) {
        if (isRefresh) {
            refreshLayout.finishRefreshing();
        } else {
            refreshLayout.finishLoadmore();
        }
    }

    @Override
    public void showTags(List<String> stringList) {
        tagContainerLayout.setTags(stringList);
    }

    @Override
    public void refreshData(FindBean findBean) {
        mCommonAdapter.refreshList(findBean.getItemList());
        setStringHashMap(findBean.getNextPageUrl());
    }

    @Override
    public void showMoreDate(FindBean findBean) {
        mCommonAdapter.addItemListBeanXES(findBean.getItemList());
        setStringHashMap(findBean.getNextPageUrl());
    }

    public void setStringHashMap(String url) {
        mIsLoadMore = !TextUtils.isEmpty(url);
        refreshLayout.setEnableLoadmore(mIsLoadMore);
        if (mIsLoadMore) {
            String start = Utils.formatUrl(url).split("&")[0];
            String num = Utils.formatUrl(url).split("&")[1].split("=")[1];
            mStringHashMap.put(Constants.START, start);
            mStringHashMap.put(Constants.NUM, num);
            mStringHashMap.put(Constants.QUERY, mCurrentSearchText);
        }
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @OnClick(R.id.tv_cancel)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.screen_null, R.anim.screen_top_out);
    }


}
