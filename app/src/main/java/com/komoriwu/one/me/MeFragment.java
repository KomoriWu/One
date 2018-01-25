package com.komoriwu.one.me;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.komoriwu.one.R;
import com.komoriwu.one.all.AllFragment;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.me.mvp.MeContract;
import com.komoriwu.one.me.mvp.MePresenter;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.widget.BallPulseView;
import com.komoriwu.one.widget.HpTextView;
import com.komoriwu.one.widget.X5WebView;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class MeFragment extends MvpBaseFragment<MePresenter> implements MeContract.View {
    private static final String TAG = AllFragment.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_hp_title)
    HpTextView tvHpTitle;
    @BindView(R.id.web_view)
    X5WebView webView;
    @BindView(R.id.ball_pulse_view)
    BallPulseView ballPulseView;

    @Override
    protected void setInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me, null);
    }

    @Override
    public void init() {
        tvHpTitle.setVisibility(View.VISIBLE);
        tvHpTitle.setText(R.string.me);
        ballPulseView.startAnim();
        webView.loadUrl(Constants.GIT_HUB);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                ballPulseView.setVisibility(View.GONE);
            }
        });
    }


    @Override
    public void showErrorMsg(String msg) {
        Log.d(TAG, msg);
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }


}