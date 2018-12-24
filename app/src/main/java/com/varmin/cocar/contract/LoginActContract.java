package com.varmin.cocar.contract;

import com.varmin.cocar.base.BaseContract;

/**
 * Created by HuangYang
 * on 2018/11/8  17:10.
 * 文件描述：
 */
public interface LoginActContract {
    interface View extends BaseContract.BaseView{
        void loginSuccess();
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void login(String account, String password);
    }
}
