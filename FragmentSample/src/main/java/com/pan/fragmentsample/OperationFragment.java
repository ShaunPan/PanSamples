package com.pan.fragmentsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Author:Pan
 * Time:2016/5/26 12:25
 * Description:
 */
public class OperationFragment extends Fragment {


    public static OperationFragment newInstance() {
        return new OperationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operation, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        final TestListFragment testListFragment = (TestListFragment) getChildFragmentManager().findFragmentById(R.id.fragment_list);
        Button mAddData = (Button) view.findViewById(R.id.btn_add_data);
        Button mClearData = (Button) view.findViewById(R.id.btn_clear_data);
        mAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testListFragment.addData();
            }
        });
        mClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testListFragment.clearData();
            }
        });

    }

}
