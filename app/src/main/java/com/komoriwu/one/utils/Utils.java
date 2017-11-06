package com.komoriwu.one.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.ImageView;

import com.komoriwu.one.R;
import com.komoriwu.one.application.MyApplication;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class Utils {
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getInstance().
                getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    public static DisplayImageOptions getImageOptions(int defaultIconId, int cornerRadiusPixels) {
        return new DisplayImageOptions.Builder()
                .displayer(new RoundedBitmapDisplayer(cornerRadiusPixels))
                .showImageOnLoading(defaultIconId)
                .showImageOnFail(defaultIconId)
                .showImageForEmptyUri(defaultIconId)
                .cacheInMemory(true)
                .cacheOnDisc()
                .build();
    }

    public static DisplayImageOptions getImageOptions() {
        return getImageOptions(R.mipmap.ic_launcher_round, 0);
    }

    public static void displayImage(Context context, String uri, ImageView imageView) {
        MyApplication.getImageLoader(context).displayImage(uri, imageView, getImageOptions());
    }

    public static void displayImage(Context context, String uri, ImageView imageView,
                                    DisplayImageOptions displayImageOptions) {
        MyApplication.getImageLoader(context).displayImage(uri, imageView, displayImageOptions);
    }

}
