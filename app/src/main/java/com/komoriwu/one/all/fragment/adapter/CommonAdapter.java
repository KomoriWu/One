package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.viewholder.BannerSingleViewHolder;
import com.komoriwu.one.all.fragment.viewholder.BannerViewHolder;
import com.komoriwu.one.all.fragment.viewholder.BriefViewHolder;
import com.komoriwu.one.all.fragment.viewholder.DynamicInfoViewHolder;
import com.komoriwu.one.all.fragment.viewholder.FollowViewHolder;
import com.komoriwu.one.all.fragment.viewholder.TextCardViewHolder;
import com.komoriwu.one.all.fragment.viewholder.VideoBriefViewHolder;
import com.komoriwu.one.all.fragment.viewholder.VideoSmallHolder;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.HeaderBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class CommonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<ItemListBean> itemListBeanXES;
    public Context context;
    public OnItemClickListener onItemClickListener;

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

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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

    private void initBannerSingle(ItemListBean itemListBeanX, BannerSingleViewHolder holder) {
        Utils.displayImage(context, itemListBeanX.getData().getImage(), holder.ivCard);
        Utils.startAnimation(context, holder.ivCard);
    }

    private void initFollowView(final ItemListBean itemListBeanX, FollowViewHolder holder) {
        DataBean dataBean = itemListBeanX.getData();
        Utils.displayImage(context, dataBean.getContent().getData().getCover().
                getFeed(), holder.ivCardCover);
        holder.tvTitle.setText(dataBean.getContent().getData().getTitle());
        holder.tvDescription.setText(dataBean.getHeader().getDescription());
        holder.tvDescription.setText(String.format(context.getString(R.string.follow_description),
                dataBean.getContent().getData().getAuthor().getName(),
                dataBean.getContent().getData().getCategory()));
        holder.tvTime.setText(Utils.durationFormat(dataBean.getContent().getData().
                getDuration()));
        Utils.displayImage(context, dataBean.getHeader().getIcon(), holder.ivCover,
                true);
        Utils.startAnimation(context, holder.ivCardCover);
        Utils.startAnimation(context, holder.ivCover);

        setOnClickListener(holder.itemView, itemListBeanX);
    }


    private void initTextCard(ItemListBean itemListBeanX, TextCardViewHolder holder) {
        DataBean dataBean = itemListBeanX.getData();
        if (dataBean.getType().equals(Constants.HEADER5)) {
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
        } else if (dataBean.getType().equals(Constants.FOOTER2)) {
            holder.tvHeader.setVisibility(View.GONE);
            holder.tvFooter.setVisibility(View.VISIBLE);
            holder.tvFooter.setText(dataBean.getText());
        }
    }

    private void initDynamicInfo(ItemListBean itemListBean, DynamicInfoViewHolder holder) {
        DataBean.UserBean userBean = itemListBean.getData().getUser();
        DataBean.SimpleVideoBean simpleVideoBean = itemListBean.getData().getSimpleVideo();
        Utils.displayImage(context, userBean.getAvatar(), holder.ivHead, true);
        holder.tvUserName.setText(userBean.getNickname());
        holder.tvMessage.setText(itemListBean.getData().getReply().getMessage());
        Utils.displayImage(context, simpleVideoBean.getCover().getFeed(), holder.ivCover);
        holder.tvTitle.setText(simpleVideoBean.getTitle());
        holder.tvDescription.setText(String.format(context.getString(R.string.category1),
                simpleVideoBean.getCategory()));
        holder.tvLikeNum.setText(String.format(context.getString(R.string.like_num),
                String.valueOf(itemListBean.getData().getReply().getLikeCount())));
        holder.tvTime.setText(String.format(context.getString(R.string.create_date),
                Utils.getCreateTime(itemListBean.getData().getCreateDate())));
        Utils.startAnimation(context, holder.ivCover);
        Utils.startAnimation(context, holder.ivHead);
    }

    private void initVideoBrief(int position, VideoBriefViewHolder holder) {
        HeaderBean headerBean = itemListBeanXES.get(position).getData().getHeader();
        Utils.displayImage(context, headerBean.getIcon(), holder.ivCover, true);
        holder.tvTitle.setText(headerBean.getTitle());
        holder.tvDescription.setText(headerBean.getDescription());
        holder.rvItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.
                HORIZONTAL, false));
        BannerVideoBriefAdapter briefAdapter=new BannerVideoBriefAdapter(context, itemListBeanXES.
                get(position).getData().getItemList());
        holder.rvItem.setAdapter(briefAdapter);
        Utils.startAnimation(context, holder.ivCover);
        briefAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onVideoCardItemClick(ItemListBean itemListBeanX) {
                if (onItemClickListener != null) {
                    onItemClickListener.onVideoCardItemClick(itemListBeanX);
                }
            }
        });
    }


    private void initVideoSmall(ItemListBean itemListBeanX, VideoSmallHolder holder) {
        Utils.displayImage(context, itemListBeanX.getData().getCover().getFeed(), holder.ivCover,
                false, 300, 200);
        holder.tvTime.setText(Utils.durationFormat(itemListBeanX.getData().getDuration()));
        holder.tvTitle.setText(itemListBeanX.getData().getTitle());
        holder.tvDescription.setText(String.format(context.getString(R.string.small_description),
                itemListBeanX.getData().getCategory(), itemListBeanX.getData().getAuthor().getName()));
        Utils.startAnimation(context, holder.ivCover);
        setOnClickListener(holder.itemView, itemListBeanX);
    }

    private void initBrief(ItemListBean itemListBeanX, BriefViewHolder holder) {
        Utils.displayImage(context, itemListBeanX.getData().getIcon(), holder.ivCover);
        holder.tvTitle.setText(itemListBeanX.getData().getTitle());
        holder.tvDescription.setText(itemListBeanX.getData().getDescription());
        Utils.startAnimation(context, holder.ivCover);
    }

    private void initBanner(ItemListBean itemListBeanX, BannerViewHolder holder) {
        holder.rvItem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.
                HORIZONTAL, false));
        if (itemListBeanX.getData().getHeader() == null) {
            holder.tvHeader.setVisibility(View.GONE);
            holder.tvSubtitle.setVisibility(View.GONE);
            holder.rvItem.setAdapter(new BannerAdapter(context, itemListBeanX.getData().
                    getItemList()));
        } else {
            HeaderBean headerBean = itemListBeanX.getData().getHeader();
            holder.tvSubtitle.setVisibility(View.VISIBLE);
            holder.tvHeader.setVisibility(View.VISIBLE);
            holder.tvHeader.setText(headerBean.getTitle());
            holder.tvSubtitle.setText(headerBean.getSubTitle());
            if (headerBean.getFont().equals(Constants.BIG_BOLD)) {
                holder.viewLine.setVisibility(View.GONE);
                holder.tvHeader.setTextSize(context.getResources().getDimension(R.dimen.dp_9_y));
                FollowCardAdapter followCardAdapter=new FollowCardAdapter(context, itemListBeanX.
                        getData().getItemList());
                holder.rvItem.setAdapter(followCardAdapter);
                followCardAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onVideoCardItemClick(ItemListBean itemListBeanX) {
                        if (onItemClickListener != null) {
                            onItemClickListener.onVideoCardItemClick(itemListBeanX);
                        }
                    }
                });
            } else {
                holder.tvHeader.setTextSize(context.getResources().getDimension(R.dimen.dp_8_y));
                holder.rvItem.setAdapter(new BannerAdapter(context, itemListBeanX.getData().
                        getItemList(), true));
            }
        }
    }
    private void setOnClickListener(View itemView, final ItemListBean itemListBeanX) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onVideoCardItemClick(itemListBeanX);
                }
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
