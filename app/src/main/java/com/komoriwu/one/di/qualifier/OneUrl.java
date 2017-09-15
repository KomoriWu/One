package com.komoriwu.one.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;

/**
 * Created by KomoriWu
 *  on 2017/9/15.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface OneUrl {
}
