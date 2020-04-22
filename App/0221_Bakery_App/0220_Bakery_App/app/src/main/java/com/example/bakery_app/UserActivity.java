package com.example.bakery_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class UserActivity extends BaseActivity {
    Button bt_user_point, bt_user_review, bt_user_qa, bt_user_info;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        bt_user_info = findViewById(R.id.bt_user_info);
        bt_user_review = findViewById(R.id.bt_user_review);
        bt_user_qa = findViewById(R.id.bt_user_qa);
        bt_user_point = findViewById(R.id.bt_user_point);

        bt_user_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserPointActivity.class);
                startActivity(intent);
            }
        });

        bt_user_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserReviewActivity.class);
                startActivity(intent);
            }
        });

        bt_user_qa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserQAActivity.class);
                startActivity(intent);
            }
        });

        bt_user_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserReviewActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }
}
