package com.komoriwu.one.di.component;

import com.komoriwu.one.application.MyApplication;
import com.komoriwu.one.di.module.AppModule;
import com.komoriwu.one.di.module.HttpModule;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.db.DBHelper;
import com.komoriwu.one.model.http.HttpHelper;
import com.komoriwu.one.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by KomoriWu
 * on 2017-09-01.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    MyApplication getContext();

    DataManagerModel getDataManagerModel();

    HttpHelper getHttpHelper();

    DBHelper getDbHelper();

    PreferencesHelper getPreferencesHelper();
}
