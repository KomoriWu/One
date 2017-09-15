package com.komoriwu.one.di.component;

import android.app.Activity;


import com.komoriwu.one.di.module.FragmentModule;
import com.komoriwu.one.di.scope.FragmentScope;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.one.OneFragment;

import dagger.Component;

/**
 * Created by KomoriWu
 * on 2017-09-01.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

    void inject(OneFragment oneFragment);
}
