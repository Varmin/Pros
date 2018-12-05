package com.varmin.cocar.di.component;

import android.content.Context;

import com.varmin.cocar.di.module.ApplicationModule;
import com.varmin.cocar.di.scope.ContextLife;
import com.varmin.cocar.di.scope.PerAppScope;

import dagger.Component;

/**
 * Created by HuangYang
 * on 2018/11/8  16:12.
 * 文件描述：
 */
@PerAppScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ContextLife("Application")
    Context getApplication();
}