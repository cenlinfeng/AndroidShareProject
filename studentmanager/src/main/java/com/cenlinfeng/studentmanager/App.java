package com.cenlinfeng.studentmanager;

import android.app.Application;

import com.cenlinfeng.studentmanager.util.DB;

public class App extends Application {

    public static DB db;

    @Override
    public void onCreate() {
        super.onCreate();


        db = new DB(this);
    }

    public static DB getDb() {
        return db;
    }


}