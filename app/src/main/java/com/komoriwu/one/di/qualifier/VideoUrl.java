package com.komoriwu.one.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by KomoriWu
 * on 2017-12-06.
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface VideoUrl {
}
