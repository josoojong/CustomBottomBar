package com.jsj.custombottombar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_slide)
    public void showSlideViewPager() {
        startActivity(new Intent(MainActivity.this, SlideViewPagerActivity.class));
    }

    @OnClick(R.id.btn_fix)
    public void showFixViewPager() {
        startActivity(new Intent(MainActivity.this, FixViewPagerActivity.class));
    }
}
