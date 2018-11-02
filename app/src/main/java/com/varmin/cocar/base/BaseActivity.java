package com.varmin.cocar.base;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SpanUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.blankj.utilcode.util.CrashUtils.init;

/**
 * Created by HuangYang
 * on 2018/7/24  17:17.
 * 文件描述：各种初始化
 */

public abstract class BaseActivity extends RootActivity {
    private Unbinder unBinder;
    protected SPUtils spUtils;

    //todo Activity生命周期 onCreate的区别
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        init();
        initData();
        initView();
    }

    private void init() {
        spUtils = SPUtils.getInstance();
    }

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
    }

    protected BaseActivity getActivity(){
        return this;
    }
}
