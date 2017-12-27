package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.viewholder.BannerRProjectViewHolder;
import com.komoriwu.one.all.fragment.viewholder.BannerRTopicViewHolder;
import com.komoriwu.one.all.fragment.viewholder.BannerViewHolder;
import com.komoriwu.one.all.fragment.viewholder.BriefViewHolder;
import com.komoriwu.one.all.fragment.viewholder.FollowVideoHolder;
import com.komoriwu.one.all.fragment.viewholder.VideoBriefViewHolder;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.HeaderBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class FindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<FindBean.ItemListBeanX> mItemListBeanXES;
    private Context mContext;
    private List<String> mRvInitList;
    private RecyclerView.ItemDecoration mDecoration;

    private enum ITEM_TYPE {
        CATEGORY_HORIZONTAL_CARD,
        CATEGORY_BRIEF_CARD,
        CATEGORY_FOLLOW_VIDEO_SMALL_CARD,
        CATEGORY_R_PROJECT_CARD,
        CATEGORY_VIDEO_WITH_BRIEF,
        CATEGORY_R_TOPIC_CARD,
        CATEGORY_NULL,
    }

    public FindAdapter(Context mContext) {
        this.mContext = mContext;

        mRvInitList = new ArrayList<>();
        mDecoration = ItemDecorations.horizontal(mContext)
                .type(Constants.ALL_VIEW_TAPE, R.drawable.shape_decoration_flush_orange_h_8)
                .last(R.drawable.shape_decoration_flush_orange_w_8)
                .create();
    }

    public void setItemListBeanXES(List<FindBean.ItemListBeanX> mItemListBeanXES) {
        this.mItemListBeanXES = mItemListBeanXES;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int type = ITEM_TYPE.CATEGORY_NULL.ordinal();
        switch (mItemListBeanXES.get(position).getType()) {
            case Constants.HORIZONTAL_CARD:
                type = ITEM_TYPE.CATEGORY_HORIZONTAL_CARD.ordinal();
                break;

            case Constants.TEXT_CARD:
                String typeText = mItemListBeanXES.get(position).getData().getText();
                if (typeText.equals(mContext.getString(R.string.hot_sort))) {
                    type = ITEM_TYPE.CATEGORY_BRIEF_CARD.ordinal();
                } else if (typeText.equals(mContext.getString(R.string.week_ranking))) {
                    type = ITEM_TYPE.CATEGORY_FOLLOW_VIDEO_SMALL_CARD.ordinal();
                } else if (typeText.equals(mContext.getString(R.string.new_author))) {
                    type = ITEM_TYPE.CATEGORY_VIDEO_WITH_BRIEF.ordinal();
                }
                break;

            case Constants.SQUARE_CARD_COLLECTION:
                String squareTitle = mItemListBeanXES.get(position).getData().getHeader().getTitle();
                if (squareTitle.equals(mContext.getString(R.string.recent_project))) {
                    type = ITEM_TYPE.CATEGORY_R_PROJECT_CARD.ordinal();
                } else if (squareTitle.equals(mContext.getString(R.string.recent_topic))) {
                    type = ITEM_TYPE.CATEGORY_R_TOPIC_CARD.ordinal();
                }
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
        } else if (viewType == ITEM_TYPE.CATEGORY_R_PROJECT_CARD.ordinal()) {
            return new BannerRProjectViewHolder(layoutInflater.inflate(R.layout.item_banner, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_R_TOPIC_CARD.ordinal()) {
            return new BannerRTopicViewHolder(layoutInflater.inflate(R.layout.item_banner, parent,
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
        } else if (holder instanceof BannerRProjectViewHolder) {
            initBannerRProject(itemListBeanX, ((BannerRProjectViewHolder) holder));
        } else if (holder instanceof BannerRTopicViewHolder) {
            initBannerRTopic(itemListBeanX, ((BannerRTopicViewHolder) holder));
        } else if (holder instanceof BriefViewHolder) {
            initBrief(position, ((BriefViewHolder) holder));
        } else if (holder instanceof FollowVideoHolder) {
            initFollowVideo(position, ((FollowVideoHolder) holder));
        } else if (holder instanceof VideoBriefViewHolder) {
            initVideoBrief(position, ((VideoBriefViewHolder) holder));
        }
    }

    private void initVideoBrief(int position, VideoBriefViewHolder holder) {
        String typeText = mItemListBeanXES.get(position).getData().getText();
        holder.tvType.setText(typeText);
        HeaderBean headerBean = mItemListBeanXES.get(position + 1).getData().getHeader();
        Utils.displayImage(mContext, headerBean.getIcon(), holder.ivCover,true);
        holder.tvTitle.setText(headerBean.getTitle());
        holder.tvDescription.setText(headerBean.getDescription());
        holder.rvItem.setTag(typeText);
        initBannerRecycleView(holder.rvItem);
        holder.rvItem.setAdapter(new BannerVideoBriefAdapter(mContext, mItemListBeanXES.get(
                position + 1).getData().getItemList()));
    }

    private void initBannerRTopic(FindBean.ItemListBeanX itemListBeanX, BannerRTopicViewHolder
            holder) {
        String title = itemListBeanX.getData().getHeader().getTitle();
        holder.tvType.setText(title);
        holder.rvItem.setTag(title);
        initBannerRecycleView(holder.rvItem);
        holder.rvItem.setAdapter(new BannerAdapter(mContext, itemListBeanX.getData().
                getItemList()));
    }

    private void initBannerRProject(FindBean.ItemListBeanX itemListBeanX, BannerRProjectViewHolder
            holder) {
        String title = itemListBeanX.getData().getHeader().getTitle();
        holder.tvType.setText(title);
        holder.rvItem.setTag(title);
        initBannerRecycleView(holder.rvItem);
        holder.rvItem.setAdapter(new BannerAdapter(mContext, itemListBeanX.getData().
                getItemList()));
    }

    private void initFollowVideo(int position, FollowVideoHolder holder) {
        String typeText = mItemListBeanXES.get(position).getData().getText();
        holder.tvType.setText(typeText);
        holder.rvFollowCard.setLayoutManager(new LinearLayoutManager(mContext));
        holder.rvSmallCard.setLayoutManager(new LinearLayoutManager(mContext));
        holder.rvFollowCard.setAdapter(new FollowCardAdapter(mContext, mItemListBeanXES.get(
                position + 1)));
        holder.rvSmallCard.setAdapter(new SmallCardAdapter(mContext, mItemListBeanXES));
        holder.tvAllCategories.setText(mItemListBeanXES.get(position + 4).getData().getText());
    }

    private void initBrief(int position, BriefViewHolder holder) {
        String typeText = mItemListBeanXES.get(position).getData().getText();
        holder.tvType.setText(typeText);
        holder.rvItem.setLayoutManager(new LinearLayoutManager(mContext));
        holder.rvItem.setAdapter(new BriefAdapter(mContext, mItemListBeanXES));
        holder.tvAllCategories.setText(mItemListBeanXES.get(position + 4).getData().getText());
    }

    private void initBanner(FindBean.ItemListBeanX itemListBeanX, BannerViewHolder holder) {
        holder.tvType.setVisibility(View.GONE);
        holder.rvItem.setTag(Constants.HORIZONTAL_CARD);
        initBannerRecycleView(holder.rvItem);
        holder.rvItem.setAdapter(new BannerAdapter(mContext, itemListBeanX.getData().
                getItemList()));
    }

    private void initBannerRecycleView(RecyclerView recyclerView) {
        if (!mRvInitList.contains((String) recyclerView.getTag())) {
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.
                    HORIZONTAL, false));
            recyclerView.addItemDecoration(mDecoration);
            mRvInitList.add((String) recyclerView.getTag());
        }
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
