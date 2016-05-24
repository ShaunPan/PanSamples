package com.pan.basesample.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pan.basesample.R;

/**
 * Author:Pan
 * Time:2016/5/23 22:31
 * Description:
 */
public abstract class AppActivity extends BaseActivity {

    protected abstract BaseFragment getFirstFragment();

    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        if (getIntent() != null) {
            handleIntent(getIntent());
        }

        //避免重复添加fragment
        if (getSupportFragmentManager().getFragments() == null) {
            BaseFragment firstFragment = getFirstFragment();
            if (firstFragment != null) {
                addFragment(firstFragment);
            }
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_base;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.fragment_container;
    }
}
