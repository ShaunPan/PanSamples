package com.pan.fragmentsample;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

/**
 * Author:Pan
 * Time:2016/5/26 16:10
 * Description:Fragment间数据传递
 */
public class DataTransferFragment extends DialogFragment {

    private AlertDialog dialog;
    private String bundleString;

    public static DataTransferFragment newInstance(Bundle bundle) {
        DataTransferFragment fragment = new DataTransferFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            bundleString = bundle.getString("DataTransferFragment");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());
        textView.setText(bundleString);
        dialog = new AlertDialog.Builder(getActivity())
                .setView(textView)
                .create();

        return dialog;
    }


}
