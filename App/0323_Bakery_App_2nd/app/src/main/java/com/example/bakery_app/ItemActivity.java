package com.example.bakery_app;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class ItemActivity extends BaseActivity {
    Button[] btn_item =new Button[4];

    Fragment frag_item_list;
    Integer[] menu_id = {R.id.btn_cookie,R.id.btn_bread, R.id.btn_dessert, R.id.btn_sandwich };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        for(int i=0;i<4;i++)    btn_item[i] = findViewById(menu_id[i]);

        frag_item_list = new FragItemList(0);
        getSupportFragmentManager().beginTransaction().replace(R.id.item_layout,frag_item_list).commit();
        btn_item[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectItemList(0);
            }
        });

        btn_item[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectItemList(1);
            }
        });

        btn_item[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectItemList(2);
            }
        });

        btn_item[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectItemList(3);
            }
        });
    }

    public void selectItemList(int sel_subItem){


        // 선택된 아이텐 분류 표시
        for(int i=0;i<4;i++){
            if(i == sel_subItem){
                btn_item[i].setTextColor(Color.BLUE);
            } else {
                btn_item[i].setTextColor(Color.GRAY);
            }
        }

        frag_item_list = new FragItemList(sel_subItem);
        getSupportFragmentManager().beginTransaction().replace(R.id.item_layout,frag_item_list).commit();

    }
}