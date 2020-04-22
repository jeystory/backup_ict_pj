package com.example.bakery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderProcess extends BaseActivity {

    Spinner spinner_pay;

    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_process);

        arrayList = new ArrayList<>();
        arrayList.add("간편결제");
        arrayList.add("체크카드");
        arrayList.add("신용카드");
        arrayList.add("계좌이체");

        spinner_pay = findViewById(R.id.spinner_pay);


        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, arrayList);
        spinner_pay.setAdapter(arrayAdapter);

        spinner_pay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });


    }
}
