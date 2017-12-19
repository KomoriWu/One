package com.komoriwu.one.all.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.mvp.VideoCardContract;
import com.komoriwu.one.all.detail.mvp.VideoCardPresenter;
import com.komoriwu.one.all.fragment.adapter.SmallCardAdapter;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.model.bean.ContentBean;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoCardActivity extends MvpBaseActivity<VideoCardPresenter> implements
        OnItemClickListener, VideoCardContract.View {
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
    private FindBean.ItemListBeanX mItemListBeanX;
    private TagsAdapter mTagsAdapter;
    private SmallCardAdapter mSmallCardAdapter;

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
        mItemListBeanX = (FindBean.ItemListBeanX) getIntent().getSerializableExtra(Constants.
                ITEM_LIST_BEAN_X);
        DataBean dataBean;
        if (mItemListBeanX.getType().equals(Constants.FOLLOW_CARD)) {
            dataBean = mItemListBeanX.getData().getContent().getData();
            tvTitle.startTypeWriter(mItemListBeanX.getData().getHeader().getTitle());
        } else {
            dataBean = mItemListBeanX.getData();
            tvTitle.startTypeWriter(mItemListBeanX.getData().getTitle());
        }
        videoPlayer.setUp(dataBean.getPlayUrl(), false, "");
        videoPlayer.startPlayLogic();

        ImageLoader.getInstance().displayImage(dataBean.getCover().getBlurred(), ivCoverBg);

        tvCategory.startTypeWriter(String.format(getString(R.string.category1),
                dataBean.getCategory()) + "");
        tvDescription.startTypeWriter(dataBean.getDescription());

        tvLikeNum.setText(String.valueOf(dataBean.getConsumption().getCollectionCount()));
        tvShareNum.setText(String.valueOf(dataBean.getConsumption().getShareCount()));
        tvReplyNum.setText(String.valueOf(dataBean.getConsumption().getReplyCount()));

        mTagsAdapter.setRvData(dataBean.getTags());

        Utils.displayImage(this, dataBean.getAuthor().getIcon(), ivAuthorIcon, Utils.
                getImageOptions(R.mipmap.ic_launcher_round, 360));
        tvAuthorName.setText(dataBean.getAuthor().getName());
        tvAuthorDescription.setText(dataBean.getAuthor().getDescription());

        presenter.loadRecommend(dataBean.getId());
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
        videoPlayer.setRotateViewAuto(false);
        videoPlayer.getFullscreenButton().setOnClickListener(new View.
                OnClickListener() {
            @SuppressLint("WrongConstant")
            public final void onClick(View it) {
                if (getResources().getConfiguration().orientation == 1) {
                    VideoCardActivity.this.setRequestedOrientation(0);
                }
                videoPlayer.startWindowFullscreen(VideoCardActivity.this, true,
                        true);
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
    public void onVideoCardItemClick(FindBean.ItemListBeanX itemListBeanX) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoView.releaseAllVideos();
    }
}
