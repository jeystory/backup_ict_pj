package com.example.bakery_app;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class DBConnection {
    String id, password;

    public DBConnection(){}

    public DBConnection(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    //db_test
    public String callServer(Socket s, String ip, int port, String msg){
        String str = null;
        BufferedWriter writer = null;
        BufferedReader reader = null;

        try {
            s = new Socket(ip, port);
            writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            msg = msg+System.getProperty("line.separator");
            writer.write(msg);
            writer.flush();

            str = reader.readLine();

        } catch (Exception e){
            Log.d("my_error", "error 1 "  + e);
        } finally {
            try {
                s.close();
            } catch (Exception e){
                Log.d("my_error", "error 2"  + e);
            }
        }
        return str;
    }
}
