package com.varmin.cocar.base;

import android.app.Application;
import android.os.Build;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.varmin.cocar.BuildConfig;
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

        initRouter();
        Utils.init(this);
        initApplicationComponent();
    }

    private void initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(mInstance);
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
