package com.varmin.cocar.presenter;

import com.varmin.cocar.base.BasePresenter;
import com.varmin.cocar.contract.MainActContract;

import javax.inject.Inject;

/**
 * Created by HuangYang
 * on 2018/11/14  17:41.
 * 文件描述：
 */
public class MainPresenter extends BasePresenter<MainActContract.View> implements MainActContract.Presenter {
    @Inject
    public MainPresenter(){}
}
