package com.komoriwu.one.utils;

import android.os.Environment;

import com.komoriwu.one.application.MyApplication;

import java.io.File;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class Constants {
    //path
    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().
            getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";
    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().
            getAbsolutePath() + File.separator + "One";

    public static final long CACHE_SIZE = 50 * 1024 * 1024;
    public static final int CATEGORY_REPORTER=0;
    public static final int CATEGORY_MUSIC=4;
    public static final int CATEGORY_MOVIE=5;
    public static final int CATEGORY_RADIO=8;
}
