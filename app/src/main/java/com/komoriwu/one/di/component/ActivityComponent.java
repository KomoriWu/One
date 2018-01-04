package com.komoriwu.one.di.component;

import android.app.Activity;


import com.komoriwu.one.all.detail.CategoriesDetailActivity;
import com.komoriwu.one.all.detail.TagsDetailActivity;
import com.komoriwu.one.all.detail.VideoCardActivity;
import com.komoriwu.one.all.leftmenu.AllCategoriesActivity;
import com.komoriwu.one.all.search.SearchActivity;
import com.komoriwu.one.di.module.ActivityModule;
import com.komoriwu.one.di.scope.ActivityScope;
import com.komoriwu.one.main.MainActivity;
import com.komoriwu.one.one.detail.ReadDetailActivity;

import dagger.Component;

/**
 * Created by KomoriWu
 * on 2017-09-01.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(MainActivity mainActivity);

    void inject(ReadDetailActivity readDetailActivity);

    void inject(VideoCardActivity videoCardActivity);

    void inject(AllCategoriesActivity allCategoriesActivity);

    void inject(CategoriesDetailActivity categoriesDetailActivity);

    void inject(SearchActivity searchActivity);
    void inject(TagsDetailActivity tagsDetailActivity);
}
