package com.komoriwu.one.all.detail;

import android.os.Bundle;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.mvp.VideoCardPresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.widget.FZTextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoCardActivity extends MvpBaseActivity<VideoCardPresenter> {
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
    private FindBean.ItemListBeanX mItemListBeanX;

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
        initData();
    }

    private void initData() {
        mItemListBeanX = (FindBean.ItemListBeanX) getIntent().getSerializableExtra(Constants.
                ITEM_LIST_BEAN_X);
        if (mItemListBeanX.getType().equals(Constants.FOLLOW_CARD)) {
            ImageLoader.getInstance().displayImage(mItemListBeanX.getData().getContent().getData().
                    getCover().getBlurred(), ivCoverBg);
            tvTitle.setText(mItemListBeanX.getData().getHeader().getTitle());
            tvCategory.setText(String.format(getString(R.string.category1), mItemListBeanX.
                    getData().getContent().getData().getCategory()));
            tvDescription.setText(mItemListBeanX.getData().getContent().getData().getDescription());
            tvLikeNum.setText(String.valueOf(mItemListBeanX.getData().getContent().getData().
                    getConsumption().getCollectionCount()));
            tvShareNum.setText(String.valueOf(mItemListBeanX.getData().getContent().getData().
                    getConsumption().getShareCount()));
            tvReplyNum.setText(String.valueOf(mItemListBeanX.getData().getContent().getData().
                    getConsumption().getReplyCount()));
        }
    }

    @Override
    public void showErrorMsg(String msg) {

    }

}
