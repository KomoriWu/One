package com.komoriwu.one.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;


import com.komoriwu.one.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;
/**
 * Created by KomoriWu
 *  on 2017/9/15.
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    Activity provideActivity() {
        return fragment.getActivity();
    }

}
