package com.example.baseactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SubActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }
}
