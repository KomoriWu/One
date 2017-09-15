package com.komoriwu.one.di.module;

import android.app.Activity;

import com.komoriwu.one.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by KomoriWu
 * on 2017-09-01.
 */
@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return activity;
    }

}
