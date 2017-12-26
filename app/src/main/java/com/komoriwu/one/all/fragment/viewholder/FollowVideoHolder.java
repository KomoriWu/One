package com.komoriwu.one.all.fragment.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.komoriwu.one.R;
import com.komoriwu.one.widget.FZTextView;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class FollowVideoHolder extends RecyclerView.ViewHolder {
    public FZTextView tvType;
    public RecyclerView rvFollowCard;
    public RecyclerView rvSmallCard;
    public FZTextView tvAllCategories;

    public FollowVideoHolder(View itemView) {
        super(itemView);
        tvType = itemView.findViewById(R.id.tv_type);
        rvFollowCard = itemView.findViewById(R.id.rv_follow_card);
        rvSmallCard = itemView.findViewById(R.id.rv_small_card);
        tvAllCategories = itemView.findViewById(R.id.tv_all_categories);
    }
}