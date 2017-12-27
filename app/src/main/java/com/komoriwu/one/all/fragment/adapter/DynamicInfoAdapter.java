package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-27.
 */

public class DynamicInfoAdapter extends RecyclerView.Adapter<DynamicInfoAdapter.FindHotSortViewHolder> {
    private Context mContext;
    private List<FindBean.ItemListBeanX> mItemList;


    public DynamicInfoAdapter(Context mContext, List<FindBean.ItemListBeanX> mItemList) {
        this.mContext = mContext;
        setHotSortData(mItemList);
    }

    public void setHotSortData(List<FindBean.ItemListBeanX> mItemList) {
        this.mItemList = new ArrayList<>();
        for (FindBean.ItemListBeanX itemListBeanX : mItemList) {
            if (itemListBeanX.getType().equals(Constants.DYNAMIC_INFO_CARD)) {
                this.mItemList.add(itemListBeanX);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public FindHotSortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_dynamic_info_card, parent,
                false);
        return new FindHotSortViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FindHotSortViewHolder holder, int position) {
        FindBean.ItemListBeanX itemListBean = mItemList.get(position);
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

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class FindHotSortViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_head)
        ImageView ivHead;
        @BindView(R.id.tv_user_name)
        FZTextView tvUserName;
        @BindView(R.id.tv_message)
        FZTextView tvMessage;
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_title)
        FZTextView tvTitle;
        @BindView(R.id.tv_description)
        FZTextView tvDescription;
        @BindView(R.id.tv_like_num)
        FZTextView tvLikeNum;
        @BindView(R.id.tv_time)
        FZTextView tvTime;

        public FindHotSortViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
