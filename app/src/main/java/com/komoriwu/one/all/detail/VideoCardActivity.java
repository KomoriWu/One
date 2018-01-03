package com.komoriwu.one.all.detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.mvp.VideoCardContract;
import com.komoriwu.one.all.detail.mvp.VideoCardPresenter;
import com.komoriwu.one.all.fragment.adapter.SmallCardAdapter;
import com.komoriwu.one.all.listener.OnItemVideoClickListener;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;
import com.komoriwu.one.widget.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class VideoCardActivity extends MvpBaseActivity<VideoCardPresenter> implements
        OnItemVideoClickListener, VideoCardContract.View {
    public static final int DYNAMIC_VIDEO = 100;
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
    @BindView(R.id.layout_rv)
    RelativeLayout layoutRv;
    private ItemListBean mItemListBeanX;
    private TagsAdapter mTagsAdapter;
    private SmallCardAdapter mSmallCardAdapter;
    private boolean mIsGSYRelease;

    @Override
    public void setInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_video_card;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void init() {
        initGSYView();
        initRecycleView();
        if (getIntent().getFlags() == DYNAMIC_VIDEO) {
            presenter.loadVideoData(getIntent().getStringExtra(Constants.ID));
        } else {
            mItemListBeanX = (ItemListBean) getIntent().getSerializableExtra(Constants.
                    ITEM_LIST_BEAN_X);
            DataBean dataBean;
            if (mItemListBeanX.getType().equals(Constants.FOLLOW_CARD)) {
                dataBean = mItemListBeanX.getData().getContent().getData();
                tvTitle.startTypeWriter(mItemListBeanX.getData().getHeader().getTitle());
            } else {
                dataBean = mItemListBeanX.getData();
                tvTitle.startTypeWriter(mItemListBeanX.getData().getTitle());
            }
            initData(dataBean);
        }

    }

    @Override
    public void showVideoData(DataBean dataBean) {
        tvTitle.startTypeWriter(dataBean.getTitle());
        initData(dataBean);
    }

    private void initData(DataBean dataBean) {
        //设置加载时封面
        ImageView ivCoverVideo = new ImageView(this);
        ivCoverVideo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Utils.displayImage(this, dataBean.getCover().getFeed(), ivCoverVideo);
        videoPlayer.setThumbImageView(ivCoverVideo);

        videoPlayer.setUp(dataBean.getPlayUrl(), false, "");
        videoPlayer.startPlayLogic();

        Utils.displayImage(this, dataBean.getCover().getBlurred(), ivCoverBg);

        tvCategory.setText(String.format(getString(R.string.category1), dataBean.getCategory()));
        tvDescription.startTypeWriter(dataBean.getDescription());

        tvLikeNum.setText(String.valueOf(dataBean.getConsumption().getCollectionCount()));
        tvShareNum.setText(String.valueOf(dataBean.getConsumption().getShareCount()));
        tvReplyNum.setText(String.valueOf(dataBean.getConsumption().getReplyCount()));

        mTagsAdapter.setRvData(dataBean.getTags());

        Utils.displayImage(this, dataBean.getAuthor().getIcon(), ivAuthorIcon,
                true);
        tvAuthorName.setText(dataBean.getAuthor().getName());
        tvAuthorDescription.setText(dataBean.getAuthor().getDescription());

        presenter.loadRecommend(dataBean.getId());

        startAnim();
    }


    private void startAnim() {
        Flowable.timer(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        layoutMiddle.setVisibility(View.VISIBLE);
                        layoutRv.setVisibility(View.VISIBLE);
                        Animation animation = AnimationUtils.loadAnimation(
                                VideoCardActivity.this, R.anim.layout_bottom_show);
                        animation.setFillAfter(true);
                        layoutMiddle.startAnimation(animation);
                        layoutRv.startAnimation(animation);
                    }
                });

    }

    private void initRecycleView() {
        rvTags.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.
                HORIZONTAL, false));
        RecyclerView.ItemDecoration decoration = ItemDecorations.horizontal(this)
                .type(Constants.ALL_VIEW_TAPE, R.drawable.decoration_transparent_8)
                .create();
        mTagsAdapter = new TagsAdapter(this);
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

    }


    @Override
    public void refreshData(FindBean findBean) {
        mSmallCardAdapter.setSmallCardData(findBean.getItemList());
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void onAllItemClick(ItemListBean itemListBeanX) {
        Intent intent = new Intent(this, VideoCardActivity.class);
        intent.putExtra(Constants.ITEM_LIST_BEAN_X, itemListBeanX);
        startActivity(intent);
        overridePendingTransition(R.anim.screen_bottom_in, R.anim.screen_null);
        GSYVideoView.releaseAllVideos();
        mIsGSYRelease = true;
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.screen_null, R.anim.screen_bottom_out);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!mIsGSYRelease) {
            GSYVideoView.releaseAllVideos();
        }
    }

}
