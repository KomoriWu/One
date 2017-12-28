package com.komoriwu.one.all.fragment.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.komoriwu.one.R;

/**
 * Created by KomoriWu
 * on 2017-12-26.
 */

public class BannerSingleViewHolder extends RecyclerView.ViewHolder {
    public ImageView ivCard;

    public BannerSingleViewHolder(View itemView) {
        super(itemView);
        ivCard = itemView.findViewById(R.id.iv_card);
    }
}