package com.varmin.cocar.dagger;

import android.annotation.TargetApi;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by HuangYang
 * on 2018/11/2  17:09.
 * 文件描述：
 */
@BaoZiSingle
public class Baozi {
    private static final String TAG = "Baozi";

    @Inject
    public Baozi(){
        Log.d(TAG, "Baozi: Create 小龙包");
    }

    @Override
    public String toString() {
        return "小龙包";
    }
}
