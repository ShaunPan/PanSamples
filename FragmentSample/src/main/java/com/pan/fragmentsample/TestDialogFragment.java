package com.pan.fragmentsample;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Author:Pan
 * Time:2016/5/26 16:10
 * Description:创建DialogFragment的两种方式：
 * 推荐复写onCreateDialog方法，因为自带样式比较适合
 */
public class TestDialogFragment extends DialogFragment {

    private AlertDialog dialog;
    private OnConfirmClickListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnConfirmClickListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_test_dialog, null);

        dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();
        Button cancel = (Button) view.findViewById(R.id.btn_cancel);
        Button confirm = (Button) view.findViewById(R.id.btn_confirm);
        final EditText mUserName = (EditText) view.findViewById(R.id.et_userName);
        final EditText mPassword = (EditText) view.findViewById(R.id.et_password);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onConfirmClick(mUserName.getText().toString(), mPassword.getText().toString());
                dialog.dismiss();
            }
        });


        return dialog;
    }


    //该方式创建Dialog，其布局会自动收缩
     /* @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
            View view = inflater.inflate(R.layout.fragment_test_dialog, container, false);
            return view;
        }*/

    /**
     * 确认事件回调
     */
    public interface OnConfirmClickListener {
        public void onConfirmClick(String userName, String password);
    }

}
