package com.komoriwu.one.application;

import android.app.Application;

import com.komoriwu.one.di.component.AppComponent;
import com.komoriwu.one.di.component.DaggerAppComponent;
import com.komoriwu.one.di.module.AppModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by KomoriWu
 * on 2017-07-12.
 */

public class MyApplication extends Application {
    private static MyApplication sInstance;
    private static AppComponent mAppComponent;
    private static RefWatcher sRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (sInstance == null) {
            sInstance = this;
        }

        sRefWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher() {
        return sRefWatcher;
    }

    public static MyApplication getInstance() {
        if (sInstance == null) {
            return new MyApplication();
        } else {
            return sInstance;
        }
    }

    public static AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(sInstance))
                    .build();
        }
        return mAppComponent;
    }

}
