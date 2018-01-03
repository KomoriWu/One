package com.komoriwu.one.all.search;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.komoriwu.one.R;
import com.komoriwu.one.all.search.mvp.SearchContract;
import com.komoriwu.one.all.search.mvp.SearchPresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.widget.FZTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    private List<String> mTagList;

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
        presenter.loadTags();
        tagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                etSearch.setText(text);
                etSearch.setSelection(text.length());
//                presenter.loadQueryList(text);

            }

            @Override
            public void onTagLongClick(int position, String text) {

            }

            @Override
            public void onTagCrossClick(int position) {

            }
        });
    }

    @Override
    public void showTags(List<String> stringList) {
        mTagList = stringList;
        tagContainerLayout.setTags(mTagList);
    }

    @Override
    public void showQueryList(FindBean findBean) {

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
