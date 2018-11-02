package com.varmin.cocar.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HuangYang
 * on 2018/11/2  17:39.
 * 文件描述：
 */
@Module
public class VModule {
    private final String storeName;

    public VModule(String storeName){
        this.storeName = storeName;
    }

    @Provides
    public Noodle provideNoodle(PaoMian paoMian){
        return paoMian;
    }

    @Provides
    public String provideStoreName() {
        return storeName;
    }
}
