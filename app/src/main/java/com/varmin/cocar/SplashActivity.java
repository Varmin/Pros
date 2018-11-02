package com.varmin.cocar;

import android.os.Handler;

import com.blankj.utilcode.util.ActivityUtils;
import com.varmin.cocar.base.BaseActivity;
import com.varmin.cocar.constant.CommonFields;

import butterknife.BindView;
import yanzhikai.textpath.SyncTextPathView;
import yanzhikai.textpath.painter.FireworksPainter;

public class SplashActivity extends BaseActivity {
    @BindView(R.id.stpv_path)
    SyncTextPathView stpvPath;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        stpvPath.setPathPainter(new FireworksPainter());
        stpvPath.startAnimation(0,1);

        //todo 用RxJava延迟
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (spUtils.getBoolean(CommonFields.HAS_LOGIN)) {
//                    ActivityUtils.startActivity();
                }else {

                }
            }
        }, 3000);

    }
}
