package com.pan.imageviewsample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.pan.imageviewsample.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Pan
 * Time:2016/5/20 14:36
 * Description:
 */
public class MainFragment extends ListFragment {

    public static final String TAG = "MainFragment";

    private List<String> list;
    private MainActivity mActivity;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = ((MainActivity) context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add("ImageVIew.ScaleType");
        list.add("ImageVIew.ScaleType");
        list.add("ImageVIew.ScaleType");
        list.add("ImageVIew.ScaleType");
        list.add("ImageVIew.ScaleType");
        list.add("ImageVIew.ScaleType");
        list.add("ImageVIew.ScaleType");
        list.add("ImageVIew.ScaleType");
        list.add("ImageVIew.ScaleType");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mActivity.callBack(position);
    }

    public interface ItemCallBack {
        public void callBack(int position);
    }


}
