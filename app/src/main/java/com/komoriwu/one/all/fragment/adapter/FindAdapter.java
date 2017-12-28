package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.viewholder.BannerViewHolder;
import com.komoriwu.one.all.fragment.viewholder.BriefViewHolder;
import com.komoriwu.one.all.fragment.viewholder.DynamicInfoViewHolder;
import com.komoriwu.one.all.fragment.viewholder.FollowViewHolder;
import com.komoriwu.one.all.fragment.viewholder.VideoSmallHolder;
import com.komoriwu.one.all.fragment.viewholder.TextCardViewHolder;
import com.komoriwu.one.all.fragment.viewholder.VideoBriefViewHolder;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.HeaderBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;

import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class FindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindBean.ItemListBeanX> mItemListBeanXES;
    private Context mContext;

    private enum ITEM_TYPE {
        CATEGORY_HORIZONTAL_CARD,
        CATEGORY_TEXT_CARD,
        CATEGORY_BRIEF_CARD,
        CATEGORY_FOLLOW_CARD,
        CATEGORY_VIDEO_SMALL_CARD,
        CATEGORY_VIDEO_WITH_BRIEF,
        CATEGORY_DYNAMIC_INFO_CARD,
        CATEGORY_NULL,
    }

    public FindAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setItemListBeanXES(List<FindBean.ItemListBeanX> mItemListBeanXES) {
        this.mItemListBeanXES = mItemListBeanXES;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int type = ITEM_TYPE.CATEGORY_NULL.ordinal();
        switch (mItemListBeanXES.get(position).getType()) {
            case Constants.SQUARE_CARD_COLLECTION:
            case Constants.HORIZONTAL_CARD:
                type = ITEM_TYPE.CATEGORY_HORIZONTAL_CARD.ordinal();
                break;

            case Constants.TEXT_CARD:
                type = ITEM_TYPE.CATEGORY_TEXT_CARD.ordinal();
                break;
            case Constants.BRIEF_CARD:
                type = ITEM_TYPE.CATEGORY_BRIEF_CARD.ordinal();
                break;
            case Constants.FOLLOW_CARD:
                type = ITEM_TYPE.CATEGORY_FOLLOW_CARD.ordinal();
                break;
            case Constants.VIDEO_SMALL_CARD:
                type = ITEM_TYPE.CATEGORY_VIDEO_SMALL_CARD.ordinal();
                break;
            case Constants.VIDEO_WITH_BRIEF:
                type = ITEM_TYPE.CATEGORY_VIDEO_WITH_BRIEF.ordinal();
                break;
            case Constants.DYNAMIC_INFO_CARD:
                type = ITEM_TYPE.CATEGORY_DYNAMIC_INFO_CARD.ordinal();
                break;
        }
        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        if (viewType == ITEM_TYPE.CATEGORY_HORIZONTAL_CARD.ordinal()) {
            return new BannerViewHolder(layoutInflater.inflate(R.layout.item_banner, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_TEXT_CARD.ordinal()) {
            return new TextCardViewHolder(layoutInflater.inflate(R.layout.item_text_card, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_BRIEF_CARD.ordinal()) {
            return new BriefViewHolder(layoutInflater.inflate(R.layout.item_brief_card, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_FOLLOW_CARD.ordinal()) {
            return new FollowViewHolder(layoutInflater.inflate(R.layout.item_follow_card, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_VIDEO_SMALL_CARD.ordinal()) {
            return new VideoSmallHolder(layoutInflater.inflate(R.layout.item_small_card, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_VIDEO_WITH_BRIEF.ordinal()) {
            return new VideoBriefViewHolder(layoutInflater.inflate(R.layout.item_video_brief, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_DYNAMIC_INFO_CARD.ordinal()) {
            return new DynamicInfoViewHolder(layoutInflater.inflate(R.layout.item_dynamic_info_card,
                    parent, false));
        } else {
            return new NullViewHolder(layoutInflater.inflate(R.layout.item_null, parent,
                    false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FindBean.ItemListBeanX itemListBeanX = mItemListBeanXES.get(position);
        if (holder instanceof BannerViewHolder) {
            initBanner(itemListBeanX, ((BannerViewHolder) holder));
        } else if (holder instanceof TextCardViewHolder) {
            initTextCard(itemListBeanX, ((TextCardViewHolder) holder));
        } else if (holder instanceof BriefViewHolder) {
            initBrief(itemListBeanX, ((BriefViewHolder) holder));
        } else if (holder instanceof FollowViewHolder) {
            initFollowView(itemListBeanX, ((FollowViewHolder) holder));
        } else if (holder instanceof VideoSmallHolder) {
            initVideoSmall(itemListBeanX, ((VideoSmallHolder) holder));
        } else if (holder instanceof VideoBriefViewHolder) {
            initVideoBrief(position, ((VideoBriefViewHolder) holder));
        } else if (holder instanceof DynamicInfoViewHolder) {
            initDynamicInfo(itemListBeanX,((DynamicInfoViewHolder) holder));
        }
    }

    private void initFollowView(FindBean.ItemListBeanX itemListBeanX, FollowViewHolder holder) {
        DataBean dataBean = itemListBeanX.getData();
        Utils.displayImage(mContext, dataBean.getContent().getData().getCover().
                getFeed(), holder.ivCardCover);
        holder.tvTitle.setText(dataBean.getContent().getData().getTitle());
        holder.tvDescription.setText(dataBean.getHeader().getDescription());
        holder.tvDescription.setText(String.format(mContext.getString(R.string.follow_description),
                dataBean.getContent().getData().getAuthor().getName(),
                dataBean.getContent().getData().getCategory()));
        holder.tvTime.setText(Utils.durationFormat(dataBean.getContent().getData().
                getDuration()));
        Utils.displayImage(mContext, dataBean.getHeader().getIcon(), holder.ivCover,
                true);
        Utils.startAnimation(mContext, holder.ivCardCover);
        Utils.startAnimation(mContext, holder.ivCover);
    }

    private void initTextCard(FindBean.ItemListBeanX itemListBeanX, TextCardViewHolder holder) {
        DataBean dataBean = itemListBeanX.getData();
        if (dataBean.getType().equals(Constants.HEADER5)) {
            holder.tvHeader.setVisibility(View.VISIBLE);
            holder.tvFooter.setVisibility(View.GONE);
            holder.tvHeader.setText(dataBean.getText());
            if (TextUtils.isEmpty(dataBean.getActionUrl())) {
                holder.tvHeader.setCompoundDrawables(null, null, null, null);
            } else {
                Drawable drawable = mContext.getResources().getDrawable(R.mipmap.
                        ic_action_more_arrow_dark);
                holder.tvHeader.setCompoundDrawablesWithIntrinsicBounds(null, null,
                        drawable, null);

            }
        } else if (dataBean.getType().equals(Constants.FOOTER2)) {
            holder.tvHeader.setVisibility(View.GONE);
            holder.tvFooter.setVisibility(View.VISIBLE);
            holder.tvFooter.setText(dataBean.getText());
        }
    }

    private void initDynamicInfo(FindBean.ItemListBeanX itemListBean, DynamicInfoViewHolder holder) {
        DataBean.UserBean userBean = itemListBean.getData().getUser();
        DataBean.SimpleVideoBean simpleVideoBean = itemListBean.getData().getSimpleVideo();
        Utils.displayImage(mContext, userBean.getAvatar(), holder.ivHead, true);
        holder.tvUserName.setText(userBean.getNickname());
        holder.tvMessage.setText(itemListBean.getData().getReply().getMessage());
        Utils.displayImage(mContext, simpleVideoBean.getCover().getFeed(), holder.ivCover);
        holder.tvTitle.setText(simpleVideoBean.getTitle());
        holder.tvDescription.setText(String.format(mContext.getString(R.string.category1),
                simpleVideoBean.getCategory()));
        holder.tvLikeNum.setText(String.format(mContext.getString(R.string.like_num),
                String.valueOf(itemListBean.getData().getReply().getLikeCount())));
        holder.tvTime.setText(String.format(mContext.getString(R.string.create_date),
                Utils.getCreateTime(itemListBean.getData().getCreateDate())));
        Utils.startAnimation(mContext, holder.ivCover);
        Utils.startAnimation(mContext, holder.ivHead);
    }

    private void initVideoBrief(int position, VideoBriefViewHolder holder) {
        HeaderBean headerBean = mItemListBeanXES.get(position).getData().getHeader();
        Utils.displayImage(mContext, headerBean.getIcon(), holder.ivCover, true);
        holder.tvTitle.setText(headerBean.getTitle());
        holder.tvDescription.setText(headerBean.getDescription());
        holder.rvItem.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.
                HORIZONTAL, false));
        holder.rvItem.setAdapter(new BannerVideoBriefAdapter(mContext, mItemListBeanXES.get(
                position).getData().getItemList()));
        Utils.startAnimation(mContext, holder.ivCover);
    }


    private void initVideoSmall(FindBean.ItemListBeanX itemListBeanX, VideoSmallHolder holder) {
        Utils.displayImage(mContext, itemListBeanX.getData().getCover().getFeed(), holder.ivCover,
                false, 300, 200);
        holder.tvTime.setText(Utils.durationFormat(itemListBeanX.getData().getDuration()));
        holder.tvTitle.setText(itemListBeanX.getData().getTitle());
        holder.tvDescription.setText(String.format(mContext.getString(R.string.small_description),
                itemListBeanX.getData().getCategory(), itemListBeanX.getData().getAuthor().getName()));
        Utils.startAnimation(mContext, holder.ivCover);
    }

    private void initBrief(FindBean.ItemListBeanX itemListBeanX, BriefViewHolder holder) {
        Utils.displayImage(mContext, itemListBeanX.getData().getIcon(), holder.ivCover);
        holder.tvTitle.setText(itemListBeanX.getData().getTitle());
        holder.tvDescription.setText(itemListBeanX.getData().getDescription());
        Utils.startAnimation(mContext, holder.ivCover);
    }

    private void initBanner(FindBean.ItemListBeanX itemListBeanX, BannerViewHolder holder) {
        if (itemListBeanX.getData().getHeader() == null) {
            holder.tvHeader.setVisibility(View.GONE);
        } else {
            holder.tvHeader.setVisibility(View.VISIBLE);
            holder.tvHeader.setText(itemListBeanX.getData().getHeader().getTitle());
        }
        holder.rvItem.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.
                HORIZONTAL, false));
        holder.rvItem.setAdapter(new BannerAdapter(mContext, itemListBeanX.getData().
                getItemList()));
    }

    @Override
    public int getItemCount() {
        return mItemListBeanXES == null ? 0 : mItemListBeanXES.size();
    }

    class NullViewHolder extends RecyclerView.ViewHolder {

        public NullViewHolder(View itemView) {
            super(itemView);
        }
    }

}
