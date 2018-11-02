package com.varmin.cocar.dagger;

import javax.inject.Inject;

/**
 * Created by HuangYang
 * on 2018/11/2  17:11.
 * 文件描述：
 */
public class ZhaiNan {
    @Inject
    Baozi baozi;
    @Inject
    Noodle noodle;
    @Inject
    String storeName;


    @Inject
    public ZhaiNan(){

    }

    public String eat(){
        StringBuilder sb = new StringBuilder();
        sb.append("我吃的是")
        .append(storeName+"店铺的：");
        if ( baozi != null ) {
            sb.append(baozi.toString());
        }

        if (noodle != null) {
            sb.append("  ");
            sb.append(noodle.toString());
        }
        return sb.toString();
    }
}
