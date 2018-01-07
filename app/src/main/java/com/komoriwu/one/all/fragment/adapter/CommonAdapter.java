package com.komoriwu.one.all.fragment.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.komoriwu.one.R;
import com.komoriwu.one.all.detail.WebDetailActivity;
import com.komoriwu.one.all.fragment.viewholder.BannerSingleViewHolder;
import com.komoriwu.one.all.fragment.viewholder.BannerViewHolder;
import com.komoriwu.one.all.fragment.viewholder.BriefViewHolder;
import com.komoriwu.one.all.fragment.viewholder.DynamicInfoViewHolder;
import com.komoriwu.one.all.fragment.viewholder.FollowViewHolder;
import com.komoriwu.one.all.fragment.viewholder.TextCardViewHolder;
import com.komoriwu.one.all.fragment.viewholder.VideoBriefViewHolder;
import com.komoriwu.one.all.fragment.viewholder.VideoSmallHolder;
import com.komoriwu.one.all.listener.OnItemAuthorClickListener;
import com.komoriwu.one.all.listener.OnItemBannerClickListener;
import com.komoriwu.one.all.listener.OnItemCategoryClickListener;
import com.komoriwu.one.all.listener.OnItemVideoClickListener;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.HeaderBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.model.bean.event.IntentEvent;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class CommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<ItemListBean> itemListBeanXES;
    public Context context;
    public OnItemVideoClickListener onItemVideoClickListener;
    public OnItemCategoryClickListener onItemCategoryClickListener;
    public OnItemAuthorClickListener onItemAuthorClickListener;
    public OnItemBannerClickListener onItemBannerClickListener;

    public enum ITEM_TYPE {
        CATEGORY_HORIZONTAL_CARD,
        CATEGORY_TEXT_CARD,
        CATEGORY_BRIEF_CARD,
        CATEGORY_FOLLOW_CARD,
        CATEGORY_VIDEO_SMALL_CARD,
        CATEGORY_VIDEO_WITH_BRIEF,
        CATEGORY_DYNAMIC_INFO_CARD,
        CATEGORY_BANNER,
        CATEGORY_NULL,
    }

    public CommonAdapter(Context context) {
        this.context = context;
        this.itemListBeanXES = new ArrayList<>();
    }

    public void setOnItemVideoClickListener(OnItemVideoClickListener onItemVideoClickListener) {
        this.onItemVideoClickListener = onItemVideoClickListener;
    }

    public void setOnItemCategoryClickListener(OnItemCategoryClickListener onItemCategoryClickListener) {
        this.onItemCategoryClickListener = onItemCategoryClickListener;
    }

    public void setOnItemAuthorClickListener(OnItemAuthorClickListener onItemAuthorClickListener) {
        this.onItemAuthorClickListener = onItemAuthorClickListener;
    }

    public void setOnItemBannerClickListener(OnItemBannerClickListener onItemBannerClickListener) {
        this.onItemBannerClickListener = onItemBannerClickListener;
    }

    public void refreshList(List<ItemListBean> mItemListBeanXES) {
        this.itemListBeanXES.clear();
        this.itemListBeanXES = mItemListBeanXES;
        notifyItemRangeChanged(0, mItemListBeanXES.size());
    }

    public void addItemListBeanXES(List<ItemListBean> mItemListBeanXES) {
        int index = getItemCount();
        this.itemListBeanXES.addAll(mItemListBeanXES);
        //局部刷新
        for (int i = index; i < this.itemListBeanXES.size(); i++) {
            notifyItemInserted(i);
        }
    }


    @Override
    public int getItemViewType(int position) {
        int type = ITEM_TYPE.CATEGORY_NULL.ordinal();
        if (itemListBeanXES.get(position).getData() != null) {
            switch (itemListBeanXES.get(position).getType()) {
                case Constants.VIDEO_HORIZONTAL_CARD:
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
                case Constants.BANNER:
                    type = ITEM_TYPE.CATEGORY_BANNER.ordinal();
                    break;
            }
        }
        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
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
            return new FollowViewHolder(layoutInflater.inflate(R.layout.item_follow_card_comman,
                    parent, false));
        } else if (viewType == ITEM_TYPE.CATEGORY_VIDEO_SMALL_CARD.ordinal()) {
            return new VideoSmallHolder(layoutInflater.inflate(R.layout.item_small_card, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_VIDEO_WITH_BRIEF.ordinal()) {
            return new VideoBriefViewHolder(layoutInflater.inflate(R.layout.item_video_brief, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_DYNAMIC_INFO_CARD.ordinal()) {
            return new DynamicInfoViewHolder(layoutInflater.inflate(R.layout.item_dynamic_info_card,
                    parent, false));
        } else if (viewType == ITEM_TYPE.CATEGORY_BANNER.ordinal()) {
            return new BannerSingleViewHolder(layoutInflater.inflate(R.layout.item_banner_card_single,
                    parent, false));
        } else {
            return new NullViewHolder(layoutInflater.inflate(R.layout.item_null, parent,
                    false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemListBean itemListBeanX = itemListBeanXES.get(position);
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
            initDynamicInfo(itemListBeanX, ((DynamicInfoViewHolder) holder));
        } else if (holder instanceof BannerSingleViewHolder) {
            initBannerSingle(itemListBeanX, ((BannerSingleViewHolder) holder));
        }
    }

    private void initBannerSingle(final ItemListBean itemListBeanX, BannerSingleViewHolder holder) {
        Utils.displayImage(context, itemListBeanX.getData().getImage(), holder.ivCard);
        Utils.startAnimation(context, holder.ivCard);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemBannerClickListener.onItemBannerClick(itemListBeanX.getData().getActionUrl());
            }
        });
    }

    private void initFollowView(final ItemListBean itemListBean, FollowViewHolder holder) {
        if (itemListBean.getType().equals(Constants.BANNER3)) {
            holder.tvTime.setVisibility(View.GONE);
            holder.tvAd.setVisibility(View.VISIBLE);
            holder.ivSelect.setVisibility(View.GONE);
            holder.tvDescription.setText(itemListBean.getData().getDescription());
            Utils.displayImage(context, itemListBean.getData().getImage(), holder.ivCardCover);
        } else {
            holder.tvTime.setVisibility(View.VISIBLE);
            holder.tvAd.setVisibility(View.GONE);
            DataBean contentDataBean = itemListBean.getData().getContent().getData();
            Utils.displayImage(context, contentDataBean.getCover().
                    getFeed(), holder.ivCardCover);
            if (contentDataBean.getAuthor() != null) {
                holder.tvDescription.setText(String.format(context.getString(R.string.
                                follow_description), contentDataBean.getAuthor().getName(),
                        contentDataBean.getCategory()));
                holder.tvTime.setText(Utils.durationFormat(contentDataBean.getDuration()));
                if (contentDataBean.getAuthor().getName().contains(context.getString(R.string.select))) {
                    holder.ivSelect.setVisibility(View.VISIBLE);
                } else {
                    holder.ivSelect.setVisibility(View.GONE);
                }

            }
        }
        holder.tvTitle.setText(itemListBean.getData().getHeader().getTitle());
        Utils.displayImage(context, itemListBean.getData().getHeader().getIcon(), holder.ivCover,
                true);
        Utils.startAnimation(context, holder.ivCardCover);
        Utils.startAnimation(context, holder.ivCover);
        setVideoOnClickListener(holder.cardView, itemListBean);
        if (itemListBean.getData().getContent().getData().getAuthor() != null) {
            setAuthorOnClickListener(holder.layoutAuthor, itemListBean.getData().getContent().
                    getData().getAuthor().getId());
        }
    }


    private void initTextCard(ItemListBean itemListBeanX, TextCardViewHolder holder) {
        DataBean dataBean = itemListBeanX.getData();
        if (dataBean.getType().equals(Constants.HEADER5) || dataBean.getType().equals(Constants.
                HEADER2)) {
            holder.tvHeader.setVisibility(View.VISIBLE);
            holder.tvFooter.setVisibility(View.GONE);
            holder.tvHeader.setText(dataBean.getText());
            if (TextUtils.isEmpty(dataBean.getActionUrl())) {
                holder.tvHeader.setCompoundDrawables(null, null, null, null);
            } else {
                Drawable drawable = context.getResources().getDrawable(R.mipmap.
                        ic_action_more_arrow_dark);
                holder.tvHeader.setCompoundDrawablesWithIntrinsicBounds(null, null,
                        drawable, null);

            }
        } else if (dataBean.getType().equals(Constants.FOOTER2) ||
                dataBean.getType().equals(Constants.FOOTER1)) {
            holder.tvHeader.setVisibility(View.GONE);
            holder.tvFooter.setVisibility(View.VISIBLE);
            holder.tvFooter.setText(dataBean.getText());
        }
    }

    private void initDynamicInfo(final ItemListBean itemListBean, DynamicInfoViewHolder holder) {
        DataBean.UserBean userBean = itemListBean.getData().getUser();
        DataBean.SimpleVideoBean simpleVideoBean = itemListBean.getData().getSimpleVideo();
        Utils.displayImage(context, userBean.getAvatar(), holder.ivHead, true);
        holder.tvUserName.setText(userBean.getNickname());
        holder.tvText.setText(itemListBean.getData().getText());
        if (itemListBean.getData().getReply() == null) {
            holder.tvMessage.setVisibility(View.GONE);
            holder.tvTime.setVisibility(View.GONE);
            holder.tvLikeNum.setText(Utils.getCreateTime(context, itemListBean.getData().getCreateDate()));
        } else {
            holder.tvMessage.setVisibility(View.VISIBLE);
            holder.tvTime.setVisibility(View.VISIBLE);
            holder.tvMessage.setText(itemListBean.getData().getReply().getMessage());
            holder.tvLikeNum.setText(String.format(context.getString(R.string.like_num),
                    String.valueOf(itemListBean.getData().getReply().getLikeCount())));
            holder.tvTime.setText(String.format(context.getString(R.string.create_date_day),
                    Utils.getCreateTime(context, itemListBean.getData().getCreateDate())));
        }
        if (simpleVideoBean.getCover() != null) {
            Utils.displayImage(context, simpleVideoBean.getCover().getFeed(), holder.ivCover);
        }
        holder.tvTitle.setText(simpleVideoBean.getTitle());
        holder.tvDescription.setText(String.format(context.getString(R.string.category1),
                simpleVideoBean.getCategory()));
        Utils.startAnimation(context, holder.ivCover);
        Utils.startAnimation(context, holder.ivHead);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new IntentEvent(Constants.TO_VIDEO_CARD_ACTIVITY,
                        false, itemListBean));
            }
        });
    }

    private void initVideoBrief(int position, VideoBriefViewHolder holder) {
        HeaderBean headerBean = itemListBeanXES.get(position).getData().getHeader();
        Utils.displayImage(context, headerBean.getIcon(), holder.ivCover, true);
        holder.tvTitle.setText(headerBean.getTitle());
        holder.tvDescription.setText(headerBean.getDescription());
        holder.rvItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.
                HORIZONTAL, false));
        BannerVideoBriefAdapter briefAdapter = new BannerVideoBriefAdapter(context, itemListBeanXES.
                get(position).getData().getItemList());
        holder.rvItem.setAdapter(briefAdapter);
        Utils.startAnimation(context, holder.ivCover);
        setAuthorOnClickListener(holder.layoutAuthor, headerBean.getId());
        briefAdapter.setOnItemClickListener(new OnItemVideoClickListener() {
            @Override
            public void onItemVideoClick(ItemListBean itemListBeanX) {
                if (onItemVideoClickListener != null) {
                    onItemVideoClickListener.onItemVideoClick(itemListBeanX);
                }
            }
        });
    }


    private void initVideoSmall(ItemListBean itemListBeanX, VideoSmallHolder holder) {
        Utils.displayImage(context, itemListBeanX.getData().getCover().getFeed(), holder.ivCover,
                false);
        holder.tvTime.setText(Utils.durationFormat(itemListBeanX.getData().getDuration()));
        holder.tvTitle.setText(itemListBeanX.getData().getTitle());
        if (itemListBeanX.getData().getAuthor() != null) {
            holder.tvDescription.setText(String.format(context.getString(R.string.small_description),
                    itemListBeanX.getData().getCategory(), itemListBeanX.getData().getAuthor().getName()));
        }
        Utils.startAnimation(context, holder.ivCover);
        setVideoOnClickListener(holder.itemView, itemListBeanX);
    }

    private void initBrief(final ItemListBean itemListBeanX, BriefViewHolder holder) {
        Utils.displayImage(context, itemListBeanX.getData().getIcon(), holder.ivCover);
        holder.tvTitle.setText(itemListBeanX.getData().getTitle());
        if (TextUtils.isEmpty(itemListBeanX.getData().getDescription())) {
            holder.btnFocus.setVisibility(View.VISIBLE);
            holder.ivRight.setVisibility(View.GONE);
        } else {
            holder.btnFocus.setVisibility(View.GONE);
            holder.ivRight.setVisibility(View.VISIBLE);
            holder.tvDescription.setText(itemListBeanX.getData().getDescription());
        }
        Utils.startAnimation(context, holder.ivCover);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemCategoryClickListener.onCategoryItemClick(itemListBeanX);
            }
        });
    }

    private void initBanner(ItemListBean itemListBeanX, BannerViewHolder holder) {
        holder.rvItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.
                HORIZONTAL, false));
        if (itemListBeanX.getData().getHeader() == null) {
            holder.tvHeader.setVisibility(View.GONE);
            holder.tvSubtitle.setVisibility(View.GONE);
            BannerAdapter bannerAdapter = new BannerAdapter(context, itemListBeanX.getData().
                    getItemList());
            holder.rvItem.setAdapter(bannerAdapter);
            bannerAdapter.setOnItemBannerClickListener(new OnItemBannerClickListener() {
                @Override
                public void onItemBannerClick(String url) {
                    onItemBannerClickListener.onItemBannerClick(url);
                }
            });

        } else {
            initVideoBanner(itemListBeanX, holder);
        }
    }

    private void initVideoBanner(ItemListBean itemListBeanX, BannerViewHolder holder) {
        HeaderBean headerBean = itemListBeanX.getData().getHeader();
        holder.tvSubtitle.setVisibility(View.VISIBLE);
        holder.tvHeader.setVisibility(View.VISIBLE);
        holder.tvHeader.setText(headerBean.getTitle());
        holder.tvSubtitle.setText(headerBean.getSubTitle());
        if (headerBean.getFont().equals(Constants.BOLD)) {
            holder.tvHeader.setTextSize(context.getResources().getDimension(R.dimen.dp_8_y));
            BannerAdapter bannerAdapter = new BannerAdapter(context, itemListBeanX.getData().
                    getItemList(), true);
            holder.rvItem.setAdapter(bannerAdapter);
            bannerAdapter.setOnItemBannerClickListener(new OnItemBannerClickListener() {
                @Override
                public void onItemBannerClick(String url) {
                    onItemBannerClickListener.onItemBannerClick(url);
                }
            });
        } else {
            FollowCardAdapter followCardAdapter = new FollowCardAdapter(context, itemListBeanX.
                    getData().getItemList());
            holder.rvItem.setAdapter(followCardAdapter);
            if (headerBean.getFont().equals(Constants.BIG_BOLD)) {
                holder.tvHeader.setTextSize(context.getResources().getDimension(R.dimen.dp_9_y));
                followCardAdapter.setSelect(true);
            } else if (headerBean.getFont().equals(Constants.NORMAL)) {
                holder.tvHeader.setTextSize(context.getResources().getDimension(R.dimen.dp_8_y));
                followCardAdapter.setSelect(false);
            }
            holder.viewLine.setVisibility(View.GONE);
            followCardAdapter.setOnItemClickListener(new OnItemVideoClickListener() {
                @Override
                public void onItemVideoClick(ItemListBean itemListBeanX) {
                    if (onItemVideoClickListener != null) {
                        onItemVideoClickListener.onItemVideoClick(itemListBeanX);
                    }
                }
            });
            followCardAdapter.setOnItemAuthorClickListener(new OnItemAuthorClickListener() {
                @Override
                public void onItemAuthorClick(int id) {
                    if (onItemVideoClickListener != null) {
                        onItemAuthorClickListener.onItemAuthorClick(id);
                    }
                }
            });
        }
    }

    private void setVideoOnClickListener(View itemView, final ItemListBean itemListBeanX) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemVideoClickListener != null) {
                    onItemVideoClickListener.onItemVideoClick(itemListBeanX);
                }
            }
        });
    }

    private void setAuthorOnClickListener(View itemView, final int id) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemAuthorClickListener.onItemAuthorClick(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemListBeanXES == null ? 0 : itemListBeanXES.size();
    }

    class NullViewHolder extends RecyclerView.ViewHolder {

        public NullViewHolder(View itemView) {
            super(itemView);
        }
    }

}
