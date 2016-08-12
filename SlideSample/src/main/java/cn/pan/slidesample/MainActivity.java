package cn.pan.slidesample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ArrayList dataList;
    private RecyclerView mRecyclerView;
    private int mDistanceY;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        initView();
    }

    private List loadData() {
        dataList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            dataList.add("item" + i);
        }
        return dataList;
    }

    private void initView() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mRecyclerView == null) {
            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new DataAdapter(this, dataList));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
                int toolbarHeight = mToolbar.getBottom();

                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= toolbarHeight) {
                    float scale = (float) mDistanceY / toolbarHeight;
                    float alpha = scale * 255;
                    mToolbar.setBackgroundColor(Color.argb((int) alpha, 128, 0, 0));
                } else {
                    mToolbar.setBackgroundResource(R.color.colorTitle);
                }

            }
        });
    }


}
