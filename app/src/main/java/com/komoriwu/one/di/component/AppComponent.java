package com.komoriwu.one.di.component;

import com.komoriwu.one.application.MyApplication;
import com.komoriwu.one.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by KomoriWu
 * on 2017-09-01.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    MyApplication getContext();
}
