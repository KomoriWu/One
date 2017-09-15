package com.komoriwu.one.base;


import com.komoriwu.one.application.MyApplication;
import com.komoriwu.one.di.component.ActivityComponent;
import com.komoriwu.one.di.component.DaggerActivityComponent;
import com.komoriwu.one.di.module.ActivityModule;

import javax.inject.Inject;

public abstract class MvpBaseActivity<T extends BasePresenter> extends BaseActivity implements
        BaseView {

    @Inject
    public T presenter;

    public abstract void initInject();

    public ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(MyApplication.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    private ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public void onCreateView() {
        super.onCreateView();
        initInject();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.detachView();
    }
}
