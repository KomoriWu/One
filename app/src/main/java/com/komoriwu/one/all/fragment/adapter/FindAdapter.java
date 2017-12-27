package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.viewholder.BannerViewHolder;
import com.komoriwu.one.all.fragment.viewholder.BriefViewHolder;
import com.komoriwu.one.all.fragment.viewholder.DynamicInfoViewHolder;
import com.komoriwu.one.all.fragment.viewholder.FollowVideoHolder;
import com.komoriwu.one.all.fragment.viewholder.VideoBriefViewHolder;
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
    private DynamicInfoAdapter mDynamicInfoAdapter;
    private SmallCardAdapter mSmallCardAdapter;
    private BriefAdapter mBriefAdapter;

    private enum ITEM_TYPE {
        CATEGORY_HORIZONTAL_CARD,
        CATEGORY_BRIEF_CARD,
        CATEGORY_FOLLOW_VIDEO_SMALL_CARD,
        CATEGORY_VIDEO_WITH_BRIEF,
        CATEGORY_DYNAMIC_INFO_CARD,
        CATEGORY_NULL,
    }

    public FindAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setItemListBeanXES(List<FindBean.ItemListBeanX> mItemListBeanXES) {
        this.mItemListBeanXES = mItemListBeanXES;
        mDynamicInfoAdapter = new DynamicInfoAdapter(mContext, mItemListBeanXES);
        mSmallCardAdapter = new SmallCardAdapter(mContext, mItemListBeanXES);
        mBriefAdapter = new BriefAdapter(mContext, mItemListBeanXES);
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
                String typeText = mItemListBeanXES.get(position).getData().getText();
                if (typeText.equals(mContext.getString(R.string.hot_sort))) {
                    type = ITEM_TYPE.CATEGORY_BRIEF_CARD.ordinal();
                } else if (typeText.equals(mContext.getString(R.string.week_ranking))) {
                    type = ITEM_TYPE.CATEGORY_FOLLOW_VIDEO_SMALL_CARD.ordinal();
                } else if (typeText.equals(mContext.getString(R.string.hot_comments))) {
//                    type = ITEM_TYPE.CATEGORY_DYNAMIC_INFO_CARD.ordinal();
                }
                break;
            case Constants.VIDEO_WITH_BRIEF:
                type = ITEM_TYPE.CATEGORY_VIDEO_WITH_BRIEF.ordinal();
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
        } else if (viewType == ITEM_TYPE.CATEGORY_BRIEF_CARD.ordinal()) {
            return new BriefViewHolder(layoutInflater.inflate(R.layout.item_brief, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_FOLLOW_VIDEO_SMALL_CARD.ordinal()) {
            return new FollowVideoHolder(layoutInflater.inflate(R.layout.item_follow_video, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_VIDEO_WITH_BRIEF.ordinal()) {
            return new VideoBriefViewHolder(layoutInflater.inflate(R.layout.item_video_brief, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_DYNAMIC_INFO_CARD.ordinal()) {
            return new DynamicInfoViewHolder(layoutInflater.inflate(R.layout.item_dynamic_info, parent,
                    false));
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
        } else if (holder instanceof BriefViewHolder) {
            initBrief(position, ((BriefViewHolder) holder));
        } else if (holder instanceof FollowVideoHolder) {
            initFollowVideo(position, ((FollowVideoHolder) holder));
        } else if (holder instanceof VideoBriefViewHolder) {
            initVideoBrief(position, ((VideoBriefViewHolder) holder));
        } else if (holder instanceof DynamicInfoViewHolder) {
            initDynamicInfo(itemListBeanX, ((DynamicInfoViewHolder) holder));
        }
    }

    private void initDynamicInfo(FindBean.ItemListBeanX itemListBeanX, DynamicInfoViewHolder holder) {
        holder.tvType.setText(itemListBeanX.getData().getText());
        holder.rvItem.setLayoutManager(new LinearLayoutManager(mContext));
        holder.rvItem.setAdapter(mDynamicInfoAdapter);

    }

    private void initVideoBrief(int position, VideoBriefViewHolder holder) {
        String typeText = mItemListBeanXES.get(position - 1).getData().getText();
        String typeText2 = mItemListBeanXES.get(position + 1).getData().getText();
        holder.tvType.setVisibility(TextUtils.isEmpty(typeText) ? View.GONE : View.VISIBLE);
        holder.tvType.setText(typeText);
        if (TextUtils.isEmpty(typeText2)) {
            holder.tvAllCategories.setVisibility(View.GONE);
        } else {
            holder.tvAllCategories.setVisibility(typeText2.contains(mContext.getString(R.
                    string.all)) ? View.VISIBLE : View.GONE);
        }
        holder.tvAllCategories.setText(typeText2);

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


    private void initFollowVideo(int position, FollowVideoHolder holder) {
        String typeText = mItemListBeanXES.get(position).getData().getText();
        holder.tvType.setText(typeText);
        holder.rvFollowCard.setLayoutManager(new LinearLayoutManager(mContext));
        holder.rvSmallCard.setLayoutManager(new LinearLayoutManager(mContext));
        holder.rvFollowCard.setAdapter(new FollowCardAdapter(mContext, mItemListBeanXES.get(
                position + 1)));
        holder.rvSmallCard.setAdapter(mSmallCardAdapter);
        holder.tvAllCategories.setText(mItemListBeanXES.get(position + 4).getData().getText());
    }

    private void initBrief(int position, BriefViewHolder holder) {
        String typeText = mItemListBeanXES.get(position).getData().getText();
        holder.tvType.setText(typeText);
        holder.rvItem.setLayoutManager(new LinearLayoutManager(mContext));
        holder.rvItem.setAdapter(mBriefAdapter);
        holder.tvAllCategories.setText(mItemListBeanXES.get(position + 4).getData().getText());
    }

    private void initBanner(FindBean.ItemListBeanX itemListBeanX, BannerViewHolder holder) {
        if (itemListBeanX.getData().getHeader() == null) {
            holder.tvType.setVisibility(View.GONE);
        } else {
            holder.tvType.setVisibility(View.VISIBLE);
            holder.tvType.setText(itemListBeanX.getData().getHeader().getTitle());
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
