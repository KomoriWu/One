package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.DCTextView;
import com.komoriwu.one.widget.FZTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class SmallCardAdapter extends RecyclerView.Adapter<SmallCardAdapter.FindSmallCardViewHolder> {
    private Context mContext;
    private List<FindBean.ItemListBeanX> mItemList;
    private OnItemClickListener mOnItemClickListener;
    private boolean mIsDetail;

    public SmallCardAdapter(Context mContext, OnItemClickListener mOnItemClickListener) {
        this.mContext = mContext;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public SmallCardAdapter(Context mContext, List<FindBean.ItemListBeanX> mItemList) {
        this.mContext = mContext;
        setSmallCardData(mItemList);
    }

    public void setIsDetail(boolean isDetail) {
        this.mIsDetail = isDetail;
    }

    public void setSmallCardData(List<FindBean.ItemListBeanX> mItemList) {
        this.mItemList = new ArrayList<>();
        for (FindBean.ItemListBeanX itemListBeanX : mItemList) {
            if (itemListBeanX.getType().equals(Constants.VIDEO_SMALL_CARD)) {
                this.mItemList.add(itemListBeanX);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public FindSmallCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_small_card, parent,
                false);
        return new FindSmallCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FindSmallCardViewHolder holder, int position) {
        FindBean.ItemListBeanX itemListBean = mItemList.get(position);
        Utils.displayImage(mContext, itemListBean.getData().getCover().getFeed(), holder.ivCover,
                false,300,200);
        holder.tvTime.setText(Utils.durationFormat(itemListBean.getData().getDuration()));
        holder.tvTitle.setText(itemListBean.getData().getTitle());
        if (mIsDetail) {
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.tvDescription.setTextColor(mContext.getResources().getColor(R.color.line_color));
            holder.tvDescription.setText(String.format(mContext.getString(R.string.category1),
                    itemListBean.getData().getCategory()));
        } else {
            holder.tvDescription.setText(String.format(mContext.getString(R.string.small_description),
                    itemListBean.getData().getCategory(), itemListBean.getData().getAuthor().getName()));
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.item_alpha);
        animation.setFillAfter(true);
        holder.ivCover.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class FindSmallCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_time)
        DCTextView tvTime;
        @BindView(R.id.tv_title)
        FZTextView tvTitle;
        @BindView(R.id.tv_description)
        FZTextView tvDescription;

        public FindSmallCardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onVideoCardItemClick(mItemList.get(getAdapterPosition()));
            }
        }
    }
}
