package com.pan.buttonsample;

import android.util.Log;
import android.view.View;

/**
 * Author:Pan
 * Time:2016/5/19 11:07
 * Description:
 */
public abstract class OnNoMultiClickListener implements View.OnClickListener {

    private static final String TAG = "OnNoMultiClickListener";

    private final static long MINI_INTERVAL_TIME = 500;
    private long lastClickTime;

    @Override
    public void onClick(View v) {
        long time = System.currentTimeMillis();
        if (time - lastClickTime > MINI_INTERVAL_TIME) {
            onNoMultiClick(v);
        } else {
            Log.i(TAG, "Too fast click");
        }
        lastClickTime = time;
    }

    public abstract void onNoMultiClick(View v);
}
