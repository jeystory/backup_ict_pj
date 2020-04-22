package com.example.bakery_app;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class HomeActivity extends BaseActivity {
    ViewFlipper viewFlipper;
    ImageView[] imgHomeMenu = new ImageView[3];
    ImageView[] imgHomeEvent = new ImageView[3];
    Integer[] event_hid = {R.id.imgHomeEvent01, R.id.imgHomeEvent02, R.id.imgHomeEvent03 };
    Integer[] menu_hid = {R.id.imgHomeMenu01, R.id.imgHomeMenu02, R.id.imgHomeMenu03};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewFlipper = findViewById(R.id.viewFilper);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();


        for(int i=0;i<3;i++){
            imgHomeEvent[i] = findViewById(event_hid[i]);
            imgHomeMenu[i] = findViewById(menu_hid[i]);
        }

        imgHomeEvent[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_event = new Intent(HomeActivity.this, EventActivity.class);
                intent_event.putExtra("event_no", "0");
                startActivity(intent_event);
                finish();
            }
        });
        imgHomeEvent[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_event = new Intent(HomeActivity.this, EventActivity.class);
                intent_event.putExtra("event_no", "1");
                startActivity(intent_event);
                finish();
            }
        });
        imgHomeEvent[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_event = new Intent(HomeActivity.this, EventActivity.class);
                intent_event.putExtra("event_no", "2");
                startActivity(intent_event);
                finish();
            }
        });


    }
}
