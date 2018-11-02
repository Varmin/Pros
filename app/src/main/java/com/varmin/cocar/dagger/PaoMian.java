package com.varmin.cocar.dagger;

import javax.inject.Inject;

/**
 * Created by HuangYang
 * on 2018/11/2  17:52.
 * 文件描述：
 */
public class PaoMian extends Noodle {
    @Inject
    public PaoMian(){

    }

    @Override
    public String toString() {
        return "泡面";
    }
}
