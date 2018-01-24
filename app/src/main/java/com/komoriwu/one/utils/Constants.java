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
}
