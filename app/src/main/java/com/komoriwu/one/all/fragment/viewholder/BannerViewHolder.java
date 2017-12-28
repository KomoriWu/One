package com.komoriwu.one.all.fragment.viewholder;

import android.view.View;

import com.komoriwu.one.R;
import com.komoriwu.one.widget.DCTextView;
import com.komoriwu.one.widget.FZTextView;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class BannerViewHolder extends BaseViewHolder {
    public FZTextView tvHeader;
    public DCTextView tvSubtitle;

    public BannerViewHolder(View itemView) {
        super(itemView);
        tvHeader = itemView.findViewById(R.id.tv_header);
        tvSubtitle = itemView.findViewById(R.id.tv_subtitle);
    }
}