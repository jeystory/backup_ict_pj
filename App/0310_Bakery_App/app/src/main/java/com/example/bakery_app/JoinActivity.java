package com.example.bakery_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.Socket;

public class JoinActivity extends BaseActivity {
    Button btn_join_fin, btn_join_cancel;

    EditText ed_join_id, ed_join_pw, ed_join_pw_ch, ed_join_name, ed_join_addr, ed_join_birth;

    DBConnection dbConnection = new DBConnection();
    String result;  //db test
    Socket s;       //db test
    Handler handler = new Handler();    //db test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        btn_join_cancel = findViewById(R.id.btn_join_cancel);
        btn_join_fin = findViewById(R.id.btn_join_fin);

        ed_join_id = findViewById(R.id.ed_join_id);
        ed_join_pw = findViewById(R.id.ed_join_pw);
        ed_join_pw_ch = findViewById(R.id.ed_join_pw_ch);
        ed_join_name = findViewById(R.id.ed_join_name);
        ed_join_addr = findViewById(R.id.ed_join_addr);
        ed_join_birth = findViewById(R.id.ed_join_birth);

        btn_join_fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //String msg_login;
                        String snd_join_msg = "join:" + ed_join_id.getText() + ":" + ed_join_pw.getText()
                                + ":" + ed_join_pw.getText() + ":" + ed_join_pw.getText();
                        result = dbConnection.callServer(s, "10.0.2.2", 7888, snd_join_msg);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //listView에 배열로 저장
                                String[] data = null;
                                try{
                                    data = result.split(",");
                                    if(data[0].equals("join_ok")){
                                        dbConnection.setId(ed_join_id.getText().toString());
                                        dbConnection.setPassword(ed_join_pw.getText().toString());
                                        //login_id.setText("");
                                        //login_pwd.setText("");

                                        // 가입 완료하면 user page로 이동
                                        Intent intent_user = new Intent(JoinActivity.this, UserActivity.class);
                                        startActivity(intent_user);
                                        finish();


                                    } else {
                                        //아이디가 중복인 경우 가입 처리 실패로 처리 - 입력창 다 지우기
                                    }

                                } catch (Exception e){

                                }
                            }
                        });
                    }
                }).start();


            }
        });

        btn_join_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home_intent = new Intent(JoinActivity.this, HomeActivity.class);
                startActivity(home_intent);
                finish();
            }
        });
    }
}
