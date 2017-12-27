package com.komoriwu.one.all.fragment.viewholder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.widget.FZTextView;

/**
 * Created by KomoriWu
 * on 2017-12-27.
 */

public class VideoBriefViewHolder extends BaseViewHolder {
    public ImageView ivCover;
    public FZTextView tvTitle;
    public FZTextView tvDescription;
    public Button btnFocus;

    public VideoBriefViewHolder(View itemView) {
        super(itemView);
        ivCover = itemView.findViewById(R.id.iv_cover);
        tvTitle = itemView.findViewById(R.id.tv_title);
        tvDescription = itemView.findViewById(R.id.tv_description);
        btnFocus = itemView.findViewById(R.id.btn_focus);
    }
}