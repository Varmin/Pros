package com.varmin.cocar.base;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.varmin.cocar.di.component.ApplicationComponent;
import com.varmin.cocar.di.component.DaggerApplicationComponent;
import com.varmin.cocar.di.module.ApplicationModule;

/**
 * Created by HuangYang
 * on 2018/11/1  19:07.
 * 文件描述：
 */
public class App extends Application {
    private static App mInstance;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Utils.init(this);
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(mInstance))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
