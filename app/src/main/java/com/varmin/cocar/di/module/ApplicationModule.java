package com.varmin.cocar.di.module;

import android.content.Context;

import com.varmin.cocar.base.App;
import com.varmin.cocar.di.scope.ContextLife;
import com.varmin.cocar.di.scope.PerAppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HuangYang
 * on 2018/11/8  15:56.
 * 文件描述：
 */
@Module
public class ApplicationModule {
    private App mApplication;
    public ApplicationModule(App app){
        mApplication = app;
    }

    @PerAppScope
    @ContextLife("Application")
    @Provides
    public Context provideApplicationContext(){
        return mApplication.getApplicationContext();
    }
}
