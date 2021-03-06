package com.pan.toolbarsample;

import android.view.View;
import android.widget.Toast;

/**
 * Author: Pan
 * Date:   2016/7/6
 * Description:
 */
public class NextActivity extends BaseActivity {


    @Override
    public void setToolBar() {

        // 设置标题
        setTitle(R.string.app_name);

        // 设置Toolbar右侧按钮
        setRight(R.mipmap.ic_mode_edit_white_36dp, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NextActivity.this, "Edit clicked", Toast.LENGTH_SHORT).show();
            }
        });


        // 设置菜单
        /*setMenu(R.menu.menu, new Toolbar.OnMenuItemClickListener() {
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
                    Toast.makeText(NextActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });*/

        // 设置navigation
        setNavigation(R.mipmap.ic_arrow_back_white_48pt_2x, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NextActivity.this, "NextActivity", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initView(View view) {

    }
}
