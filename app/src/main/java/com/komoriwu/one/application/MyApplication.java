package com.komoriwu.one.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.komoriwu.one.di.component.AppComponent;
import com.komoriwu.one.di.component.DaggerAppComponent;
import com.komoriwu.one.di.module.AppModule;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

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
    private static RefWatcher sRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (sInstance == null) {
            sInstance = this;
        }
        mActivityList = new ArrayList<>();

        sRefWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher() {
        return sRefWatcher;
    }

    public static ImageLoader getImageLoader(Context context) {
        if (mImageLoader == null) {
            synchronized (ImageLoader.class) {
                if (mImageLoader == null) {
                    mImageLoader = ImageLoader.getInstance();
                    ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(context)
                            .threadPoolSize(2)
                            .threadPriority(Thread.NORM_PRIORITY - 2)
                            .denyCacheImageMultipleSizesInMemory()
                            .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                            .memoryCacheSize(2 * 1024 * 1024)
                            .tasksProcessingOrder(QueueProcessingType.LIFO)
                            .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                            .imageDownloader(new BaseImageDownloader(context, 5 *
                                    1000, 30 * 1000))
                            .build();
                    mImageLoader.init(configuration);
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
