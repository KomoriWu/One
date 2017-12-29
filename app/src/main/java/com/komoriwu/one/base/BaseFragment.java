package com.komoriwu.one.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.komoriwu.one.application.MyApplication;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-07-12.
 */


public abstract class BaseFragment extends Fragment {
    public static final String TAG = BaseFragment.class.getSimpleName();
    public ProgressDialog progressDialog;

    public abstract View initView(LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState);

    public abstract void init();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return initView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        init();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void showProgressDialog(int id) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
        }
        progressDialog.setMessage(getString(id));
        progressDialog.show();

    }

    public void hideProgressDialog() {
        if (progressDialog != null) {
            progressDialog.hide();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        MyApplication.getRefWatcher().watch(this);
    }

    @Subscribe
    public void onEventMainThread(String flags) {
        Log.d(TAG, flags);
    }
}
