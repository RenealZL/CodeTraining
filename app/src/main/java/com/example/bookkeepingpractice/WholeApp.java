package com.example.bookkeepingpractice;

import android.app.Application;

import com.example.bookkeepingpractice.db.DBManager;

public class WholeApp extends Application {
    public void onCreate(){
        super.onCreate();
        DBManager.initDB(getApplicationContext());
    }

}
