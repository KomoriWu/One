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
    public static final int MOVIE_VIEW_PAGE_SIZE = 10000;
    public static final int CATEGORY_REPORTER = 0;
    public static final int CATEGORY_MUSIC = 4;
    public static final int CATEGORY_MOVIE = 5;
    public static final int CATEGORY_ADVERTISE = 6;
    public static final int CATEGORY_RADIO = 8;
    public static final String ILLUSTRATION = "插画";

    public static final String ONE_LIST_BEAN = "OneListBean";
    public static final String ONE_DETAIL_CSS = "http://resource.wufazhuce.com/one.css?v=4.3.1";
    public static final String ONE_DETAIL_JS1 = "http://resource.wufazhuce.com/one-zepto.min.js";
    public static final String ONE_DETAIL_JS2 = "http://resource.wufazhuce.com/one-vue.min.js";
    public static final String ONE_DETAIL_JS3 = "http://resource.wufazhuce.com/one-webview.js?v=4.3.1";

    public static final String VIDEO_TYPE = "horizontalScrollCard";
    public static final String VIDEO_DATA_TYPE = "VideoBeanForClient";

    //item type
    public static final String HORIZONTAL_CARD = "horizontalScrollCard";
    public static final String BRIEF_CARD = "briefCard";
    public static final String TEXT_CARD = "textCard";
    public static final String FOLLOW_CARD = "followCard";
    public static final String VIDEO_SMALL_CARD = "videoSmallCard";
    public static final String SQUARE_CARD_COLLECTION = "squareCardCollection";
    public static final String VIDEO_HORIZONTAL_CARD = "videoCollectionOfHorizontalScrollCard";
    public static final String VIDEO_WITH_BRIEF = "videoCollectionWithBrief";
    public static final String DYNAMIC_INFO_CARD = "DynamicInfoCard";
    public static final String BANNER = "banner";
    public static final String BANNER3 = "banner3";
    public static final String SQUARE_CARD = "squareCard";

    //font
    public static final String BIG_BOLD = "bigBold";
    public static final String BOLD = "bold";
    public static final String NORMAL = "normal";

    //textCard type
    public static final String HEADER5 = "header5";
    public static final String HEADER2 = "header2";
    public static final String FOOTER2 = "footer2";
    public static final String FOOTER1 = "footer1";

    public static final int FIRST_VIEW_TAPE = 0;
    public static final int ALL_VIEW_TAPE = 1;

    public static final String ITEM_LIST_BEAN_X = "ItemListBeanX";

    //query
    public static final String DATE = "date";
    public static final String NUM = "num";
    public static final String PAGE = "page";
    public static final String START = "start";
    public static final String ID = "id";
    public static final String QUERY = "query";

    //intent
    public static final int TO_VIDEO_CARD_ACTIVITY = 100;

    public static final String URL = "url";
    public static final String EYEPETIZER = "eyepetizer://webview/";

    public static final String GIT_HUB = "https://github.com/KomoriWu";

    //path
    public static final String DROID_LOGO = "M 149.22,22.00\n" +
            "           C 148.23,20.07 146.01,16.51 146.73,14.32\n" +
            "             148.08,10.21 152.36,14.11 153.65,16.06\n" +
            "             153.65,16.06 165.00,37.00 165.00,37.00\n" +
            "             194.29,27.24 210.71,27.24 240.00,37.00\n" +
            "             240.00,37.00 251.35,16.06 251.35,16.06\n" +
            "             252.64,14.11 256.92,10.21 258.27,14.32\n" +
            "             258.99,16.51 256.77,20.08 255.78,22.00\n" +
            "             252.53,28.28 248.44,34.36 246.00,41.00\n" +
            "             252.78,43.16 258.78,48.09 263.96,52.85\n" +
            "             281.36,68.83 289.00,86.62 289.00,110.00\n" +
            "             289.00,110.00 115.00,110.00 115.00,110.00\n" +
            "             115.00,110.00 117.66,91.00 117.66,91.00\n" +
            "             120.91,76.60 130.30,62.72 141.04,52.85\n" +
            "             146.22,48.09 152.22,43.16 159.00,41.00\n" +
            "             159.00,41.00 149.22,22.00 149.22,22.00 Z\n" +
            "           M 70.80,56.00\n" +
            "           C 70.80,56.00 97.60,100.00 97.60,100.00\n" +
            "             101.34,106.21 108.32,116.34 110.21,123.00\n" +
            "             113.76,135.52 103.90,147.92 91.00,147.92\n" +
            "             78.74,147.92 74.44,139.06 69.00,130.00\n" +
            "             69.00,130.00 39.80,82.00 39.80,82.00\n" +
            "             35.73,75.29 28.40,66.08 29.20,58.00\n" +
            "             30.26,47.20 38.61,40.47 49.00,39.72\n" +
            "             61.22,40.24 64.96,46.28 70.80,56.00 Z\n" +
            "           M 375.80,58.00\n" +
            "           C 376.60,66.08 369.27,75.29 365.20,82.00\n" +
            "             365.20,82.00 336.00,130.00 336.00,130.00\n" +
            "             330.71,138.82 326.73,147.24 315.00,147.89\n" +
            "             301.74,148.63 291.14,135.87 294.79,123.00\n" +
            "             296.68,116.34 303.66,106.21 307.40,100.00\n" +
            "             307.40,100.00 333.00,58.00 333.00,58.00\n" +
            "             339.02,47.98 342.23,40.92 355.00,39.72\n" +
            "             365.83,40.00 374.69,46.77 375.80,58.00 Z\n" +
            "           M 289.00,116.00\n" +
            "           C 289.00,116.00 289.00,239.00 289.00,239.00\n" +
            "             288.98,249.72 285.92,257.31 275.00,261.10\n" +
            "             265.22,264.50 258.37,259.56 255.02,264.43\n" +
            "             253.78,266.24 254.00,269.84 254.00,272.00\n" +
            "             254.00,272.00 254.00,298.00 254.00,298.00\n" +
            "             254.00,304.85 254.77,310.07 250.36,315.93\n" +
            "             242.35,326.68 226.84,326.49 218.80,315.93\n" +
            "             215.07,311.00 215.01,306.83 215.00,301.00\n" +
            "             215.00,301.00 215.00,262.00 215.00,262.00\n" +
            "             215.00,262.00 190.00,262.00 190.00,262.00\n" +
            "             190.00,262.00 190.00,301.00 190.00,301.00\n" +
            "             189.99,306.83 189.93,311.00 186.20,315.93\n" +
            "             178.16,326.49 162.65,326.68 154.64,315.93\n" +
            "             151.09,311.22 151.01,307.61 151.00,302.00\n" +
            "             151.00,302.00 151.00,272.00 151.00,272.00\n" +
            "             151.00,269.84 151.22,266.24 149.98,264.43\n" +
            "             146.53,259.42 138.97,264.76 129.00,260.86\n" +
            "             118.39,256.72 116.02,248.29 116.00,238.00\n" +
            "             116.00,238.00 116.00,116.00 116.00,116.00\n" +
            "             116.00,116.00 289.00,116.00 289.00,116.00 Z";
}
