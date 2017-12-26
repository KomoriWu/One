package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.viewholder.BannerViewHolder;
import com.komoriwu.one.all.fragment.viewholder.BriefViewHolder;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.utils.Constants;
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

    private enum ITEM_TYPE {
        CATEGORY_HORIZONTAL_CARD,
        CATEGORY_BRIEF_CARD,
        CATEGORY_NULL,
    }

    public FindAdapter(Context mContext) {
        this.mContext = mContext;
        mRvInitList = new ArrayList<>();
    }

    public void setItemListBeanXES(List<FindBean.ItemListBeanX> mItemListBeanXES) {
        this.mItemListBeanXES = mItemListBeanXES;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int type;
        switch (mItemListBeanXES.get(position).getType()) {
            case Constants.HORIZONTAL_CARD:
                type = ITEM_TYPE.CATEGORY_HORIZONTAL_CARD.ordinal();
                break;

            case Constants.TEXT_CARD:
                String typeText = mItemListBeanXES.get(position).getData().getText();
                if (typeText.equals(mContext.getString(R.string.hot_sort))) {
                    type = ITEM_TYPE.CATEGORY_BRIEF_CARD.ordinal();
                } else {
                    type = ITEM_TYPE.CATEGORY_NULL.ordinal();
                }
                break;

            default:
                type = ITEM_TYPE.CATEGORY_NULL.ordinal();
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
        }
    }

    private void initBrief(int position, BriefViewHolder holder) {
        String typeText=mItemListBeanXES.get(position).getData().getText();
        holder.tvType.setText(typeText);
        holder.rvItem.setLayoutManager(new LinearLayoutManager(mContext));
        holder.rvItem.setAdapter(new BriefAdapter(mContext, mItemListBeanXES));

        holder.tvAllCategories.setText(mItemListBeanXES.get(position+4).getData().getText());
    }

    private void initBanner(FindBean.ItemListBeanX itemListBeanX, BannerViewHolder holder) {
        if (itemListBeanX.getType().equals(Constants.HORIZONTAL_CARD)) {
            holder.tvType.setVisibility(View.GONE);
            holder.rvItem.setTag(Constants.HORIZONTAL_CARD);
            initBannerRecycleView(holder.rvItem);
            holder.rvItem.setAdapter(new BannerAdapter(mContext, itemListBeanX.getData().
                    getItemList()));

        }
    }

    private void initBannerRecycleView(RecyclerView recyclerView) {
        if (!mRvInitList.contains((String) recyclerView.getTag())) {
            RecyclerView.ItemDecoration decoration = ItemDecorations.horizontal(mContext)
                    .type(Constants.ALL_VIEW_TAPE, R.drawable.shape_decoration_flush_orange_h_8)
                    .last(R.drawable.shape_decoration_flush_orange_w_8)
                    .create();
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.
                    HORIZONTAL, false));
            recyclerView.addItemDecoration(decoration);
            mRvInitList.add((String) recyclerView.getTag());
        }
    }


    @Override
    public int getItemCount() {
        return mItemListBeanXES == null ? 0 : mItemListBeanXES.size();
    }

    class NullViewHolder extends RecyclerView.ViewHolder{

        public NullViewHolder(View itemView) {
            super(itemView);
        }
    }

}
