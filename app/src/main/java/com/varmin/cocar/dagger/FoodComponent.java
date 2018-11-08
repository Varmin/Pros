package com.varmin.cocar.dagger;

import com.varmin.cocar.SplashActivity;

import dagger.Component;

/**
 * Created by HuangYang
 * on 2018/11/2  17:16.
 * 文件描述：
 */
@BaoZiSingle
@Component(modules = FoodModule.class, dependencies = FruitComponent.class)
public interface FoodComponent {
    ZhaiNan makeWaiMai();
    void inject(SplashActivity splashActivity);
    Tea createStatic();
}
