package com.varmin.cocar.base;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SpanUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static com.blankj.utilcode.util.CrashUtils.init;

/**
 * Created by HuangYang
 * on 2018/7/24  17:17.
 * 文件描述：不使用MVP模式可继承
 */

public abstract class BaseActivity extends RootActivity {
    private Unbinder unBinder;
    protected SPUtils spUtils;
    private CompositeDisposable compositeDisposable;

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initView();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        internalInit();
        initData();
        initView();
    }
    private void internalInit() {
        spUtils = SPUtils.getInstance();
        compositeDisposable = new CompositeDisposable();
    }

    protected void addDisposable(Disposable disposable){
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    protected BaseActivity getActivity(){
        return this;
    }


}
