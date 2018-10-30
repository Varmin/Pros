package com.varmin.cocar;

import com.varmin.cocar.base.BaseActivity;
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
    }
}
