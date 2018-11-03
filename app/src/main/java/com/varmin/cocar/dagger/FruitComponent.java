package com.varmin.cocar.dagger;

import dagger.Component;

/**
 * Created by HuangYang
 * on 2018/11/3  23:14.
 * 文件描述：
 */
@Component(modules = FruitModule.class)
public interface FruitComponent {
    Apple getApple();
}
