package com.varmin.cocar.dagger;

import dagger.Component;

/**
 * Created by HuangYang
 * on 2018/11/2  17:16.
 * 文件描述：
 */
@Component(modules = VModule.class)
public interface Platform {
    ZhaiNan makeWaiMai();
}
