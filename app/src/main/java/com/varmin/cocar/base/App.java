package com.varmin.cocar.base;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by HuangYang
 * on 2018/11/1  19:07.
 * 文件描述：
 */
public class App extends Application {
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Utils.init(this);
    }
}
