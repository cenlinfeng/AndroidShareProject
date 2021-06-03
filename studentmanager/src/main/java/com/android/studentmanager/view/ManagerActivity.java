package com.android.studentmanager.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.studentmanager.R;

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTeacher;
    private Button btnStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);


        loadView();
    }

    private void loadView() {
        btnTeacher = findViewById(R.id.btn_teacher);
        btnStudent = findViewById(R.id.btn_student);

        btnTeacher.setOnClickListener(this);
        btnStudent.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_teacher:
                skipTeacherActivity();
                break;
            case R.id.btn_student:

                break;
        }
    }

    private void skipTeacherActivity() {
        Intent intent = new Intent(this, TeacherManagerActivity.class);
        startActivity(intent);
    }


}