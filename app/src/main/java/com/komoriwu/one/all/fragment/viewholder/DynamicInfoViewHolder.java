package com.komoriwu.one.all.fragment.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.widget.FZTextView;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017-12-27.
 */

public class DynamicInfoViewHolder extends RecyclerView.ViewHolder {
    public ImageView ivHead;
    public FZTextView tvUserName;
    public FZTextView tvMessage;
    public ImageView ivCover;
    public FZTextView tvTitle;
    public FZTextView tvDescription;
    public FZTextView tvLikeNum;
    public FZTextView tvTime;

    public DynamicInfoViewHolder(View itemView) {
        super(itemView);
        ivHead = itemView.findViewById(R.id.iv_head);
        tvUserName = itemView.findViewById(R.id.tv_user_name);
        tvMessage = itemView.findViewById(R.id.tv_message);
        ivCover = itemView.findViewById(R.id.iv_cover);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvDescription = itemView.findViewById(R.id.tv_description);
        tvLikeNum = itemView.findViewById(R.id.tv_like_num);
        tvTime = itemView.findViewById(R.id.tv_time);
    }
}