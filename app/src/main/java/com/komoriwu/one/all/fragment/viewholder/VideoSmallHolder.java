package com.komoriwu.one.all.fragment.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.widget.DCTextView;
import com.komoriwu.one.widget.FZTextView;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class VideoSmallHolder extends RecyclerView.ViewHolder {
    public  DCTextView tvTime;
    public ImageView ivCover;
    public FZTextView tvTitle;
    public  FZTextView tvDescription;
    public VideoSmallHolder(View itemView) {
        super(itemView);
        tvTime = itemView.findViewById(R.id.tv_time);
        ivCover=itemView.findViewById(R.id.iv_cover);
        tvTitle=itemView.findViewById(R.id.tv_title);
        tvDescription=itemView.findViewById(R.id.tv_description);
    }
}