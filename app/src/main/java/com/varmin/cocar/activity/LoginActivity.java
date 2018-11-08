package com.varmin.cocar.activity;

import com.varmin.cocar.R;
import com.varmin.cocar.base.BaseMVPActivity;
import com.varmin.cocar.contract.LoginActContract;

/**
 * todo: mvp架构、Dagger为什么component注入，inject是作甚呢？
 */
public class LoginActivity extends BaseMVPActivity<LoginActContract.Presenter> implements LoginActContract.View{

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
