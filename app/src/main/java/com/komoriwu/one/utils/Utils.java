package com.komoriwu.one.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.komoriwu.one.application.MyApplication;

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
}
