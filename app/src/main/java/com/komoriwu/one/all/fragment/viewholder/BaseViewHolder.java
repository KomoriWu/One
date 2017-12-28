package com.komoriwu.one.all.fragment.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.komoriwu.one.R;
import com.komoriwu.one.widget.FZTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    public RecyclerView rvItem;


    public BaseViewHolder(View itemView) {
        super(itemView);
        rvItem = itemView.findViewById(R.id.rv_item);
    }

}