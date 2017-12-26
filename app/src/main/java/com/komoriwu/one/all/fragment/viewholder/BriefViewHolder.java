package com.komoriwu.one.all.fragment.viewholder;

import android.view.View;

import com.komoriwu.one.R;
import com.komoriwu.one.widget.FZTextView;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class BriefViewHolder extends BaseViewHolder {
    public FZTextView tvAllCategories;

    public BriefViewHolder(View itemView) {
        super(itemView);
        tvAllCategories = itemView.findViewById(R.id.tv_all_categories);
    }
}