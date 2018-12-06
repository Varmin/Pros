package com.varmin.cocar.base;

import android.app.Application;
import android.os.Build;

import com.blankj.utilcode.util.Utils;
import com.kingja.loadsir.core.LoadSir;
import com.varmin.cocar.BuildConfig;
import com.varmin.cocar.di.component.ApplicationComponent;
import com.varmin.cocar.di.component.DaggerApplicationComponent;
import com.varmin.cocar.di.module.ApplicationModule;
import com.varmin.cocar.loadCallback.CustomCallback;
import com.varmin.cocar.loadCallback.EmptyCallback;
import com.varmin.cocar.loadCallback.ErrorCallback;
import com.varmin.cocar.loadCallback.LoadingCallback;
import com.varmin.cocar.loadCallback.TimeoutCallback;

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
        initLoadSir();
    }

    private void initLoadSir() {
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }

    private void initRouter() {
        /*if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(mInstance);*/
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
