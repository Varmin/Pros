package com.varmin.cocar.base;


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
    /*protected ActivityComponent mActivityComponent;
    @android.support.annotation.Nullable
    protected Toolbar mToolbar;
    protected LoadingView mLoadingView;*/



}
