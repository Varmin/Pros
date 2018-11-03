package com.varmin.cocar.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HuangYang
 * on 2018/11/3  23:14.
 * 文件描述：
 */
@Module
public class FruitModule {
    @Provides
    public Apple createApple(){
        return new Apple();
    }
}
