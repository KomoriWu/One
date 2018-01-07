package com.komoriwu.one.all.detail;

import android.annotation.SuppressLint;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.mvp.WebDetailPresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.UrlUtil;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.BallPulseView;
import com.komoriwu.one.widget.FZTextView;
import com.komoriwu.one.widget.HpTextView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

public class WebDetailActivity extends MvpBaseActivity<WebDetailPresenter> {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_bold_title)
    FZTextView tvBoldTitle;
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.ball_pulse_view)
    BallPulseView ballPulseView;

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_web_detail;
    }

    @Override
    public void init() {
        initToolB();
        initWebView();
        tvBoldTitle.setVisibility(View.VISIBLE);
        String url = UrlUtil.getURLDecoderString(getIntent().getStringExtra(Constants.URL));
        tvBoldTitle.setText(Utils.formatUrl(url));
        ballPulseView.startAnim();
        webView.loadUrl(url.split("url=")[1]);
    }

    private void initToolB() {
        setSupportActionBar(toolbar);
        setTitle("");
        toolbar.setNavigationIcon(R.mipmap.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        WebSettings settings = webView.getSettings();
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                ballPulseView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }

    @Override
    public void showErrorMsg(String msg) {

    }


}
