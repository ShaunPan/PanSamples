package cn.pan.basesample1;

import android.os.Bundle;

import cn.pan.basesample1.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showProgressDialog();
    }
}
