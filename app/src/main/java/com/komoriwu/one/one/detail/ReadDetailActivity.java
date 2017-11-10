package com.komoriwu.one.one.detail;


import com.komoriwu.one.R;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.one.detail.mvp.ReadDetailContract;
import com.komoriwu.one.one.detail.mvp.ReadDetailPresenter;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;

public class ReadDetailActivity extends MvpBaseActivity<ReadDetailPresenter> implements
        ReadDetailContract.View {
    @BindView(R.id.html_text)
    HtmlTextView htmlTextView;

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_read_detail;
    }


    @Override
    public void init() {
//        presenter.loadReadDetail(0);
        presenter.loadMovieDetail(0);
    }

    @Override
    public void showErrorMsg(String msg) {

    }


    @Override
    public void showContent(String content) {
        htmlTextView.setHtml(content, new HtmlHttpImageGetter(htmlTextView));
    }
}
