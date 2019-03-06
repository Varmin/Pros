package com.varmin.cocar.contract;

import com.varmin.cocar.base.BaseContract;

/**
 * Created by HuangYang
 * on 2018/11/8  17:10.
 * 文件描述：
 */
public interface RegisterActContract {
    interface View extends BaseContract.BaseView{
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void regist(String account, String password);
    }
}
