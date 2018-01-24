package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.listener.OnItemBannerClickListener;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.ImageLoader;
import com.komoriwu.one.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    private Context mContext;
    private List<ItemListBean> itemList;
    private boolean isOpenAnim;
    private OnItemBannerClickListener mOnItemBannerClickListener;

    BannerAdapter(Context mContext, List<ItemListBean> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    public void setOnItemBannerClickListener(OnItemBannerClickListener mOnItemBannerClickListener) {
        this.mOnItemBannerClickListener = mOnItemBannerClickListener;
    }

    public BannerAdapter(Context mContext, List<ItemListBean> itemList, boolean isOpenAnim) {
        this.mContext = mContext;
        this.itemList = itemList;
        this.isOpenAnim = isOpenAnim;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return Constants.FIRST_VIEW_TAPE;
        } else {
            return Constants.ALL_VIEW_TAPE;
        }
    }

    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view;
        if (viewType == Constants.FIRST_VIEW_TAPE) {
            view = layoutInflater.inflate(R.layout.item_banner_card_divider, parent,
                    false);
        } else {
            view = layoutInflater.inflate(R.layout.item_banner_card, parent,
                    false);
        }
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BannerViewHolder holder, int position) {
        ItemListBean itemListBean = itemList.get(position);
        ImageLoader.displayImage(mContext, itemListBean.getData().getImage(), holder.ivCard);
        if (itemListBean.getData().getLabel() != null) {
            if (TextUtils.isEmpty(itemListBean.getData().getLabel().getText())) {
                holder.tvAd.setVisibility(View.GONE);
            } else {
                holder.tvAd.setVisibility(View.VISIBLE);
                holder.tvAd.setText(itemListBean.getData().getLabel().getText());
            }
        } else {
            holder.tvAd.setVisibility(View.GONE);
        }
        if (isOpenAnim) {
            Utils.startAnimation(mContext, holder.ivCard);
        }
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    class BannerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_card)
        ImageView ivCard;
        @BindView(R.id.tv_ad)
        TextView tvAd;

        BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemBannerClickListener != null) {
                mOnItemBannerClickListener.onItemBannerClick(itemList.get(getAdapterPosition()).
                        getData().getActionUrl());
            }
        }
    }
}
