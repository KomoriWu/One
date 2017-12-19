package com.komoriwu.one.all.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.ContentBean;
import com.komoriwu.one.model.bean.DataBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.FZTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-19.
 */


public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.TagsViewHolder> {
    private Context mContext;
    private List<DataBean.TagsBean> mItemList;

    public TagsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setRvData(List<DataBean.TagsBean> mItemList) {
        this.mItemList = mItemList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return Constants.ALL_VIEW_TAPE;
    }

    @Override
    public TagsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tags_card, parent,
                false);
        return new TagsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TagsViewHolder holder, int position) {
       DataBean.TagsBean tagsBean = mItemList.get(position);
        Utils.displayImage(mContext, tagsBean.getBgPicture(), holder.ivCard);
        holder.tvTitle.setText(String.format(mContext.getString(R.string.tags), tagsBean.getName()));
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class TagsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_card)
        ImageView ivCard;
        @BindView(R.id.tv_title)
        FZTextView tvTitle;

        public TagsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
