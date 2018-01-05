package com.komoriwu.one.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.komoriwu.one.application.MyApplication;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class PreferencesHelperImpl implements PreferencesHelper {
    private static final String SP_NAME = "my_sp";
    private SharedPreferences mSharedPreferences;
    public static final String CATEGORIES_ID = "categories_id";
    public static final String TAGS_ID = "tags_id";
    public static final String AUTHOR_ID = "author_id";

    @Inject
    public PreferencesHelperImpl() {
        mSharedPreferences = MyApplication.getInstance().getSharedPreferences(SP_NAME, Context.
                MODE_PRIVATE);
    }

    @Override
    public String getCategoriesId() {
        return mSharedPreferences.getString(CATEGORIES_ID,"");
    }

    @Override
    public void setCategoriesId(String id) {
        mSharedPreferences.edit().putString(CATEGORIES_ID, id).apply();
    }

    @Override
    public String getTagsId() {
        return mSharedPreferences.getString(TAGS_ID,"");
    }

    @Override
    public void setTagsId(String id) {
        mSharedPreferences.edit().putString(TAGS_ID, id).apply();
    }

    @Override
    public String getAuthorId() {
        return mSharedPreferences.getString(AUTHOR_ID,"");
    }

    @Override
    public void setAuthorId(String id) {
        mSharedPreferences.edit().putString(AUTHOR_ID, id).apply();
    }
}
