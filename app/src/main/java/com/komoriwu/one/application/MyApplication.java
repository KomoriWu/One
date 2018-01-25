package com.komoriwu.one.application;

import android.app.Application;
import android.util.Log;

import com.komoriwu.one.di.component.AppComponent;
import com.komoriwu.one.di.component.DaggerAppComponent;
import com.komoriwu.one.di.module.AppModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.smtt.sdk.QbSdk;

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
        initTBSWebView();
    }

    private void initTBSWebView() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),  cb);
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
