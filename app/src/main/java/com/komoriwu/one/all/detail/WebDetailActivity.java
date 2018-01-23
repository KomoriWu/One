package com.komoriwu.one.all.detail;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.mvp.WebDetailPresenter;
import com.komoriwu.one.base.WebBaseActivity;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.UrlUtil;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.BallPulseView;
import com.komoriwu.one.widget.FZTextView;

import butterknife.BindView;

public class WebDetailActivity extends WebBaseActivity<WebDetailPresenter> {
    @BindView(R.id.layout_web)
    RelativeLayout layoutWeb;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_bold_title)
    FZTextView tvBoldTitle;
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
    public RelativeLayout setRelativeLayout() {
        return layoutWeb;
    }

    @Override
    public void init() {
        super.init();
        initToolB();
        tvBoldTitle.setVisibility(View.VISIBLE);
        String url = UrlUtil.getURLDecoderString(getIntent().getStringExtra(Constants.URL));
        tvBoldTitle.setText(Utils.formatUrl(url));
        tvBoldTitle.setSelected(true);
        ballPulseView.startAnim();
        agentWeb.getLoader().loadUrl(url.split("url=")[1]);
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
    public void onWebFinished() {
        ballPulseView.setVisibility(View.GONE);
    }

}
