package com.komoriwu.one.all.detail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.mvp.VideoCardPresenter;
import com.komoriwu.one.base.MvpBaseActivity;
import com.komoriwu.one.model.bean.ContentBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
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
    @BindView(R.id.rv_tags)
    RecyclerView rvTags;
    @BindView(R.id.iv_author_icon)
    ImageView ivAuthorIcon;
    @BindView(R.id.tv_author_name)
    FZTextView tvAuthorName;
    @BindView(R.id.tv_author_description)
    FZTextView tvAuthorDescription;
    private FindBean.ItemListBeanX mItemListBeanX;
    private TagsAdapter mTagsAdapter;

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
        initRecycleView();
        mItemListBeanX = (FindBean.ItemListBeanX) getIntent().getSerializableExtra(Constants.
                ITEM_LIST_BEAN_X);
        if (mItemListBeanX.getType().equals(Constants.FOLLOW_CARD)) {
            ContentBean.DataBean dataBean = mItemListBeanX.getData().getContent().getData();
            ImageLoader.getInstance().displayImage(dataBean.getCover().getBlurred(), ivCoverBg);
            tvTitle.setText(mItemListBeanX.getData().getHeader().getTitle());
            tvCategory.setText(String.format(getString(R.string.category1), dataBean.getCategory()));
            tvDescription.setText(dataBean.getDescription());
            tvLikeNum.setText(String.valueOf(dataBean.getConsumption().getCollectionCount()));
            tvShareNum.setText(String.valueOf(dataBean.getConsumption().getShareCount()));
            tvReplyNum.setText(String.valueOf(dataBean.getConsumption().getReplyCount()));

            mTagsAdapter.setRvData(dataBean.getTags());

            Utils.displayImage(this, dataBean.getAuthor().getIcon(), ivAuthorIcon, Utils.
                    getImageOptions(R.mipmap.ic_launcher_round, 360));
            tvAuthorName.setText(dataBean.getAuthor().getName());
            tvAuthorDescription.setText(dataBean.getAuthor().getDescription());
        }


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
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
