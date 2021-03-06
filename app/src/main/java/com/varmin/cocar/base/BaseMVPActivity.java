package com.varmin.cocar.base;


import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.varmin.cocar.di.component.ActivityComponent;
import com.varmin.cocar.di.component.DaggerActivityComponent;

import javax.inject.Inject;
import io.reactivex.annotations.Nullable;

/**
 * Created by HuangYang
 * on 2018/11/1  19:23.
 * 文件描述：使用MVP
 */
public abstract class BaseMVPActivity<T extends BaseContract.BasePresenter> extends BaseActivity implements BaseContract.BaseView{

    public String TAG;
    @Inject
    protected T mPresenter;

    protected ActivityComponent mActivityComponent;


    protected abstract void initInjector();
    @Override
    protected void onCreate(@android.support.annotation.Nullable Bundle savedInstanceState) {
        TAG = getClass().getSimpleName();
        initActivityComponent();
        initInjector();
        super.onCreate(savedInstanceState);
        attachView();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        detachView();
    }

    private void initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((App)getApplication()).getApplicationComponent())
                .build();
    }

    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }
    private void detachView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
