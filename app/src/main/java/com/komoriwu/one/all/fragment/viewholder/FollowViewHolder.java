package com.komoriwu.one.all.fragment.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.widget.DCTextView;
import com.komoriwu.one.widget.FZTextView;

/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public class FollowViewHolder extends RecyclerView.ViewHolder {
    public ImageView ivCardCover;
    public ImageView ivCover;
    public FZTextView tvTitle;
    public FZTextView tvDescription;
    public DCTextView tvTime;

    public FollowViewHolder(View itemView) {
        super(itemView);
        ivCardCover = itemView.findViewById(R.id.iv_card_cover);
        tvTime = itemView.findViewById(R.id.tv_time);
        ivCover = itemView.findViewById(R.id.iv_cover);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvDescription = itemView.findViewById(R.id.tv_description);

    }
}