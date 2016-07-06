package com.pan.toolbarsample;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
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
            View addView = LayoutInflater.from(this).inflate(layoutResID, null);
            contentView.addView(addView, new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            initView();
            initListener();

        }

        //不要改变下面三者的顺序
        beforeSetActionBar();
        setActionBar();
        afterSettingActionBar();
    }

    private void beforeSetActionBar() {
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_48pt_2x);
        toolbarTitle.setText(R.string.app_name);
        rightTextView.setText(R.string.action_more);
    }

    public abstract void setActionBar();

    private void afterSettingActionBar() {
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
        //        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);

    }


    private void initListener() {

    }

    private void initView() {

    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public int getContentViewId() {
        return R.layout.activity_base;
    }

    protected int getFragmentContentId() {
        return R.id.layout_content;
    }


}
