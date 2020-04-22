package com.example.bakery_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    FrameLayout activityContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public void setContentView(int layoutResID) {
        LinearLayout fullView = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //툴바 사용여부 결정(기본적으로 사용)
        if(useToolbar()){
            setSupportActionBar(toolbar);
            //setTitle("툴바예제");
        } else {
            toolbar.setVisibility(View.GONE);
        }
    }

    //툴바를 사용할지 말지 정함
    protected boolean useToolbar() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //LayoutInflater inflater;
        //activityContainer.removeAllViews();
        switch (item.getItemId()) {
            case R.id.menu_home:
                Intent intent_home = new Intent(this, HomeActivity.class);
                startActivity(intent_home);
                //inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //inflater.inflate(R.layout.activity_home, activityContainer, true);
                return true;

            case R.id.menu_item:
                //Toast.makeText(getApplicationContext(),"메뉴2 클릭", Toast.LENGTH_SHORT).show();
                Intent intent_item = new Intent(this, ItemActivity.class);
                startActivity(intent_item);
                finish();
                return true;

            case R.id.menu_user:
                if(SaveSharedPreference.getUserName(this).length() == 0){
                Intent intent_user = new Intent(this, LoginActivity.class);
                startActivity(intent_user);
                this.finish();
                } else {
                    //Intent intent_user = new Intent(this, UserActivity.class);    //회원 관련 메뉴 삭제하지 말기
                    //Intent intent_user = new Intent(this, UserActivity.class);
                    //startActivity(intent_user);
                    //this.finish();
                    Intent intent_cart = new Intent(this, CartActivity.class);
                    //intent_cart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent_cart);
                    this.finish();

                }
                return true;


            case R.id.menu_cart:
                if(SaveSharedPreference.getUserName(this).length() == 0){
                    Intent intent_user = new Intent(this, LoginActivity.class);
                    startActivity(intent_user);
                    this.finish();
                }else {
                    Intent intent_cart = new Intent(this, CartActivity.class);
                    //intent_cart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent_cart);
                    this.finish();
                }
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
