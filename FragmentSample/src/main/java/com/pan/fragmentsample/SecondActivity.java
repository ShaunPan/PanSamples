package com.pan.fragmentsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Author:Pan
 * Time:2016/5/31 14:51
 * Description:模拟在同一个Activity中的Fragment传递数据
 */
public class SecondActivity extends AppCompatActivity {

    private ContentFragment mContentFragment;
    private EditFragment mEditFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (mContentFragment == null) {
            mContentFragment = ContentFragment.newInstance();
        }

        if (mEditFragment == null) {
            mEditFragment = EditFragment.newInstance();
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container, mContentFragment, ContentFragment.CONTENT_FRAGMENT)
                .commit();
    }
}
