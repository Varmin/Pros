package com.varmin.cocar.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by HuangYang
 * on 2018/11/5  10:54.
 * 文件描述：
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface BaoZiSingle {}
