package com.pan.imageviewsample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.pan.imageviewsample.fragment.ImageTypeFragment;
import com.pan.imageviewsample.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.ItemCallBack {

    private MainFragment mainFragment;
    private ImageTypeFragment imageTypeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        showFragment(-1);
    }

    private void showFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case -1:
                mainFragment = MainFragment.newInstance();
                transaction.add(R.id.fl_container, mainFragment, "MainFragment");
                break;
            case 0:
                imageTypeFragment = ImageTypeFragment.newInstance();
                transaction.add(R.id.fl_container, imageTypeFragment, ImageTypeFragment.IMAGE_TYPE_FRAGMENT);
                transaction.addToBackStack(ImageTypeFragment.IMAGE_TYPE_FRAGMENT);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mainFragment != null) {
            transaction.hide(mainFragment);
        }
    }


    @Override
    public void callBack(int position) {
        showFragment(position);
    }
}
