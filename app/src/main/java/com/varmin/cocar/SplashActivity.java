package com.varmin.cocar;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import com.blankj.utilcode.util.ActivityUtils;
import com.varmin.cocar.activity.LoginActivity;
import com.varmin.cocar.activity.RegisterActivity;
import com.varmin.cocar.base.BaseActivity;
import com.varmin.cocar.constant.CommonFields;
import butterknife.BindView;
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
        btnTest.setVisibility(View.VISIBLE);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
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
                    //ActivityUtils.startActivity(LoginActivity.class);
                    ActivityUtils.startActivity(RegisterActivity.class);
                }
            }
        }, 1000);

    }
}
