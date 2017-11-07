package com.komoriwu.one.one;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-11-06.
 */

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.OneViewHolder> {
    private OneListBean mOneListBean;
    private OneListBean.ContentListBean mContentListBean;
    private Context mContext;

    private enum ITEM_TYPE {
        CATEGORY_COMMON,
        CATEGORY_REPORTER,
        CATEGORY_MUSIC,
        CATEGORY_RADIO
    }

    public OneAdapter(OneListBean mOneListBean, Context mContext) {
        this.mOneListBean = mOneListBean;
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position) {
        mContentListBean = mOneListBean.getContent_list().get(position);
        int type;
        switch (Integer.parseInt(mContentListBean.getCategory())) {
            case Constants.CATEGORY_REPORTER:
                type = ITEM_TYPE.CATEGORY_REPORTER.ordinal();
                break;
            case Constants.CATEGORY_MUSIC:
                type = ITEM_TYPE.CATEGORY_MUSIC.ordinal();
                break;
            case Constants.CATEGORY_RADIO:
                type = ITEM_TYPE.CATEGORY_RADIO.ordinal();
                break;
            default:
                type = ITEM_TYPE.CATEGORY_COMMON.ordinal();
                break;
        }
        return type;
    }

    @Override
    public OneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        if (viewType == ITEM_TYPE.CATEGORY_REPORTER.ordinal()) {
            return new OneViewHolder(layoutInflater.inflate(R.layout.item_one_reported, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_MUSIC.ordinal()) {
            return new OneViewHolder(layoutInflater.inflate(R.layout.item_one_common, parent,
                    false));
        } else if (viewType == ITEM_TYPE.CATEGORY_RADIO.ordinal()) {
            return new OneViewHolder(layoutInflater.inflate(R.layout.item_one_common, parent,
                    false));
        } else {
            return new OneViewHolder(layoutInflater.inflate(R.layout.item_one_common, parent,
                    false));
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(OneViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM_TYPE.CATEGORY_REPORTER.ordinal()) {
            holder.tvCategory.setText(mContentListBean.getTitle() + " | " + mContentListBean.
                    getPic_info());
            holder.tvUserName.setText(mContentListBean.getWords_info().trim());
        } else {
            holder.tvCategory.setText(String.format(mContext.getString(R.string.category),
                    mContentListBean.getShareList().getWx().getTitle().split("\\|")[0].trim()));
            holder.tvUserName.setText(mContentListBean.getAnswerer() == null ? mContentListBean.
                    getShareList().getWx().getDesc().split(" ")[0].trim() : String.format(mContext.
                    getString(R.string.answerer), mContentListBean.getAnswerer().getUserName()));
            holder.tvPostDate.setText(Utils.showDate(mContext, mContentListBean.getPostDate()));
        }

        holder.tvTitle.setText(mContentListBean.getTitle());
        Utils.displayImage(mContext, mContentListBean.getImgUrl(), holder.ivCover);
        holder.tvForward.setText(mContentListBean.getForward());
        holder.tvLikeNum.setText(String.valueOf(mContentListBean.getLikeCount()));
    }

    @Override
    public int getItemCount() {
        return mOneListBean == null ? 0 : mOneListBean.getContent_list().size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_category)
        TextView tvCategory;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_user_name)
        TextView tvUserName;
        @BindView(R.id.iv_cover)
        ImageView ivCover;
        @BindView(R.id.tv_forward)
        TextView tvForward;
        @BindView(R.id.tv_post_date)
        TextView tvPostDate;
        @BindView(R.id.iv_share)
        ImageView ivShare;
        @BindView(R.id.iv_like)
        ImageView ivLike;
        @BindView(R.id.tv_like_num)
        TextView tvLikeNum;

        public OneViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
