package com.komoriwu.one.base;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.just.agentweb.AgentWeb;
import com.komoriwu.one.R;

/**
 * Created by KomoriWu
 * on 2018-01-23.
 */

public abstract class WebBaseActivity<T extends BasePresenter> extends MvpBaseActivity<T> {
    public AgentWeb agentWeb;

    public abstract RelativeLayout setRelativeLayout();
    public abstract void onWebFinished();

    @Override
    public void init() {
        agentWeb = AgentWeb.with(this)
                //传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ，
                // 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                .setAgentWebParent(setRelativeLayout(), new RelativeLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()// 使用默认进度条
                .setIndicatorColor(getResources().getColor(R.color.app_bar_color))
                .setWebViewClient(mWebViewClient)
                .createAgentWeb()
                .ready()
                .go(null);

    }


    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            onWebFinished();
        }
    };

    @Override
    protected void onPause() {
        agentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        agentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        agentWeb.getWebLifeCycle().onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {

    }

}
