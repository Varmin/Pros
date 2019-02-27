package com.varmin.cocar.base;

import com.blankj.utilcode.util.SPUtils;

/**
 * Created by HuangYang
 * on 2018/11/8  17:04.
 * 文件描述：
 */
public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    protected T mView;
    protected SPUtils spUtils;

    @Override
    public void attachView(T view) {
        this.mView = view;
        this.spUtils = SPUtils.getInstance();
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
