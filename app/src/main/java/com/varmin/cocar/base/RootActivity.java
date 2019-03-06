package com.varmin.cocar.base;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by HuangYang
 * on 2018/7/24  17:17.
 * 文件描述：生命周期
 */

//todo AppCompatActivity了解
public class RootActivity extends RxAppCompatActivity implements BaseContract.BaseView {

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>---BaseView---begin--->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Override
    public void showLoading() {
        LogUtils.d("showLoading...");
    }

    @Override
    public void hideLoading() {
        LogUtils.d("hideLoading");
    }

    @Override
    public void showSuccess(String message) {
        ToastUtils.showShort(message);
    }

    @Override
    public void showFaild(String message) {
        ToastUtils.showShort(message);
    }

    @Override
    public void showNoNet() {
        ToastUtils.showShort("No Net");
    }

    @Override
    public void onRetry() {
        ToastUtils.showShort("Retry");
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }

    @Override
    public void jumpToLogin() {
        ToastUtils.showShort("jump to Login");
    }

    @Override
    public void finishPage() {
        finish();
    }
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<---BaseView---end---<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
}
