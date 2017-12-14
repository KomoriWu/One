package com.komoriwu.one.all;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.komoriwu.one.R;
import com.komoriwu.one.all.fragment.FindFragment;
import com.komoriwu.one.all.mvp.AllContract;
import com.komoriwu.one.all.mvp.AllPresenter;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.model.bean.FindBean;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class AllFragment extends MvpBaseFragment<AllPresenter> implements AllContract.View {
    private static final String TAG = AllFragment.class.getSimpleName();
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_view_pager)
    SmartTabLayout tabViewPager;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all, null);
    }

    @Override
    public void init() {
        initTab();
    }

    private void initTab() {
        String[] tabs = getResources().getStringArray(R.array.tabs);
        FragmentPagerItems pages = new FragmentPagerItems(getActivity());
        for (String tabTitle : tabs) {
            pages.add(FragmentPagerItem.of(tabTitle, FindFragment.class));
        }
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getActivity().getSupportFragmentManager(), pages);
        viewPager.setAdapter(adapter);
        tabViewPager.setViewPager(viewPager);
    }



    @Override
    public void showErrorMsg(String msg) {

    }



}
