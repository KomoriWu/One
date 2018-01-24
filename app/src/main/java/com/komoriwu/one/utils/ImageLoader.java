package com.komoriwu.one.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;
import com.komoriwu.one.R;
import com.komoriwu.one.application.GlideApp;
import com.komoriwu.one.application.GlideOptions;
import com.komoriwu.one.widget.GlideCircleTransform;

import jp.wasabeef.glide.transformations.ColorFilterTransformation;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by KomoriWu
 * on 2018-01-24.
 */

public class ImageLoader {
    public static void displayImage(Context context, String uri, ImageView imageView) {
        displayImage(context, uri, imageView, false, false);
    }

    public static void displayImage(Context context, String uri, ImageView imageView,
                                    boolean isCircle) {
        displayImage(context, uri, imageView, isCircle, false);
    }

    public static void displayImage(Context context, String uri, ImageView imageView, int color) {
        GlideApp.with(context).asDrawable()
                .load(uri)
                .thumbnail(0.1f)
                .placeholder(new ColorDrawable(context.getResources().getColor(R.color.
                        detail_bg2)))
                .transition(withCrossFade())
                .apply(RequestOptions.bitmapTransform(new ColorFilterTransformation(color)))
                .into(imageView);
    }

    public static void displayImage(Context context, String uri, ImageView imageView, boolean
            isCircle, int defaultIconId) {
        GlideApp.with(context).asDrawable()
                .load(uri)
                .thumbnail(0.1f)
                .placeholder(defaultIconId)
                .error(defaultIconId)
                .transition(withCrossFade())
                .into(imageView);
    }

    public static void displayImage(Context context, String uri, ImageView imageView, boolean
            isCircle, boolean border) {

        if (isCircle) {
            if (border) {
                GlideApp.with(context).asDrawable()
                        .load(uri)
                        .thumbnail(0.1f)
                        .transition(withCrossFade())
                        .apply(GlideOptions.circleCropTransform())
                        .transform(new GlideCircleTransform(context))
                        .into(imageView);
            } else {
                GlideApp.with(context).asDrawable()
                        .load(uri)
                        .thumbnail(0.1f)
                        .transition(withCrossFade())
                        .apply(GlideOptions.circleCropTransform())
                        .into(imageView);
            }

        } else {
            GlideApp.with(context).asDrawable()
                    .load(uri)
//                    .override(width, height)
                    .thumbnail(0.1f)
                    .placeholder(new ColorDrawable(context.getResources().getColor(R.color.
                            detail_bg2)))
//                    .transition(GenericTransitionOptions.with(R.anim.item_alpha))
                    .transition(withCrossFade())
                    .into(imageView);
        }
    }
}
