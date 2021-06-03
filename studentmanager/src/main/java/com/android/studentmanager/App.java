package com.android.studentmanager;

import android.app.Application;

import com.android.studentmanager.util.DB;
import com.android.studentmanager.util.DBHelper;

public class App extends Application {//需要在AndroidManifest.xml文件设置android:name=".App"

    private static DB db;
    private static DBHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();


        db = new DB(this);
    }

    public static DB getDb() {
        return db;
    }

    public static DBHelper getDbHelper() {
        if (dbHelper == null) {
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }


}