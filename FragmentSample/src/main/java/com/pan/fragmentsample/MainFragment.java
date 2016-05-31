package com.pan.fragmentsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Pan
 * Time:2016/5/25 17:38
 * Description:
 */
public class MainFragment extends ListFragment {

    public static final int REQUEST_CODE = 0x100;
    public static final String MAIN_FRAGMENT = MainFragment.class.getSimpleName();
    private List<String> list;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add("ListFragment");
        list.add("DialogFragment");
        list.add("DataCallbackInSameActivity");
        list.add("DataCallbackInDifferentActivity");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list));
    }

    public void addFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent;
        switch (position) {
            case 0:
                addFragment(OperationFragment.newInstance());
                break;
            case 1:
                TestDialogFragment testDialogFragment = new TestDialogFragment();
                testDialogFragment.show(getFragmentManager(), "TestDialogFragment");
                break;
            case 2:
                //同一个Activity内Fragment之间的数据回调
                intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
                break;
            case 3:
                //不同的Activity内Fragment之间的数据回调
                intent = new Intent(getActivity(), SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ContentFragment.RESULT_CODE && data != null) {
            Log.i(MAIN_FRAGMENT, data.getStringExtra(ContentFragment.CONTENT_FRAGMENT));
        }
    }
}
