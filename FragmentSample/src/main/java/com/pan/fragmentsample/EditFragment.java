package com.pan.fragmentsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Author:Pan
 * Time:2016/5/31 15:28
 * Description:
 */
public class EditFragment extends Fragment {

    public static final String EDIT_FRAGMENT = EditFragment.class.getSimpleName();
    public static final int RESPONSE_CODE = 0x010;

    public static EditFragment newInstance() {
        return new EditFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        final EditText nameEditText = (EditText) view.findViewById(R.id.et_name);

        Button commitButton = (Button) view.findViewById(R.id.btn_commit);
        commitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backResult(nameEditText.getText().toString());
            }
        });
        return view;
    }

    private void backResult(String name) {

        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();
        intent.putExtra("name", name);
        getTargetFragment().onActivityResult(ContentFragment.REQUEST_CODE, RESPONSE_CODE, intent);

        getFragmentManager().popBackStack();
    }
}
