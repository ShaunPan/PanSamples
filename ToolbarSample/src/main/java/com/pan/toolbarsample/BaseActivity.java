package com.pan.toolbarsample;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Author: Pan
 * Date:   2016/7/6
 * Description:
 */
public abstract class BaseActivity extends AppCompatActivity {

    private LinearLayout contentView;
    private Toolbar toolbar;
    private TextView rightTextView;
    private TextView toolbarTitle;
    private Toolbar.OnMenuItemClickListener mOnMenuItemClickListener;
    private static final int INVALID_MENU = -1;
    private int menuResId = INVALID_MENU;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {

        //默认布局
        if (contentView == null && layoutResID == R.layout.activity_base) {
            super.setContentView(layoutResID);

            contentView = (LinearLayout) findViewById(R.id.layout_content);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            rightTextView = (TextView) findViewById(R.id.tv_right);
            toolbarTitle = (TextView) findViewById(R.id.toolbar_title);

        } else if (layoutResID != R.layout.activity_base) {
            //添加新的布局
            View view = LayoutInflater.from(this).inflate(layoutResID, null);
            contentView.addView(view, new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            initView(view);
            initListener();

        }

        defaultToolbarSetting();
        setToolBar();
    }

    public abstract void initListener();

    public abstract void initView(View addView);


    /**
     * Toolbar默认设置
     */
    private void defaultToolbarSetting() {
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_48pt_2x);
        toolbarTitle.setText(R.string.app_name);
        rightTextView.setText(R.string.action_more);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            //隐藏标题栏
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    public abstract void setToolBar();


    public Toolbar getToolbar() {
        return toolbar;
    }

    public int getContentViewId() {
        return R.layout.activity_base;
    }

    /**
     * 设置toolbar右侧图片
     *
     * @param resId
     *         资源Id
     */
    public void setRight(int resId) {
        rightTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, resId, 0);
    }

    /**
     * 设置toolbar右侧文字
     *
     * @param rightStr
     *         字符串
     */
    public void setRight(String rightStr) {
        rightTextView.setText(rightStr);
    }

    /**
     * 设置toolbar右侧图片及点击事件
     *
     * @param resId
     *         图片资源Id
     * @param clickListener
     *         事件监听
     */
    public void setRight(int resId, View.OnClickListener clickListener) {
        rightTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, resId, 0);
        rightTextView.setOnClickListener(clickListener);
    }

    /**
     * 设置menu及条目点击事件的监听
     *
     * @param menuResId
     *         menu资源id
     * @param menuItemClickListener
     *         条目事件监听
     */
    public void setMenu(int menuResId, Toolbar.OnMenuItemClickListener menuItemClickListener) {
        this.menuResId = menuResId;
        setOnMenuItemClickListener(menuItemClickListener);
    }

    /**
     * 设置Navigation
     *
     * @param resId
     *         资源Id
     * @param onClickListener
     *         点击事件
     */
    public void setNavigation(int resId, View.OnClickListener onClickListener) {
        toolbar.setNavigationIcon(resId);
        toolbar.setNavigationOnClickListener(onClickListener);
    }


    /**
     * 设置监听
     *
     * @param menuItemClickListener
     *         设置条目监听器
     */
    private void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener menuItemClickListener) {
        this.mOnMenuItemClickListener = menuItemClickListener;
        toolbar.setOnMenuItemClickListener(mOnMenuItemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuResId != INVALID_MENU) {
            getMenuInflater().inflate(menuResId, menu);
        }
        return true;
    }
}