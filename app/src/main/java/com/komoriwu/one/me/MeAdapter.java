package com.komoriwu.one.me;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-06.
 */

public class MeAdapter extends BaseQuickAdapter<VideoBean.ItemListBeanX,MeAdapter.MeViewHolder> {
    private Context mContext;
    private List<VideoBean.ItemListBeanX> mItemList;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(VideoBean.ItemListBeanX position);
    }

    public MeAdapter(Context mContext, OnItemClickListener mOnItemClickListener) {
        super(R.layout.item_all_video);
        this.mContext = mContext;
        this.mOnItemClickListener = mOnItemClickListener;
    }


    public void addVideoListData(List<VideoBean.ItemListBeanX> itemList, boolean isFirst) {
        int index =getItemCount();
        if (isFirst) {
            this.mItemList = itemList;
        } else {
            this.mItemList.addAll(itemList);
        }
//        notifyDataSetChanged();
        //局部刷新
        for (int i = index; i <  this.mItemList.size(); i++) {
            notifyItemInserted(i);
        }
        setNewData(mItemList);
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void convert(MeViewHolder viewHolder, VideoBean.ItemListBeanX listBeanX) {
            Utils.displayImage(mContext, listBeanX.getData().getCover().getFeed(),
                    viewHolder.ivCover);
            if (listBeanX.getData().getAuthor() != null) {
                Utils.displayImage(mContext, listBeanX.getData().getAuthor().getIcon(),
                        viewHolder.ivAuthor, true);
                viewHolder.tvAuthor.setText(listBeanX.getData().getAuthor().getName() + " / " +
                        Utils.durationFormat((long) listBeanX.getData().getDuration()));
            }
            viewHolder.tvTitle.setText(listBeanX.getData().getTitle());

    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();

    }

    class MeViewHolder extends BaseViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.iv_author)
        ImageView ivAuthor;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_author)
        TextView tvAuthor;

        public MeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(mItemList.get(getAdapterPosition()));
            }
        }
    }
}
