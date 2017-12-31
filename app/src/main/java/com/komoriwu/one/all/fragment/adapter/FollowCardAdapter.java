package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.all.listener.OnItemClickListener;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.DCTextView;
import com.komoriwu.one.widget.FZTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class FollowCardAdapter extends RecyclerView.Adapter<FollowCardAdapter.FollowCardViewHolder> {
    private Context mContext;
    private List<ItemListBean> mItemList;
    private OnItemClickListener mOnItemClickListener;
    private boolean isOpenAnim;

    public FollowCardAdapter(Context mContext, List<ItemListBean> mItemList) {
        this.mContext = mContext;
        this.mItemList = mItemList;
    }

    public FollowCardAdapter(Context mContext, List<ItemListBean> itemListBeanX, boolean isOpenAnim) {
        this.mContext = mContext;
        this.mItemList = itemListBeanX;
        this.isOpenAnim = isOpenAnim;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
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
    public FollowCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view;
        if (viewType == Constants.FIRST_VIEW_TAPE) {
            view = layoutInflater.inflate(R.layout.item_follow_card_divider, parent,
                    false);
        } else {
            view = layoutInflater.inflate(R.layout.item_follow_card, parent,
                    false);
        }
        return new FollowCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FollowCardViewHolder holder, int position) {
        ItemListBean itemListBean = mItemList.get(position);
        if (itemListBean.getData().getContent()!=null){
        Utils.displayImage(mContext, itemListBean.getData().getContent().getData().getCover().
                getFeed(), holder.ivCardCover);
        holder.tvTitle.setText(itemListBean.getData().getContent().getData().getTitle());
        }
        holder.tvDescription.setText(itemListBean.getData().getHeader().getDescription());
        holder.tvDescription.setText(String.format(mContext.getString(R.string.follow_description),
                itemListBean.getData().getContent().getData().getAuthor().getName(),
                itemListBean.getData().getContent().getData().getCategory()));
        holder.tvTime.setText(Utils.durationFormat(itemListBean.getData().getContent().getData().
                getDuration()));
        Utils.displayImage(mContext, itemListBean.getData().getHeader().getIcon(), holder.ivCover,
                true);

        if (isOpenAnim) {
            Utils.startAnimation(mContext, holder.ivCardCover);
            Utils.startAnimation(mContext, holder.ivCover);
        }
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    class FollowCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_card_cover)
        ImageView ivCardCover;
        @BindView(R.id.tv_time)
        DCTextView tvTime;
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_title)
        FZTextView tvTitle;
        @BindView(R.id.tv_description)
        FZTextView tvDescription;

        public FollowCardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onAllItemClick(mItemList.get(getAdapterPosition()));
            }
        }
    }
}