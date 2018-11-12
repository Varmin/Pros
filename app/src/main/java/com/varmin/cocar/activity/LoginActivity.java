package com.varmin.cocar.activity;

import com.varmin.cocar.R;
import com.varmin.cocar.base.BaseMVPActivity;
import com.varmin.cocar.contract.LoginActContract;
import com.varmin.cocar.presenter.LoginActPresenter;


public class LoginActivity extends BaseMVPActivity<LoginActPresenter> implements LoginActContract.View{

    @Override
    protected void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }


}
