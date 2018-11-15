package com.varmin.cocar.loadCallback;

import com.kingja.loadsir.callback.Callback;
import com.varmin.cocar.R;

/**
 * Description:
 * Create Time:2017/9/4 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class EmptyCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_empty;
    }

}
