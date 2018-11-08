package com.varmin.cocar.base;


import android.os.Bundle;

import com.varmin.cocar.di.component.ActivityComponent;
import com.varmin.cocar.di.component.DaggerActivityComponent;

import javax.inject.Inject;
import io.reactivex.annotations.Nullable;

/**
 * Created by HuangYang
 * on 2018/11/1  19:23.
 * 文件描述：
 */
public abstract class BaseMVPActivity<T extends BaseContract.BasePresenter> extends BaseActivity implements BaseContract.BaseView{

    @Nullable
    @Inject
    protected T mPresenter;

    protected ActivityComponent mActivityComponent;
//    protected LoadingView mLoadingView;


    @Override
    protected void onCreate(@android.support.annotation.Nullable Bundle savedInstanceState) {
        initActivityComponent();
        super.onCreate(savedInstanceState);
        initInjector();
    }

    private void initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((App)getApplication()).getApplicationComponent())
                .build();
    }
    protected abstract void initInjector();
}
