package com.komoriwu.one.all.fragment.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.komoriwu.one.R;
import com.komoriwu.one.widget.FZTextView;

/**
 * Created by KomoriWu
 * on 2017-12-28.
 */

public class TextCardViewHolder extends RecyclerView.ViewHolder {
    public FZTextView tvHeader;
    public FZTextView tvFooter;

    public TextCardViewHolder(View itemView) {
        super(itemView);
        tvHeader = itemView.findViewById(R.id.tv_header);
        tvFooter = itemView.findViewById(R.id.tv_footer);
    }

}