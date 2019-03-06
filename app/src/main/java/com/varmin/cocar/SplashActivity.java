package com.varmin.cocar;

import android.view.View;
import android.widget.Button;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.Utils;
import com.varmin.cocar.activity.LoginActivity;
import com.varmin.cocar.activity.MainActivity;
import com.varmin.cocar.base.BaseActivity;
import com.varmin.cocar.constant.CommonFields;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import yanzhikai.textpath.SyncTextPathView;
import yanzhikai.textpath.painter.FireworksPainter;

public class SplashActivity extends BaseActivity {
    @BindView(R.id.stpv_path)
    SyncTextPathView stpvPath;
    @BindView(R.id.btn_test)
    Button btnTest;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        /*btnTest.setVisibility(View.GONE);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });*/
        spUtils.put(CommonFields.HAS_LOGIN, false);
    }

    @Override
    protected void initView() {
//        stpvPath.setPathPainter(new FireworksPainter());
//        stpvPath.startAnimation(0,1);
        Disposable disposable = Observable.timer(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (spUtils.getBoolean(CommonFields.HAS_LOGIN)) {
                            ActivityUtils.startActivity(MainActivity.class);
                        } else {
                            ActivityUtils.startActivity(LoginActivity.class);
                        }
                        finishPage();
                    }
                });
        addDisposable(disposable);
    }
}
