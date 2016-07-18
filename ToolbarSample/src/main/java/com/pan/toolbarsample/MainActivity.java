package com.pan.toolbarsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Toolbar的简单使用以及封装
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
    }

    public void onNextClicked(View view) {
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }

    public void onOtherClicked(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }

    public void onThirdClicked(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }


    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // 设置支持toolbar
        setSupportActionBar(toolbar);
        // 设置标题，注意：标题受label影响
        toolbar.setTitle(R.string.app_name);
        // 设置标题颜色
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        // 设置子标题
        toolbar.setSubtitle(R.string.sub_title);
        // 设置子标题颜色
        toolbar.setSubtitleTextColor(getResources().getColor(android.R.color.white));
        // 设置logo
        toolbar.setLogo(R.mipmap.ic_launcher);
        // 设置导航图标，例如：侧滑图标
        toolbar.setNavigationIcon(R.mipmap.ic_menu_white_36pt_2x);
        // 设置菜单点击事件
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String msg = "";
                switch (item.getItemId()) {
                    case R.id.action_edit:
                        msg += "click edit";
                        break;
                    case R.id.action_share:
                        msg += "click share";
                        break;
                    case R.id.action_settings:
                        msg += "click more";
                        break;
                    default:
                        break;
                }

                if (!msg.equals("")) {
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
