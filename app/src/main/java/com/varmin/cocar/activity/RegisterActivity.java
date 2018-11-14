package com.varmin.cocar.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.varmin.cocar.R;
import com.varmin.cocar.base.BaseMVPActivity;
import com.varmin.cocar.contract.RegisterActContract;

@Route(path = "/activity/RegisterActivity")
public class RegisterActivity extends BaseMVPActivity<RegisterActContract.Presenter> implements RegisterActContract.View {

    @Override
    protected void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}
