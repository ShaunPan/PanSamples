package com.pan.basesample;

import android.os.Bundle;

import com.pan.basesample.base.AppActivity;
import com.pan.basesample.base.BaseFragment;

public class MainActivity extends AppActivity {

    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
