package com.komoriwu.one.di.component;

import android.app.Activity;


import com.komoriwu.one.di.module.FragmentModule;
import com.komoriwu.one.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by KomoriWu
 * on 2017-09-01.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

}
