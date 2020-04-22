package com.example.bakery_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class UserActivity extends BaseActivity {
    ViewPager pager;
    Button bt_user_order, bt_user_point, bt_user_review, bt_user_qa, bt_user_info;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        pager = (ViewPager)findViewById(R.id.pager);
        Button bt_user_order = (Button)findViewById(R.id.bt_user_order);
        Button bt_user_point = (Button)findViewById(R.id.bt_user_point);
        Button bt_user_review = (Button)findViewById(R.id.bt_user_review);
        Button bt_user_qa = (Button)findViewById(R.id.bt_user_qa);
        Button bt_user_info = (Button)findViewById(R.id.bt_user_info);

        pager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(0);

        bt_user_order.setOnClickListener(movePageListener);
        bt_user_order.setTag(0);
        bt_user_point.setOnClickListener(movePageListener);
        bt_user_point.setTag(1);
        bt_user_review.setOnClickListener(movePageListener);
        bt_user_review.setTag(2);
        bt_user_qa.setOnClickListener(movePageListener);
        bt_user_qa.setTag(3);
        bt_user_info.setOnClickListener(movePageListener);
        bt_user_info.setTag(4);

    }

    View.OnClickListener movePageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag = (int)v.getTag();
            Log.d("my", tag + ":tag");
            pager.setCurrentItem(tag);

        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter
    {
        public pagerAdapter(FragmentManager fm )
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position)
            {
                case 0:
                    return new FragUserOrder();
                case 1:
                    return new FragUserPoint();
                case 2:
                    return new FragUserReview();
                case 3:
                    return new FragUserQA();
                case 4:
                    return new FragUserInfo();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // total page count
            return 5;
        }
    }
}
