package com.komoriwu.one.di.component;

import android.app.Activity;


import com.komoriwu.one.di.module.ActivityModule;
import com.komoriwu.one.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by KomoriWu
 * on 2017-09-01.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

}
