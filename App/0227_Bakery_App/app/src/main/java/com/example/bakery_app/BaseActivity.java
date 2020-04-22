package com.example.bakery_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public void setContentView(int layoutResID) {
        LinearLayout fullView = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout activityContainer = (FrameLayout) fullView.findViewById(R.id.activity_content);
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
        switch (item.getItemId()) {

            case R.id.menu_home:
                //Toast.makeText(getApplicationContext(),"메뉴1 클릭", Toast.LENGTH_SHORT).show();
                Intent intent_home = new Intent(this, HomeActivity.class);
                startActivity(intent_home);
                return true;

            case R.id.menu_item:
                //Toast.makeText(getApplicationContext(),"메뉴2 클릭", Toast.LENGTH_SHORT).show();
                Intent intent_item = new Intent(this, ItemActivity.class);
                //Intent intent_item = new Intent(this, ItemSubActivity.class);
                startActivity(intent_item);
                return true;
            case R.id.menu_search:
                Intent intent_search = new Intent(this, SearchActivity.class);
                startActivity(intent_search);

                return true;
            case R.id.menu_user:
                Intent intent_user = new Intent(this, UserActivity.class);
                startActivity(intent_user);
                return true;
            case R.id.menu_cart:
                Intent intent_cart = new Intent(this, CartActivity.class);
                startActivity(intent_cart);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
