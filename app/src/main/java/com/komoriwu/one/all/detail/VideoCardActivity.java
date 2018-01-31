package com.komoriwu.one.all.detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.adapter.TagsAdapter;
import com.komoriwu.one.all.detail.mvp.VideoCardContract;
import com.komoriwu.one.all.detail.mvp.VideoCardPresenter;
import com.komoriwu.one.all.fragment.adapter.SmallCardAdapter;
import com.komoriwu.one.all.listener.OnItemTagsClickListener;
import com.komoriwu.one.all.listener.OnItemVideoClickListener;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.model.bean.event.IntentEvent;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.ImageLoader;
import com.komoriwu.one.widget.FZTextView;
import com.komoriwu.one.widget.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.listener.VideoAllCallBack;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import com.umeng.socialize.UMShareAPI;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

public class VideoCardActivity extends MvpBaseActivity<VideoCardPresenter> implements
        OnItemVideoClickListener, VideoCardContract.View, OnItemTagsClickListener {
    @BindView(R.id.video_player)
    StandardGSYVideoPlayer videoPlayer;
    @BindView(R.id.tv_title)
    FZTextView tvTitle;
    @BindView(R.id.tv_category)
    FZTextView tvCategory;
    @BindView(R.id.tv_description)
    FZTextView tvDescription;
    @BindView(R.id.iv_cover_bg)
    ImageView ivCoverBg;
    @BindView(R.id.tv_like_num)
    FZTextView tvLikeNum;
    @BindView(R.id.tv_share_num)
    FZTextView tvShareNum;
    @BindView(R.id.tv_reply_num)
    FZTextView tvReplyNum;
    @BindView(R.id.tv_download_num)
    FZTextView tvDownloadNum;
    @BindView(R.id.rv_tags)
    RecyclerView rvTags;
    @BindView(R.id.rv_recommend)
    RecyclerView rvRecommend;
    @BindView(R.id.iv_author_icon)
    ImageView ivAuthorIcon;
    @BindView(R.id.tv_author_name)
    FZTextView tvAuthorName;
    @BindView(R.id.tv_author_description)
    FZTextView tvAuthorDescription;
    @BindView(R.id.layout_middle)
    LinearLayout layoutMiddle;
    @BindView(R.id.layout_head)
    RelativeLayout layoutHead;
    @BindView(R.id.layout_author)
    RelativeLayout layoutAuthor;
    @BindView(R.id.nsv_scroller)
    NestedScrollView nsvScroller;
    private ItemListBean mItemListBeanX;
    private TagsAdapter mTagsAdapter;
    private SmallCardAdapter mSmallCardAdapter;
    private int mAuthorId;
    private DataBean mDataBean;
    private String mTitle;

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_video_card;
    }

    @Override
    public void init() {
        initGSYView();
        initRecycleView();
        initMainUi(getIntent());
    }

    @SuppressLint("WrongConstant")
    private void initMainUi(Intent intent) {
        if (!TextUtils.isEmpty(intent.getStringExtra(Constants.ID))) {
            presenter.loadVideoData(intent.getStringExtra(Constants.ID));
        } else {
            mItemListBeanX = (ItemListBean) intent.getSerializableExtra(Constants.
                    ITEM_LIST_BEAN_X);
            if (mItemListBeanX.getType().equals(Constants.FOLLOW_CARD)) {
                mDataBean = mItemListBeanX.getData().getContent().getData();
                mTitle = mItemListBeanX.getData().getHeader().getTitle();
            } else {
                mDataBean = mItemListBeanX.getData();
                mTitle = mItemListBeanX.getData().getTitle();

            }
            initData();
        }
    }

    @Override
    public void showVideoData(DataBean dataBean) {
        mDataBean = dataBean;
        mTitle = dataBean.getTitle();
        initData();
    }

    private void initData() {
        tvTitle.setTextColor(getResources().getColor(R.color.app_bar_color));
        tvDescription.setTextColor(getResources().getColor(R.color.app_bar_color));
        tvTitle.setText(mTitle);
        tvDescription.setText(mDataBean.getDescription());

        ImageLoader.displayImage(this, mDataBean.getCover().getBlurred(), ivCoverBg,
                false, R.mipmap.recommend_bg_unlike);

        //设置加载时封面
        ImageView ivCoverVideo = new ImageView(this);
        ivCoverVideo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageLoader.displayImage(this, mDataBean.getCover().getFeed(), ivCoverVideo);
        videoPlayer.setThumbImageView(ivCoverVideo);
        videoPlayer.setUp(mDataBean.getPlayUrl(), false, "");
        videoPlayer.startPlayLogic();

        tvCategory.setText(String.format(getString(R.string.category1), mDataBean.getCategory()));

        tvLikeNum.setText(String.valueOf(mDataBean.getConsumption().getCollectionCount()));
        tvShareNum.setText(String.valueOf(mDataBean.getConsumption().getShareCount()));
        tvReplyNum.setText(String.valueOf(mDataBean.getConsumption().getReplyCount()));

        mTagsAdapter.setRvData(mDataBean.getTags());
        if (mDataBean.getAuthor() != null) {
            mAuthorId = mDataBean.getAuthor().getId();

            ImageLoader.displayImage(this, mDataBean.getAuthor().getIcon(), ivAuthorIcon,
                    true);
            tvAuthorName.setText(mDataBean.getAuthor().getName());
            tvAuthorDescription.setText(mDataBean.getAuthor().getDescription());
        } else {
            layoutAuthor.setVisibility(View.GONE);
        }
        presenter.loadRecommend(mDataBean.getId());

    }

    private void initRecycleView() {
        rvTags.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.
                HORIZONTAL, false));
        RecyclerView.ItemDecoration decoration = ItemDecorations.horizontal(this)
                .type(Constants.ALL_VIEW_TAPE, R.drawable.decoration_transparent_8)
                .create();
        mTagsAdapter = new TagsAdapter(this, this);
        rvTags.setAdapter(mTagsAdapter);
        rvTags.addItemDecoration(decoration);

        rvRecommend.setLayoutManager(new LinearLayoutManager(this));
        mSmallCardAdapter = new SmallCardAdapter(this, this);
        mSmallCardAdapter.setIsDetail(true);
        rvRecommend.setAdapter(mSmallCardAdapter);
        rvRecommend.setNestedScrollingEnabled(false);
    }

    private void initGSYView() {
        videoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            public final void onClick(View it) {
                videoPlayer.startWindowFullscreen(VideoCardActivity.this, false,
                        true);
            }
        });
        videoPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        videoPlayer.setVideoAllCallBack(new VideoAllCallBack() {
            @Override
            public void onPrepared(String url, Object... objects) {
                showHeadUI();

            }

            @Override
            public void onClickStartIcon(String url, Object... objects) {

            }

            @Override
            public void onClickStartError(String url, Object... objects) {

            }

            @Override
            public void onClickStop(String url, Object... objects) {

            }

            @Override
            public void onClickStopFullscreen(String url, Object... objects) {

            }

            @Override
            public void onClickResume(String url, Object... objects) {

            }

            @Override
            public void onClickResumeFullscreen(String url, Object... objects) {

            }

            @Override
            public void onClickSeekbar(String url, Object... objects) {

            }

            @Override
            public void onClickSeekbarFullscreen(String url, Object... objects) {

            }

            @Override
            public void onAutoComplete(String url, Object... objects) {

            }

            @Override
            public void onEnterFullscreen(String url, Object... objects) {

            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {

            }

            @Override
            public void onQuitSmallWidget(String url, Object... objects) {

            }

            @Override
            public void onEnterSmallWidget(String url, Object... objects) {

            }

            @Override
            public void onTouchScreenSeekVolume(String url, Object... objects) {

            }

            @Override
            public void onTouchScreenSeekPosition(String url, Object... objects) {

            }

            @Override
            public void onTouchScreenSeekLight(String url, Object... objects) {

            }

            @Override
            public void onPlayError(String url, Object... objects) {

            }

            @Override
            public void onClickStartThumb(String url, Object... objects) {

            }

            @Override
            public void onClickBlank(String url, Object... objects) {

            }

            @Override
            public void onClickBlankFullscreen(String url, Object... objects) {

            }
        });
    }

    private void showHeadUI() {
        nsvScroller.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(
                VideoCardActivity.this, R.anim.layout_top_in);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tvTitle.startTypeWriter(VideoCardActivity.this, mTitle);
                tvDescription.startTypeWriter(VideoCardActivity.this, mDataBean.
                        getDescription(), false);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        layoutHead.startAnimation(animation);
    }

    @Override
    public void refreshData(FindBean findBean) {
        mSmallCardAdapter.setSmallCardData(findBean.getItemList());
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void onItemVideoClick(ItemListBean itemListBeanX) {
        EventBus.getDefault().post(new IntentEvent(this, Constants.TO_VIDEO_CARD_ACTIVITY,
                itemListBeanX));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.screen_null, R.anim.screen_bottom_out);
    }


    @Override
    protected void onPause() {
        super.onPause();
        videoPlayer.onVideoPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        videoPlayer.onVideoResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoView.releaseAllVideos();
    }


    @Override
    public void hideProgress() {

    }

    @Override
    public void onItemClick(int id) {
        Intent intent = new Intent(this, TagsDetailActivity.class);
        intent.putExtra(Constants.ID, String.valueOf(id));
        startActivity(intent);
    }

    @OnClick({R.id.layout_author, R.id.tv_share_num})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_author:
                Intent intent = new Intent(this, AuthorDetailActivity.class);
                intent.putExtra(Constants.ID, String.valueOf(mAuthorId));
                startActivity(intent);
                break;
            case R.id.tv_share_num:
                Intent intent1 = new Intent(this, ShareActivity.class);
                intent1.putExtra(Constants.DATA_BEAN, mDataBean);
                startActivity(intent1);
                overridePendingTransition(R.anim.screen_top_in, R.anim.screen_null);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    //Activity的启动模式(singleTask),通过这个方法接受Intent
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        nsvScroller.setVisibility(View.GONE);
        nsvScroller.scrollTo(0, 0);
        ;
        initMainUi(intent);
    }
}
