package com.komoriwu.one.all.detail.fragment;

import android.text.TextUtils;

import com.komoriwu.one.all.detail.fragment.mvp.CategoriesDetailIndexPresenter;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;

/**
 * Created by KomoriWu
 * on 2017-12-31.
 */

public class CategoriesDetailIndexFragment extends DetailIndexBaseFragment<
        CategoriesDetailIndexPresenter> {

    @Override
    protected void setInject() {
        getFragmentComponent().inject(this);
    }


    @Override
    public void loadList() {
        presenter.loadList(position);
    }

    @Override
    public void loadMoreList() {
        presenter.loadMoreList(position, stringHashMap);
    }

    @Override
    public void setStringHashMap(String nextUrl) {
        isLoadMore = !TextUtils.isEmpty(nextUrl);
        if (isLoadMore) {
            if (position == 0) {
                stringHashMap.put(Constants.PAGE, Utils.formatUrl(nextUrl).split("&")[0]);
            } else {
                String start = Utils.formatUrl(nextUrl).split("&")[0];
                String num = Utils.formatUrl(nextUrl).split("&")[1].split("=")[1];
                stringHashMap.put(Constants.START, start);
                stringHashMap.put(Constants.NUM, num);
            }
        }
    }


}
