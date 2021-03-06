package com.varmin.cocar.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * desc:
 * author: OnexZgj .
 * date: 2018/4/2 .
 */
public interface BaseContract {

    interface BasePresenter<T extends BaseContract.BaseView> {

        void attachView(T view);

        void detachView();
    }


    interface BaseView {

        //显示进度中
        void showLoading();

        //隐藏进度
        void hideLoading();

        //显示请求成功
        void showSuccess(String message);

        //失败重试
        void showFaild(String message);

        //显示当前网络不可用
        void showNoNet();

        //重试
        void onRetry();

        /**
         * 绑定生命周期
         */
        <T> LifecycleTransformer<T> bindToLife();

        /**
         * 跳转到登录页面
         */
        void jumpToLogin();

        void finishPage();
    }
}
