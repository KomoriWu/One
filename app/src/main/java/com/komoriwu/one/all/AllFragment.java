package com.komoriwu.one.all;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.komoriwu.one.R;
import com.komoriwu.one.all.mvp.AllContract;
import com.komoriwu.one.all.mvp.AllPresenter;
import com.komoriwu.one.base.MvpBaseFragment;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.me.MeAdapter;
import com.komoriwu.one.me.mvp.MePresenter;
import com.komoriwu.one.model.bean.VideoBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.listener.HidingScrollBottomListener;
import com.komoriwu.one.widget.refresh.RefreshLayout;
import com.komoriwu.one.widget.refresh.SwipeRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */

public class AllFragment extends MvpBaseFragment<AllPresenter> {

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

    }

    @Override
    public void showErrorMsg(String msg) {

    }
}
