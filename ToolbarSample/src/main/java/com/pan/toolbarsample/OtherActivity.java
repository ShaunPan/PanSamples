package com.pan.toolbarsample;

import android.os.Bundle;
import android.view.Menu;

/**
 * Author: Pan
 * Date:   2016/7/8
 * Description:
 */
public class OtherActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_other, menu);
        return true;
    }
}
