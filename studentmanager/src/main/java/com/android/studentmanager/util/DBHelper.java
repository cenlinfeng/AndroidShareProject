package com.android.studentmanager.util;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.studentmanager.App;
import com.android.studentmanager.bean.Student;
import com.android.studentmanager.bean.Teacher;

import java.util.ArrayList;
import java.util.List;

public class DBHelper {
    /***
     * 增加老师
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
     * 增加学生
     *
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
        values.clear();
        db.close();
        return insert;
    }

    /**
     * 获取教师列表
     *
     * @return 返回的是一个 Teacher的List，里面不包括密码
     */
    public List<Teacher> getTeacherList() {
        SQLiteDatabase db = App.getDb().getWritableDatabase();
        Cursor cursor = db.query(DB.TEACHER_TABLE_NAME, null, null, null, null, null, null);
        List<Teacher> teachers = new ArrayList<>();
        while (cursor.moveToNext()) {
            Teacher teacher = new Teacher();
            teacher.setAccount(cursor.getString(cursor.getColumnIndex(DB.ACCOUNT)));
//            teacher.setPassword(cursor.getString(cursor.getColumnIndex(DB.PASSWORD)));
            teacher.setName(cursor.getString(cursor.getColumnIndex(DB.NAME)));
            teacher.setId(cursor.getInt(cursor.getColumnIndex(DB._ID)));
            teacher.setClassName(cursor.getString(cursor.getColumnIndex(DB.CLASS_NAME)));
            teacher.setDepartmentName(cursor.getString(cursor.getColumnIndex(DB.DEPARTMENT_NAME)));
            teacher.setSchoolName(cursor.getString(cursor.getColumnIndex(DB.SCHOOL_NAME)));
            teachers.add(teacher);
        }
        cursor.close();
        db.close();
        return teachers;
    }

    /**
     * 返回一个学生列表
     *
     * @return 返回一个Student的List ，不包括密码
     */
    public List<Student> getStudentList() {
        SQLiteDatabase db = App.getDb().getWritableDatabase();
        Cursor cursor = db.query(DB.STUDENT_TABLE_NAME, null, null, null, null, null, null);
        List<Student> students = new ArrayList<>();
        while (cursor.moveToNext()) {
            Student student = new Student();
            student.setClassName(cursor.getString(cursor.getColumnIndex(DB.CLASS_NAME)));
            student.setDepartmentName(cursor.getString(cursor.getColumnIndex(DB.DEPARTMENT_NAME)));
            student.setSchoolName(cursor.getString(cursor.getColumnIndex(DB.SCHOOL_NAME)));
            student.setName(cursor.getString(cursor.getColumnIndex(DB.NAME)));
            student.setSex(cursor.getInt(cursor.getColumnIndex(DB.SEX)));
            student.setId(cursor.getInt(cursor.getColumnIndex(DB._ID)));
            student.setAge(cursor.getInt(cursor.getColumnIndex(DB.AGE)));
            student.setStudentNumber(cursor.getString(cursor.getColumnIndex(DB.STUDENT_NUMBER)));
            student.setAccount(cursor.getString(cursor.getColumnIndex(DB.ACCOUNT)));
            student.setLanguageFraction(cursor.getInt(cursor.getColumnIndex(DB.LANGUAGE_FRACTION)));
            student.setMathFraction(cursor.getInt(cursor.getColumnIndex(DB.MATH_FRACTION)));
            student.setEnglishFraction(cursor.getInt(cursor.getColumnIndex(DB.ENGLISH_FRACTION)));
            students.add(student);
        }
        cursor.close();
        db.close();
        return students;
    }

}