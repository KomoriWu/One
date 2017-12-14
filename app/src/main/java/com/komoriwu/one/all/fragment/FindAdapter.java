package com.komoriwu.one.all.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.FindViewHolder> {
    private Context mContext;
    private List<ItemListBean> mItemList;

    public FindAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setRvScrollData(List<ItemListBean> mItemList) {
        this.mItemList = mItemList;
        notifyDataSetChanged();
    }

    @Override
    public FindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card, parent,
                false);
        return new FindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FindViewHolder holder, int position) {
        ItemListBean itemListBean = mItemList.get(position);
        Utils.displayImage(mContext, itemListBean.getData().getImage(), holder.ivCard);
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class FindViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_card)
        ImageView ivCard;

        public FindViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
