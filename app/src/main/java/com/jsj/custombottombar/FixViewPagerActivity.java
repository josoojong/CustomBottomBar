package com.jsj.custombottombar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by josoojong on 2017. 10. 31..
 */

public class FixViewPagerActivity extends AppCompatActivity{

    ViewPager pager;
    TabLayout tabLayout;

    TabPagerAdapter mTabPagerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix);

        init();
    }

    void init() {
        pager = (ViewPager) findViewById(R.id.fix_pager);
        tabLayout = (TabLayout) findViewById(R.id.tl_bottombar);

        tabLayout.setSelectedTabIndicatorHeight(0);
        mTabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), this);
        pager.setAdapter(mTabPagerAdapter);
        tabLayout.setupWithViewPager(pager);

        final Animation bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(mTabPagerAdapter.getTabView(i));
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                System.out.println("select : "+tab.getPosition());
                ImageView icon = (ImageView)tab.getCustomView().findViewById(R.id.icon);
                TextView title = (TextView)tab.getCustomView().findViewById(R.id.title);
                icon.setColorFilter(Color.RED);
                title.setTextColor(Color.RED);
                icon.startAnimation(bounce);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                System.out.println("unselect : "+tab.getPosition());
                ImageView icon = (ImageView)tab.getCustomView().findViewById(R.id.icon);
                TextView title = (TextView)tab.getCustomView().findViewById(R.id.title);
                icon.setColorFilter(Color.GRAY);
                title.setTextColor(Color.GRAY);
                icon.clearAnimation();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                System.out.println("reselect : "+tab.getPosition());
                ImageView icon = (ImageView)tab.getCustomView().findViewById(R.id.icon);
                icon.clearAnimation();
                icon.startAnimation(bounce);
            }
        });
    }
}
