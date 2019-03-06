package com.varmin.cocar.activity;

import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ActivityUtils;
import com.varmin.cocar.R;
import com.varmin.cocar.base.BaseMVPActivity;
import com.varmin.cocar.contract.RegisterActContract;
import com.varmin.cocar.presenter.RegisterPresenter;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/activity/RegisterActivity")
public class RegisterActivity extends BaseMVPActivity<RegisterPresenter> implements RegisterActContract.View {

    @BindView(R.id.et_regist_account)
    TextInputEditText etRegistAccount;
    @BindView(R.id.et_regist_pass)
    TextInputEditText etRegistPass;

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

    @OnClick(R.id.btn_regist_submit)
    public void onViewClicked() {
        String account = etRegistAccount.getText().toString().trim();
        String password = etRegistPass.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            showFaild("请填写账号");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            showFaild("请填写密码");
            return;
        }
        mPresenter.regist(account, password);
    }
}
