package cn.pan.basesample1.base;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import cn.pan.basesample1.R;
import cn.pan.basesample1.app.App;
import cn.pan.basesample1.app.Config;

/**
 * Author: Pan
 * Date:   2016/8/3
 * Description:
 */
public class BaseActivity extends FragmentActivity {

    private Context mContext;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        Config.setActivityState(this);
    }


    @Override
    public void setContentView(int layoutResID) {
        View view = getLayoutInflater().inflate(R.layout.activity_base, null);
        super.setContentView(view);

        //设置4.4版本的状态栏
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            view.setFitsSystemWindows(true);
            //            setTranslucentStatus(true);
            //            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            //            tintManager.setStatusBarTintEnabled(true);
            //            tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
        }

        initDefaultView(layoutResID);
        initDefaultToolBar();

    }

    private void initDefaultToolBar() {
        if (toolbar != null) {
            String title = getTitle().toString();
            setTitle(title);
        }
    }

    private void initDefaultView(int layoutResID) {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        FrameLayout container = (FrameLayout) findViewById(R.id.fl_container);

        View view = getLayoutInflater().inflate(layoutResID, null);
        container.addView(view, 0);
    }

    public void showToast(String msg) {
        Config.showToast(msg);
    }

    public void showProgressDialog() {
        Config.showProgressDialog(mContext, true, new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Config.showToast("Dialog canceled");
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.removeActivity(this);
    }
}
