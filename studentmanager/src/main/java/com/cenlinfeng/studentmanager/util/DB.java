package com.cenlinfeng.studentmanager.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    private static final int version = 1;
    public static final String DB_NAME = "STUDENT_MANAGER";

    public static final String STUDENT_TABLE_NAME = "student";
    public static final String TEACHER_TABLE_NAME = "teacher";

    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String SEX = "sex";
    public static final String SCHOOL_NAME = "school_name";
    public static final String DEPARTMENT_NAME = "department_name";
    public static final String CLASS_NAME = "class_name";
    public static final String STUDENT_NUMBER = "student_number";

    public static final String ACCOUNT = "account";
    public static final String PASSWORD = "password";

    public static final String LANGUAGE_FRACTION = "language_fraction";
    public static final String MATH_FRACTION = "math_fraction";
    public static final String ENGLISH_FRACTION = "english_fraction";

    private static final String CREATE_STUDENT_TABLE = "CREATE TABLE IF NOT EXISTS " + STUDENT_TABLE_NAME + "("
            + _ID + " integer primary key autoincrement,"
            + NAME + " varchar(25)," + AGE + " integer," + SEX + " integer,"
            + SCHOOL_NAME + " varchar(25)," + DEPARTMENT_NAME + " varchar(25),"
            + CLASS_NAME + " varchar(25)," + STUDENT_NUMBER + " varchar(25),"
            + ACCOUNT + " varchar(25)," + PASSWORD + " varchar(25),"
            + LANGUAGE_FRACTION + " varchar(25)," + MATH_FRACTION + " varchar(25)," + ENGLISH_FRACTION + " varchar(25))";

    private static final String CREATE_TEACHER_TABLE = "CREATE TABLE IF NOT EXISTS " + TEACHER_TABLE_NAME + "("
            + _ID + " integer primary key autoincrement,"
            + NAME + " varchar(25)," + SCHOOL_NAME + " varchar(25)," + DEPARTMENT_NAME + " varchar(25),"
            + CLASS_NAME + " varchar(25)," + ACCOUNT + " varchar(25)," + PASSWORD + " varchar(25))";


    public DB(@Nullable Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(Utils.TAG, "创建数据表");

        Log.d(Utils.TAG, "CREATE_STUDENT_TABLE = " + CREATE_STUDENT_TABLE);
        Log.d(Utils.TAG, "CREATE_TEACHER_TABLE = " + CREATE_TEACHER_TABLE);

        db.execSQL(CREATE_STUDENT_TABLE);
        db.execSQL(CREATE_TEACHER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}