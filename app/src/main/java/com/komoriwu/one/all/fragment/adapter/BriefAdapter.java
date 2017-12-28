package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class BriefAdapter extends RecyclerView.Adapter<BriefAdapter.FindHotSortViewHolder> {
    private Context mContext;
    private List<ItemListBean> mItemList;


    public BriefAdapter(Context mContext, List<ItemListBean> mItemList) {
        this.mContext = mContext;
        setHotSortData(mItemList);
    }

    public void setHotSortData(List<ItemListBean> mItemList) {
        this.mItemList = new ArrayList<>();
        for (ItemListBean itemListBeanX : mItemList) {
            if (itemListBeanX.getType().equals(Constants.BRIEF_CARD)) {
                this.mItemList.add(itemListBeanX);
            }
        }
    }

    @Override
    public FindHotSortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_brief_card, parent,
                false);
        return new FindHotSortViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FindHotSortViewHolder holder, int position) {
        ItemListBean itemListBean = mItemList.get(position);
        Utils.displayImage(mContext, itemListBean.getData().getIcon(), holder.ivCover);
        holder.tvTitle.setText(itemListBean.getData().getTitle());
        holder.tvDescription.setText(itemListBean.getData().getDescription());
        Utils.startAnimation(mContext, holder.ivCover);
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class FindHotSortViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_title)
        FZTextView tvTitle;
        @BindView(R.id.tv_description)
        FZTextView tvDescription;

        public FindHotSortViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
