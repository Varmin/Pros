package com.varmin.cocar.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by HuangYang
 * on 2018/11/8  16:26.
 * 文件描述：
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivityScope {

}
