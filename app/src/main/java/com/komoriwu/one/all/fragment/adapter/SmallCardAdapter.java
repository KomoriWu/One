package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.komoriwu.one.R;
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
 * on 2017-12-15.
 */

public class SmallCardAdapter extends RecyclerView.Adapter<SmallCardAdapter.FindSmallCardViewHolder> {
    private Context mContext;
    private List<FindBean.ItemListBeanX> mItemList;

    public SmallCardAdapter(Context mContext) {
        this.mContext = mContext;
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
        Utils.displayImage(mContext, itemListBean.getData().getCover().getFeed(), holder.ivCover);
        holder.tvTitle.setText(itemListBean.getData().getTitle());
        holder.tvDescription.setText(String.format(mContext.getString(R.string.small_description),
                itemListBean.getData().getCategory(), itemListBean.getData().getAuthor().getName()));
        holder.tvTime.setText(Utils.durationFormat(itemListBean.getData().getDuration()));
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class FindSmallCardViewHolder extends RecyclerView.ViewHolder {
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
        }
    }
}
