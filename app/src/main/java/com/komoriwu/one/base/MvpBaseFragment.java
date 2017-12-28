package com.komoriwu.one.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


import com.komoriwu.one.application.MyApplication;
import com.komoriwu.one.di.component.DaggerFragmentComponent;
import com.komoriwu.one.di.component.FragmentComponent;
import com.komoriwu.one.di.module.FragmentModule;

import javax.inject.Inject;

/**
 * Created by KomoriWu
 * on 2017-09-01.
 */

public abstract class MvpBaseFragment<T extends BasePresenter> extends BaseFragment
        implements BaseView {

    @Inject
    public T presenter;

    protected abstract void initInject();

    public FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    private FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        if (presenter != null) {
            presenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
