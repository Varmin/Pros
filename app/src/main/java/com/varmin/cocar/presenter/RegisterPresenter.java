package com.varmin.cocar.presenter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.varmin.cocar.base.BasePresenter;
import com.varmin.cocar.bean.DataResponse;
import com.varmin.cocar.constant.CommonFields;
import com.varmin.cocar.contract.RegisterActContract;
import com.varmin.cocar.net.RetrofitManager;
import com.varmin.cocar.net.RxUtils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by HuangYang
 * on 2018/11/13  18:25.
 * 文件描述：
 */

public class RegisterPresenter extends BasePresenter<RegisterActContract.View> implements RegisterActContract.Presenter {
    @Inject
    public RegisterPresenter() {
    }

    @Override
    public void regist(final String account, final String password) {
        RetrofitManager.create().register(account, password, password)
                //todo 为什么bind方法不会自动填充DataResponse
                .compose(mView.<DataResponse>bindToLife())
                //todo 为什么后面的方法都会自动填充DataResponse
                //todo 以及上一个方法中为什么要定义泛型？
                .compose(RxUtils.<DataResponse>schedulersTransformer())
                .subscribe(new Observer<DataResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mView.showLoading();
                    }

                    @Override
                    public void onNext(DataResponse dataResponse) {
                        if (dataResponse.getErrorCode() == DataResponse.SUCCESS) {
                            spUtils.put(CommonFields.LOGIN_ACCOUNT, account);
                            spUtils.put(CommonFields.LOGIN_PASSWORD, password);
                            mView.finishPage();
                        }else {
                            mView.showFaild(dataResponse.getErrorMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideLoading();
                        mView.showFaild(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }
                });

    }


}
