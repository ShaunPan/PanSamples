package com.pan.fragmentsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Author:Pan
 * Time:2016/5/31 14:57
 * Description:接收数据的Fragment
 */
public class ContentFragment extends Fragment {

    public static final int REQUEST_CODE = 0x001;
    public static final int RESULT_CODE = 0x101;
    public static final String CONTENT_FRAGMENT = ContentFragment.class.getSimpleName();
    private TextView content;

    public static ContentFragment newInstance() {
        return new ContentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final EditFragment editFragment = EditFragment.newInstance();
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        content = (TextView) view.findViewById(R.id.tv_content);
        Button differentActivity = (Button) view.findViewById(R.id.btn_different_activity);
        Button button = (Button) view.findViewById(R.id.btn_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //当一个Fragment启动另外一个Fragment时，设置setTargetFragment()方法后，
                //目标Fragment可以将数据回调到启动的Fragment
                editFragment.setTargetFragment(ContentFragment.this, REQUEST_CODE);

                getFragmentManager().beginTransaction()
                        .hide(ContentFragment.this)
                        .add(R.id.fl_container, editFragment, EditFragment.EDIT_FRAGMENT)
                        .addToBackStack(null)
                        .commit();
            }
        });

        differentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(CONTENT_FRAGMENT, CONTENT_FRAGMENT);
                getActivity().setResult(RESULT_CODE, intent);
                getActivity().finish();
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }

        String name = data.getStringExtra("name");
        content.setText(name);
    }
}
