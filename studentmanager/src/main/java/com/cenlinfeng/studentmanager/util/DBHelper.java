package com.cenlinfeng.studentmanager.util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.cenlinfeng.studentmanager.App;
import com.cenlinfeng.studentmanager.bean.Student;
import com.cenlinfeng.studentmanager.bean.Teacher;

public class DBHelper {
    /***
     * @param teacher 传入一个teacher对象
     * @return 不是-1的话就是插入数据成功了
     */
    public long addTeacher(Teacher teacher) {
        SQLiteDatabase writableDatabase = App.getDb().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB.ACCOUNT, teacher.getAccount());
        values.put(DB.PASSWORD, teacher.getPassword());
        values.put(DB.NAME, teacher.getName());
        values.put(DB.CLASS_NAME, teacher.getClassName());
        values.put(DB.DEPARTMENT_NAME, teacher.getDepartmentName());
        values.put(DB.SCHOOL_NAME, teacher.getSchoolName());
        long insert = writableDatabase.insert(DB.TEACHER_TABLE_NAME, null, values);
        values.clear();
        writableDatabase.close();
        return insert;
    }

    /**
     * @param student 传入一个学生对象
     * @return 不是-1的话就是插入成功
     */
    public long addStudent(Student student) {
        SQLiteDatabase db = App.getDb().getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB.CLASS_NAME, student.getClassName());
        values.put(DB.DEPARTMENT_NAME, student.getDepartmentName());
        values.put(DB.SCHOOL_NAME, student.getSchoolName());
        values.put(DB.NAME, student.getName());
        values.put(DB.SEX, student.getSex());
        values.put(DB.AGE, student.getAge());
        values.put(DB.STUDENT_NUMBER, student.getStudentNumber());
        values.put(DB.ACCOUNT, student.getAccount());
        values.put(DB.PASSWORD, student.getPassword());
        values.put(DB.LANGUAGE_FRACTION, student.getLanguageFraction());
        values.put(DB.MATH_FRACTION, student.getMathFraction());
        values.put(DB.ENGLISH_FRACTION, student.getEnglishFraction());
        long insert = db.insert(DB.TEACHER_TABLE_NAME, null, values);
        return insert;
    }

}