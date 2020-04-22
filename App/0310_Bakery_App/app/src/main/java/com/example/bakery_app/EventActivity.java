package com.example.bakery_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends BaseActivity {
    TextView txtEventName01, txtEventName02;
    Button btn_event_next, btn_event_prev;
    ImageView imgEventDetail;
    String[] str_EventName = {"수퍼 히어로 피큐어", "화이트데이 딸기 브라우니" , "발렌타인데이 딸기무스케익"};
    int[] imgArr = {R.drawable.event_detail_01, R.drawable.event_detail_02, R.drawable.event_detail_03};
    int  i_cur_event_no = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        txtEventName01 = findViewById(R.id.txtEventName01);
        txtEventName02 = findViewById(R.id.txtEventName02);

        btn_event_next = findViewById(R.id.btn_ev_next);
        btn_event_prev = findViewById(R.id.btn_ev_prev);

        imgEventDetail = findViewById(R.id.imgEventDetail);


        Intent event_intent = getIntent();
        String cur_event_no = event_intent.getStringExtra("event_no");
        i_cur_event_no = Integer.parseInt(cur_event_no);

        showSelectedEvent();

        btn_event_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i_cur_event_no == 0) i_cur_event_no = 2;
                else i_cur_event_no--;
                showSelectedEvent();
            }
        });

        btn_event_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i_cur_event_no == 2) i_cur_event_no = 0;
                else i_cur_event_no++;
                showSelectedEvent();
            }
        });

    }

    public void showSelectedEvent(){
        if(i_cur_event_no < 0 || i_cur_event_no > 2){
            i_cur_event_no = 0;
        }

        imgEventDetail.setImageResource(imgArr[i_cur_event_no]);
        txtEventName01.setText(str_EventName[i_cur_event_no]);
        txtEventName02.setText(str_EventName[i_cur_event_no]);


    }
}
