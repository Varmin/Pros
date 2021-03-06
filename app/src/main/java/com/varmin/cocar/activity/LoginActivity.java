package com.varmin.cocar.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.varmin.cocar.R;
import com.varmin.cocar.base.BaseMVPActivity;
import com.varmin.cocar.constant.CommonFields;
import com.varmin.cocar.contract.LoginActContract;
import com.varmin.cocar.presenter.LoginActPresenter;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseMVPActivity<LoginActPresenter> implements LoginActContract.View {
    @BindView(R.id.tv_al_account)
    AutoCompleteTextView tvAlAccount;
    @BindView(R.id.tv_al_password)
    EditText tvAlPassword;

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

    @Override
    protected void onResume() {
        super.onResume();
        String account = spUtils.getString(CommonFields.LOGIN_ACCOUNT);
        String password = spUtils.getString(CommonFields.LOGIN_PASSWORD);
        if (!TextUtils.isEmpty(account)) tvAlAccount.setText(account);
        if (!TextUtils.isEmpty(password)) tvAlPassword.setText(password);
    }

    @OnClick({R.id.login, R.id.regitster})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                String account = tvAlAccount.getText().toString().trim();
                String password = tvAlPassword.getText().toString().trim();
                if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
                    showFaild("用户名或密码不能为空");
                }else {
                    mPresenter.login(account, password);
                }
                break;
            case R.id.regitster:
                ARouter.getInstance().build("/activity/RegisterActivity").navigation();
                break;
        }
    }

    @Override
    public void loginSuccess() {
        ARouter.getInstance().build("/activity/MainActivity").navigation();
        finishPage();
    }
}
