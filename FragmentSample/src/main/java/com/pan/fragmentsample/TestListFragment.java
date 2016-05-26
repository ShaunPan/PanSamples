package com.pan.fragmentsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Pan
 * Time:2016/5/26 10:54
 * Description:演示ListFragment的使用
 */
public class TestListFragment extends ListFragment {

    private List list;
    private ArrayAdapter<String> adapter;

    public static TestListFragment newInstance() {
        return new TestListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);
        setEmptyText("暂无数据");
    }

    private void initData() {
        list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add("Data" + i);
        }
    }

    public void addData() {
        initData();
        adapter.addAll(list);
        adapter.notifyDataSetChanged();
    }

    public void clearData() {
        adapter.clear();
        adapter.notifyDataSetChanged();
    }

}
