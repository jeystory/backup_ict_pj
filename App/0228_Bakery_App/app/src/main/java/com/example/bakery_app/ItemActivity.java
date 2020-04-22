package com.example.bakery_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class ItemActivity extends BaseActivity {
    ViewPager item_pager;
    Button btn_cookie, btn_bread, btn_dessert, btn_sandwitch, btn_drink;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        item_pager = (ViewPager)findViewById(R.id.item_pager);
        btn_cookie = findViewById(R.id.btn_cookie);
        btn_bread = findViewById(R.id.btn_bread);
        btn_dessert = findViewById(R.id.btn_dessert);
        btn_sandwitch = findViewById(R.id.btn_sandwitch);
        btn_drink = findViewById(R.id.btn_drink);

        item_pager.setAdapter(new ItemActivity.pagerAdapter(getSupportFragmentManager()));
        item_pager.setCurrentItem(0);

        btn_cookie.setOnClickListener(movePageListener);
        btn_cookie.setTag(0);
        btn_bread.setOnClickListener(movePageListener);
        btn_bread.setTag(1);
        btn_dessert.setOnClickListener(movePageListener);
        btn_dessert.setTag(2);
        btn_sandwitch.setOnClickListener(movePageListener);
        btn_sandwitch.setTag(3);
        btn_drink.setOnClickListener(movePageListener);
        btn_drink.setTag(4);
    }

    View.OnClickListener movePageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag = (int)v.getTag();
            //Log.d("my", tag + ":tag");
            item_pager.setCurrentItem(tag);

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
                    return new FragItemCookie();
                case 1:
                    return new FragItemBread();
                case 2:
                    return new FragItemCookie();
                case 3:
                    return new FragItemCookie();
                case 4:
                    return new FragItemCookie();
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