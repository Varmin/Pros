package com.varmin.cocar.di.component;

import com.varmin.cocar.activity.LoginActivity;
import com.varmin.cocar.di.module.ActivityModule;
import com.varmin.cocar.di.scope.PerActivityScope;

import dagger.Component;

/**
 * Created by HuangYang
 * on 2018/11/8  16:23.
 * 文件描述：
 */
@PerActivityScope
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);
}
