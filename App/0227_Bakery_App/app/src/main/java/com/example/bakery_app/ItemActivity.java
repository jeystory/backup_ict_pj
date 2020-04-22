package com.example.bakery_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ItemActivity extends BaseActivity {
    Button bt_item01;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        bt_item01 = findViewById(R.id.bt_item01);

        bt_item01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ItemSubActivity.class);
                startActivity(intent);
            }
        });
    }
}