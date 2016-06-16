package com.pan.viewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Author:Pan
 * Time:2016/6/12 17:08
 * Description:
 */
public class LayoutAnimActivity extends AppCompatActivity {

    private ArrayList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_anim);

        initData();

        ListView listView = (ListView) findViewById(R.id.lv_listView);
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.list_anim);
//        LayoutAnimationController controller = new LayoutAnimationController(animation);
//        controller.setDelay(0.5f);
//        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
//        listView.setLayoutAnimation(controller);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.list_item, R.id.name, list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(LayoutAnimActivity.this, "click item",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add("Item" + i);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.enter_anim,R.anim.exit_anim);
    }
}
