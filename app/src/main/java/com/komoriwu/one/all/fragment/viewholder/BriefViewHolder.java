package com.komoriwu.one.all.fragment.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.widget.FZTextView;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class BriefViewHolder extends RecyclerView.ViewHolder {
    public ImageView ivCover;
    public ImageView ivRight;
    public FZTextView tvTitle;
    public  FZTextView tvDescription;
    public Button btnFocus;
    public BriefViewHolder(View itemView) {
        super(itemView);
        ivCover=itemView.findViewById(R.id.iv_cover);
        ivRight=itemView.findViewById(R.id.iv_right);
        tvTitle=itemView.findViewById(R.id.tv_title);
        tvDescription=itemView.findViewById(R.id.tv_description);
        btnFocus=itemView.findViewById(R.id.btn_focus);
    }
}