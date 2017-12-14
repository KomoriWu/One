package com.komoriwu.one.all.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-14.
 */

public class FindScrollAdapter extends RecyclerView.Adapter<FindScrollAdapter.FindScrollViewHolder> {
    private Context mContext;
    private List<ItemListBean> mItemList;

    public FindScrollAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setRvScrollData(List<ItemListBean> mItemList) {
        this.mItemList = mItemList;
        notifyDataSetChanged();
    }

    @Override
    public FindScrollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_scroll_card, parent,
                false);
        return new FindScrollViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FindScrollViewHolder holder, int position) {
        ItemListBean itemListBean = mItemList.get(position);
        Utils.displayImage(mContext, itemListBean.getData().getImage(), holder.ivCard);
        if (TextUtils.isEmpty(itemListBean.getData().getLabel().getText())) {
            holder.tvAd.setVisibility(View.GONE);
        } else {
            holder.tvAd.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class FindScrollViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_card)
        ImageView ivCard;
        @BindView(R.id.tv_ad)
        TextView tvAd;

        public FindScrollViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
