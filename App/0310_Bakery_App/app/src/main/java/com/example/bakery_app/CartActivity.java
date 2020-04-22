package com.example.bakery_app;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CartActivity extends BaseActivity {
    Button btn_cart_order;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        btn_cart_order = findViewById(R.id.btn_cart_order);
        btn_cart_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_order = new Intent(CartActivity.this, OrderProcess.class);
                startActivity(intent_order);
            }
        });
    }
}
