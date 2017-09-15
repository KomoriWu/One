package com.komoriwu.one.di.module;


import com.komoriwu.one.application.MyApplication;
import com.komoriwu.one.model.DataManagerModel;
import com.komoriwu.one.model.db.DBHelper;
import com.komoriwu.one.model.db.DBHelperImpl;
import com.komoriwu.one.model.http.HttpHelper;
import com.komoriwu.one.model.http.HttpHelperImpl;
import com.komoriwu.one.model.prefs.PreferencesHelper;
import com.komoriwu.one.model.prefs.PreferencesHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by KomoriWu
 * on 2017/9/15.
 */
@Module
public class AppModule {
    private MyApplication myApplication;

    public AppModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    @Singleton
    MyApplication provideMyApplication() {
        return myApplication;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelper) {
        return httpHelper;
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(DBHelperImpl dbHelper) {
        return dbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesHelperImpl preferencesHelper) {
        return preferencesHelper;
    }

    @Provides
    @Singleton
    DataManagerModel provideDataManagerModel(HttpHelperImpl httpHelper, DBHelperImpl dbHelper,
                                             PreferencesHelperImpl preferencesHelper) {
        return new DataManagerModel(httpHelper, dbHelper, preferencesHelper);
    }
}
