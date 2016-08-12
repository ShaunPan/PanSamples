package cn.pan.basesample1.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.widget.Toast;

/**
 * Author: Pan
 * Date:   2016/8/3
 * Description:
 */
public class Config {

    private static Context mContext;
    private static ProgressDialog progressDialog;

    public static void setActivityState(Activity activity) {
        mContext = activity;
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        App.addActivity(activity);
    }

    public static void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showProgressDialog(Context context, boolean cancelable, ProgressDialog.OnCancelListener listener) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
        }
        progressDialog.setCancelable(cancelable);
        progressDialog.setOnCancelListener(listener);
        progressDialog.show();
    }

    public static void dimissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
