package com.komoriwu.one.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.komoriwu.one.di.component.AppComponent;
import com.komoriwu.one.di.component.DaggerAppComponent;
import com.komoriwu.one.di.module.AppModule;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-07-12.
 */

public class MyApplication extends Application {
    private static ImageLoader mImageLoader;
    private static MyApplication sInstance;
    private List<Activity> mActivityList;
    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (sInstance == null) {
            sInstance = this;
        }
        mActivityList = new ArrayList<>();
    }

    public static ImageLoader getImageLoader(Context context) {
        if (mImageLoader == null) {
            synchronized (ImageLoader.class) {
                if (mImageLoader == null) {
                    mImageLoader = ImageLoader.getInstance();
                    mImageLoader.init(ImageLoaderConfiguration.createDefault(context.
                            getApplicationContext()));
                }
            }
        }
        return mImageLoader;
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

    public void addActivity(Activity activity) {
        if (!mActivityList.contains(activity)) {
            mActivityList.add(activity);
        }
    }


    public void removeAllActivity() {
        for (Activity activity : mActivityList) {
            activity.finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}
