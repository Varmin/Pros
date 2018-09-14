package com.varmin.cocar;

import android.widget.TextView;
import com.varmin.cocar.base.BaseActivity;
import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_text)
    TextView tvText;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        tvText.setText("initView");
    }
}
