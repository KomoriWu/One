package com.komoriwu.one.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.komoriwu.one.R;
import com.komoriwu.one.all.AllFragment;
import com.komoriwu.one.all.detail.VideoCardActivity;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.main.mvp.MainContract;
import com.komoriwu.one.main.mvp.MainPresenter;
import com.komoriwu.one.me.MeFragment;
import com.komoriwu.one.model.bean.ContentListBean;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.model.bean.event.IntentEvent;
import com.komoriwu.one.one.OneFragment;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.HpTextView;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends MvpBaseActivity<MainPresenter> implements MainContract.View,
        RadioGroup.OnCheckedChangeListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.frame_content)
    FrameLayout frameContent;
    @BindView(R.id.layout_bottom)
    LinearLayout layoutBottom;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.rb_one)
    RadioButton rbOne;
    @BindView(R.id.rb_all)
    RadioButton rbAll;
    @BindView(R.id.rb_me)
    RadioButton rbMe;
    private Fragment mCurrentFragment;
    private OneFragment mOneFragment;
    private AllFragment mAllFragment;
    private MeFragment mMeFragment;
    private boolean mRadioChanged;

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        mCurrentFragment = new OneFragment();
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(R.id.rb_one);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        mRadioChanged = true;
        presenter.switchNavView(i);
    }

    @Override
    public void switchOneView() {
        if (mOneFragment == null) {
            mOneFragment = new OneFragment();
        }
        switchContent(mCurrentFragment, mOneFragment);
    }

    @Override
    public void switchAllView() {
        if (mAllFragment == null) {
            mAllFragment = new AllFragment();
        }
        switchContent(mCurrentFragment, mAllFragment);
    }

    @Override
    public void switchMeView() {
        if (mMeFragment == null) {
            mMeFragment = new MeFragment();
        }
        switchContent(mCurrentFragment, mMeFragment);
    }

    public void switchContent(Fragment from, Fragment to) {
        if (mCurrentFragment != to) {
            mCurrentFragment = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) {
                // 隐藏当前的fragment，add下一个到Activity中
                transaction.hide(from).add(R.id.frame_content, to).commit();
            } else {
                // 隐藏当前的fragment，显示下一个
                transaction.hide(from).show(to).commit();
            }
        }
    }

    @Override
    public void showErrorMsg(String msg) {
        Log.d(TAG, msg);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.rb_one, R.id.rb_all, R.id.rb_me})
    public void onViewClicked(View view) {
        if (!mRadioChanged) {
            switch (view.getId()) {
                case R.id.rb_one:
                    mOneFragment.scrollToTop();
                    break;
                case R.id.rb_all:
                    mAllFragment.scrollToTop();
                    break;
            }
        }
        mRadioChanged = false;
    }

    public void changeRadioBtnState(final boolean isShow) {
        Animation animation = AnimationUtils.loadAnimation(this, isShow ? R.anim.rb_show
                : R.anim.rb_hide);
        animation.setFillAfter(true);
        if (isShow) {
            radioGroup.setVisibility(View.VISIBLE);
        }
        layoutBottom.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isShow) {
                    radioGroup.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }


    @SuppressLint("SetTextI18n")
    public void showPopup(ContentListBean mContentListBean, TextView tvWeather) {
        View popView = LayoutInflater.from(this).inflate(R.layout.pop_reporter, null);
        final PopupWindow popWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
        TextView tvVolume = popView.findViewById(R.id.tv_volume);
        TextView tvTitle = popView.findViewById(R.id.tv_title);
        final ImageView ivCover = popView.findViewById(R.id.iv_cover);
        tvVolume.setText(mContentListBean.getVolume());
        Utils.displayImage(this, mContentListBean.getImgUrl(), ivCover);
        tvTitle.setText(mContentListBean.getTitle() + " | " + mContentListBean.
                getPicInfo());

        popView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow.dismiss();
            }
        });
        popWindow.setAnimationStyle(R.style.pop_animation);
        popWindow.showAsDropDown(tvWeather);
    }

    @SuppressLint("SetTextI18n")
    public void showPopup(VideoBean.ItemListBeanX itemListBeanX, HpTextView hpTextView) {
        View popView = LayoutInflater.from(this).inflate(R.layout.pop_video, null);
        final PopupWindow popWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);
        popWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
        final StandardGSYVideoPlayer gsyVideoPlayer = popView.findViewById(R.id.video_player);
        initGSYView(gsyVideoPlayer);
        setPlayer(gsyVideoPlayer, itemListBeanX.getData().getPlayUrl());

        popView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow.dismiss();
                GSYVideoView.releaseAllVideos();
            }
        });
        popWindow.setAnimationStyle(R.style.pop_animation);
        popWindow.showAsDropDown(hpTextView);
    }

    private void initGSYView(final StandardGSYVideoPlayer gsyVideoPlayer) {
        gsyVideoPlayer.setRotateViewAuto(false);
        gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.
                OnClickListener() {
            @SuppressLint("WrongConstant")
            public final void onClick(View it) {
                if (getResources().getConfiguration().orientation == 1) {
                    MainActivity.this.setRequestedOrientation(0);
                }
                gsyVideoPlayer.startWindowFullscreen(MainActivity.this, true,
                        true);
            }
        });
    }

    public void setPlayer(StandardGSYVideoPlayer gsyVideoPlayer, String playUrl) {
        gsyVideoPlayer.setUp(playUrl, false, "");
        gsyVideoPlayer.startPlayLogic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
    }

    @SuppressLint("WrongConstant")
    @Subscribe
    public void onEventMainThread(IntentEvent intentEvent) {
        switch (intentEvent.getFlag()) {
            case Constants.TO_VIDEO_CARD_ACTIVITY:
                Intent intent = new Intent(this, VideoCardActivity.class);
                if (intentEvent.isCommon()) {
                    intent.putExtra(Constants.ITEM_LIST_BEAN_X, intentEvent.getItemListBean());
                } else {
                    intent.setFlags(VideoCardActivity.DYNAMIC_VIDEO);
                    intent.putExtra(Constants.ID, String.valueOf(intentEvent.getItemListBean().
                            getData().getSimpleVideo().getId()));
                }
                startActivity(intent);
                overridePendingTransition(R.anim.screen_bottom_in, R.anim.screen_null);
                break;
        }
    }
}
