package com.komoriwu.one.one;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.application.MyApplication;
import com.komoriwu.one.model.bean.OneListBean;
import com.komoriwu.one.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-11-06.
 */

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.OneViewHolder> {
    private OneListBean mOneListBean;
    private Context mContext;

    public OneAdapter(OneListBean mOneListBean, Context mContext) {
        this.mOneListBean = mOneListBean;
        this.mContext = mContext;
    }

    @Override
    public OneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_one, parent,
                false);
        return new OneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OneViewHolder holder, int position) {
        OneListBean.ContentListBean contentListBean=mOneListBean.getContent_list().get(position);
        holder.tvCategory.setText(contentListBean.getCategory());
        holder.tvTitle.setText(contentListBean.getTitle());
        holder.tvUserName.setText(contentListBean.getAuthor().getUserName());
//        Utils.displayImage(mContext,contentListBean.getImg_url(),holder.ivCover);
        MyApplication.getImageLoader(mContext).displayImage(contentListBean.getImg_url(), holder.
                ivCover);
        holder.tvForward.setText(contentListBean.getForward());
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
        public OneViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
