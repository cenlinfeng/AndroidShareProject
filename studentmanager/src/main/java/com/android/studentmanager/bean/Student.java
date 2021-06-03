package com.android.studentmanager.bean;

public class Student {
    private String className;//班级名称
    private String departmentName;//系
    private String schoolName;//学校名称
    private String name;//学生名字
    private int id; // ID每一个都不一样
    private int sex;//性别
    private int age;//年龄
    private String studentNumber;//学号

    private String account;//学生账号
    private String password;//学生密码

    private int languageFraction;//语文分数
    private int mathFraction;//数学分数
    private int englishFraction;//英语分数

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLanguageFraction() {
        return languageFraction;
    }

    public void setLanguageFraction(int languageFraction) {
        this.languageFraction = languageFraction;
    }

    public int getMathFraction() {
        return mathFraction;
    }

    public void setMathFraction(int mathFraction) {
        this.mathFraction = mathFraction;
    }

    public int getEnglishFraction() {
        return englishFraction;
    }

    public void setEnglishFraction(int englishFraction) {
        this.englishFraction = englishFraction;
    }
}