package com.android.studentmanager.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.studentmanager.App;
import com.android.studentmanager.R;
import com.android.studentmanager.bean.Teacher;

public class AddTeacherActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAccount;
    private EditText etPassword;
    private EditText etName;
    private EditText etClass;
    private EditText etDepartment;
    private EditText etSchool;
    private Button btnAddTeacher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        loadView();
    }

    private void loadView() {
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        etName = findViewById(R.id.et_name);
        etClass = findViewById(R.id.et_class);
        etDepartment = findViewById(R.id.et_department);
        etSchool = findViewById(R.id.et_school);
        btnAddTeacher = findViewById(R.id.btn_add_teacher);

        btnAddTeacher.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_teacher:
                //添加教师
                addTeacher();
                break;
        }
    }

    private void addTeacher() {
        String account = etAccount.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String clazz = etClass.getText().toString().trim();
        String department = etDepartment.getText().toString().trim();
        String school = etSchool.getText().toString().trim();

        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password) || TextUtils.isEmpty(name)//班级可以为空，不一定在一个班级
                || TextUtils.isEmpty(department) || TextUtils.isEmpty(school)) {
            Toast.makeText(this, "输入信息不完整", Toast.LENGTH_SHORT).show();
            return;
        }
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setSchoolName(school);
        teacher.setClassName(clazz);
        teacher.setDepartmentName(department);
        teacher.setAccount(account);
        teacher.setPassword(password);
        long l = App.getDbHelper().addTeacher(teacher);
        if (l != -1) {//添加成功
            Intent intent = new Intent();//关闭这个界面回到上一个界面，这个界面应该带一个参数
            intent.putExtra("bean", teacher);
            setResult(10, intent);
            finish();
        }

    }
}