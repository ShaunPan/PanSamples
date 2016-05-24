package com.pan.imageviewsample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Pan
 * Time:2016/5/20 14:36
 * Description:
 */
public class ImageTypeFragment extends ListFragment {

    public static final String IMAGE_TYPE_FRAGMENT = "ImageTypeFragment";

    private List<String> list;

    public static ImageTypeFragment newInstance() {
        return new ImageTypeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add("matrix");
        list.add("fitXY");
        list.add("fitStart");
        list.add("fitCenter");
        list.add("fitEnd");
        list.add("center");
        list.add("centerCrop");
        list.add("centerInside");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case 0:

                break;
            case 1:

                break;
            default:
                break;
        }

    }


    private void hideFragment(FragmentTransaction transaction) {
        //        if (mainFragment != null) {
        //            transaction.hide(mainFragment);
        //        }
    }
}
