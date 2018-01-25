package com.komoriwu.one.all.detail;

import android.graphics.PixelFormat;
import android.os.Bundle;
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
import com.komoriwu.one.widget.X5WebView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

public class WebDetailActivity extends MvpBaseActivity<WebDetailPresenter> {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_bold_title)
    FZTextView tvBoldTitle;
    @BindView(R.id.web_view)
    X5WebView webView;
    @BindView(R.id.ball_pulse_view)
    BallPulseView ballPulseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //视频为了避免闪屏和透明问题
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
    }

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
        tvBoldTitle.setVisibility(View.VISIBLE);
        String url = UrlUtil.getURLDecoderString(getIntent().getStringExtra(Constants.URL));
        tvBoldTitle.setText(Utils.formatUrl(url));
        tvBoldTitle.setSelected(true);
        ballPulseView.startAnim();
        webView.loadUrl(url.split("url=")[1]);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                ballPulseView.setVisibility(View.GONE);
            }
        });
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

    @Override
    public void onDestroy() {
        if (webView != null)
            webView.destroy();
        super.onDestroy();
    }


    @Override
    public void showErrorMsg(String msg) {

    }


}
