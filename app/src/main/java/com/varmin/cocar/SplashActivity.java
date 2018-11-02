package com.varmin.cocar;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.varmin.cocar.base.BaseActivity;
import com.varmin.cocar.constant.CommonFields;
import com.varmin.cocar.dagger.DaggerPlatform;
import com.varmin.cocar.dagger.VModule;
import com.varmin.cocar.dagger.ZhaiNan;

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
                ZhaiNan zaiNan = DaggerPlatform.builder()
                        .vModule(new VModule("Varmin"))
                        .build().makeWaiMai();
                Toast.makeText(getActivity(), zaiNan.eat(), Toast.LENGTH_SHORT).show();
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

                }
            }
        }, 3000);

    }
}
