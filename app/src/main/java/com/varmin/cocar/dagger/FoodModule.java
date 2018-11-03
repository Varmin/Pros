package com.varmin.cocar.dagger;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HuangYang
 * on 2018/11/2  17:39.
 * 文件描述：
 */
@Module
public class FoodModule {

    public String storeName;

    public FoodModule(){
    }
    public FoodModule(String storeName){
        this.storeName = storeName;
    }

    @Provides
    public Noodle provideNoodle(PaoMian paoMian){
        return paoMian;
    }

    @Provides
    @Named("storeName")
    public String provideStoreName() {
        return storeName;
    }

    @Provides
    public static Tea provideTea(){
        return new Tea();
    }
}
