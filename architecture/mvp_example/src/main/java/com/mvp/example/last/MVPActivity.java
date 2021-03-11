package com.mvp.example.last;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.malin.video.R;


public class MVPActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_activity_layout);
        initFragment();
    }

    private void initFragment() {
        MVPFragment fragment = new MVPFragment();

        //Presenter注入
        fragment.setPresenter(new CommonPresenter(fragment));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frameLayout, fragment);
        transaction.commitAllowingStateLoss();
    }
}
