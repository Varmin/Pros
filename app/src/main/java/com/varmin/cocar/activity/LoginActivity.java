package com.varmin.cocar.activity;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

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
        Log.d(TAG, "initInjector: "+mPresenter.toString());
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
        String account = SPUtils.getInstance().getString(CommonFields.LOGIN_ACCOUNT);
        String password = SPUtils.getInstance().getString(CommonFields.LOGIN_PASSWORD);
        if (!TextUtils.isEmpty(account)) tvAlAccount.setText(account);
        if (!TextUtils.isEmpty(password)) tvAlPassword.setText(password);
    }

    //TODO 看RxJava和Retrofit
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
                //ARouter.getInstance().build("/activity/RegisterActivity").navigation();
                break;
        }
    }

    @Override
    public void loginSuccess() {
        //ARouter.getInstance().build("/activity/MainActivity").navigation();
    }
}
