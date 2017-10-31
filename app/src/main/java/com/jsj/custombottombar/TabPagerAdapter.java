package com.jsj.custombottombar;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by josujong on 2017. 10. 31..
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    Context mContext;

    final int PAGE_NUM = 2;

    String mTitle[] = {"page1", "page2"};

    int mIcon[] = {R.drawable.one, R.drawable.two};

    static final int FRAGMENT1 = 0;
    static final int FRAGMENT2 = 1;

    public TabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    public View getTabView(int position) {
        View view = null;

        view = LayoutInflater.from(mContext).inflate(R.layout.itemtab, null);

        ImageView tabIcon = (ImageView)view.findViewById(R.id.icon);
        Glide.with(mContext).load(mIcon[position]).into(tabIcon);

        TextView tabTitle = (TextView)view.findViewById(R.id.title);
        tabTitle.setText(mTitle[position]);

        if(position == 0) {
            tabIcon.setColorFilter(Color.RED);
            tabTitle.setTextColor(Color.RED);
        } else {
            tabIcon.setColorFilter(Color.GRAY);
            tabTitle.setTextColor(Color.GRAY);
        }

        return view;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case FRAGMENT1: {
                return new Fragment1();
            }
            case FRAGMENT2 : {
                return new Fragment2();
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }
}
