package com.komoriwu.one.all.detail;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.mvp.ShareContract;
import com.komoriwu.one.all.detail.mvp.SharePresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.ImageLoader;
import com.komoriwu.one.widget.BallPulseView;
import com.komoriwu.one.widget.FZTextView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import butterknife.BindView;
import butterknife.OnClick;

public class ShareActivity extends MvpBaseActivity<SharePresenter> implements ShareContract.View {
    @BindView(R.id.tv_share)
    FZTextView tvShare;
    @BindView(R.id.tv_title)
    FZTextView tvTitle;
    @BindView(R.id.tv_share_qq)
    FZTextView tvShareQq;
    @BindView(R.id.layout_bottom)
    RelativeLayout layoutBottom;
    @BindView(R.id.tv_cancel)
    FZTextView tvCancel;
    @BindView(R.id.iv_share_cover)
    ImageView ivShareCover;
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    private DataBean mDataBean;
    private UMWeb mUmWeb;
    private String mCoverUrl;
    @BindView(R.id.ball_pulse_view)
    BallPulseView ballPulseView;

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_share;
    }

    @Override
    public void init() {
        ballPulseView.setAnimatingColor(getResources().getColor(R.color.white));

        mDataBean = (DataBean) getIntent().getSerializableExtra(Constants.DATA_BEAN);
        if (mDataBean.getCover().getHomepage() == null) {
            mCoverUrl = mDataBean.getCover().getFeed();
        } else {
            mCoverUrl = mDataBean.getCover().getHomepage();
        }
        ImageLoader.displayImage(this, mDataBean.getCover().getBlurred(), ivShareCover,
                getResources().getColor(R.color.detail_bg1));
        ImageLoader.displayImage(this, mCoverUrl, ivCover);
        tvTitle.setText(String.format(getString(R.string.share_title), mDataBean.getTitle()));

        mUmWeb = new UMWeb(mDataBean.getWebUrl().getForWeibo());
        mUmWeb.setTitle(String.format(getString(R.string.komori), mDataBean.getTitle()));
        mUmWeb.setThumb(new UMImage(this, mCoverUrl));
        mUmWeb.setDescription(mDataBean.getDescription());

        presenter.bottomShow();
    }

    @OnClick({R.id.tv_share_qq, R.id.tv_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_share_qq:
                ballPulseView.setVisibility(View.VISIBLE);
                ballPulseView.startAnim();
                new ShareAction(this)
                        .withMedia(mUmWeb)
                        .setPlatform(SHARE_MEDIA.QQ)
                        .setCallback(null).share();
                break;
            case R.id.tv_cancel:
                presenter.bottomHide();
                break;
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        ballPulseView.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        presenter.bottomHide();
    }

    @Override
    public void onBack() {
        super.onBackPressed();
        overridePendingTransition(R.anim.screen_null, R.anim.screen_top_out);
    }

    @Override
    public void bottomShow() {
        layoutBottom.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(
                ShareActivity.this, R.anim.layout_bottom_show);
        animation.setFillAfter(true);
        layoutBottom.startAnimation(animation);
    }

    @Override
    public void bottomHide() {
        Animation animation = AnimationUtils.loadAnimation(
                ShareActivity.this, R.anim.layout_bottom_hide);
        animation.setFillAfter(true);
        layoutBottom.startAnimation(animation);
    }

    @Override
    public void showErrorMsg(String msg) {

    }


}
