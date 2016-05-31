package com.pan.fragmentsample;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TestDialogFragment.OnConfirmClickListener {

    public static final String TAG = "LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Activity onCreate");
        setContentView(R.layout.activity_main);
        addFragment(MainFragment.newInstance());

    }

    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment, TAG)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Activity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Activity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Activity onDestroy");
    }

    @Override
    public void onConfirmClick(String userName, String password) {
        Toast.makeText(this, "接收到的信息：" + userName + "," + password, Toast.LENGTH_SHORT).show();
    }
}
