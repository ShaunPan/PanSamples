package com.pan.buttonsample;

import android.util.Log;

/**
 * Author:Pan
 * Time:2016/5/19 11:34
 * Description:
 */
public class ButtonUtil {

    private static final String TAG = "ButtonUtil";

    private final static long MINI_INTERVAL_TIME = 500;
    private static long lastClickTime;

    public static boolean isMultiClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime > MINI_INTERVAL_TIME) {
            lastClickTime = time;
            return true;
        } else {
            Log.i(TAG, "Click too fast");
            lastClickTime = time;
            return false;
        }
    }
}
