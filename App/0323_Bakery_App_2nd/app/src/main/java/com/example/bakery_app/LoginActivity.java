package com.example.bakery_app;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import java.net.Socket;

public class LoginActivity extends BaseActivity {
    Button btn_login, btn_login_join;

    EditText login_id, login_pwd;


    DBConnection dbConnection = new DBConnection();
    String result;  //db test
    Socket s;       //db test
    Handler handler = new Handler();    //db test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        btn_login_join = findViewById(R.id.btn_login_join);
        login_id = findViewById(R.id.login_id);
        login_pwd = findViewById(R.id.login_pwd);
        //list = findViewById(R.id.list); //db_test


        btn_login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                SaveSharedPreference.setUserName(LoginActivity.this, login_id.getText().toString());

                login_id.setText("");
                login_pwd.setText("");

                Intent intent_login = new Intent(LoginActivity.this, UserActivity.class);
                startActivity(intent_login);
                finish();

                /*
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                       //String msg_login;
                        String snd_msg = "login:" + login_id.getText() + ":" + login_pwd.getText();
                        result = dbConnection.callServer(s, "10.0.2.2", 7888, snd_msg);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                String[] data = null;
                                try{
                                    data = result.split(",");
                                   if(data[0].equals("login_ok")){
                                       dbConnection.setId(login_id.getText().toString());
                                       dbConnection.setPassword(login_pwd.getText().toString());


                                       SaveSharedPreference.setUserName(LoginActivity.this, login_id.getText().toString());

                                       login_id.setText("");
                                       login_pwd.setText("");

                                       Intent intent_login = new Intent(LoginActivity.this, UserActivity.class);
                                       startActivity(intent_login);
                                       finish();


                                   } else {
                                      login_id.setText("");
                                      login_pwd.setText("");

                                   }

                                } catch (Exception e){

                                }
                            }
                        });
                    }
                }).start();*/
            }


        });

        btn_login_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_join = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent_join);
                finish();
            }
        });
    }


}
