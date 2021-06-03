package com.android.studentmanager.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.studentmanager.App;
import com.android.studentmanager.R;
import com.android.studentmanager.adapter.TeacherAdapter;
import com.android.studentmanager.bean.Teacher;

import java.util.List;

public class TeacherManagerActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView listView;
    private TeacherAdapter teacherAdapter;
    private TextView tvHint;
    private Button btnAddTeacher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_teacher);

        loadView();
        loadData();
    }

    private void loadData() {//查询数据库
        List<Teacher> teacherList = App.getDbHelper().getTeacherList();
        if (teacherList == null || teacherList.size() <= 0) { // 判断教师列表是否为空或者是无长度
            tvHint.setVisibility(View.VISIBLE); // 如果是无长度或者是空的话就显示文字提示
            //然后把列表显示为空
        } else {
            tvHint.setVisibility(View.GONE);
        }
        teacherAdapter.setList(teacherList);//始终都要设置列表的，空的也可以设置，在适配器中判断就可以了。
    }

    private void loadView() {
        listView = findViewById(R.id.list);
        tvHint = findViewById(R.id.tv_hint);
        btnAddTeacher = findViewById(R.id.btn_add_teacher);

        btnAddTeacher.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        tvHint.setVisibility(View.GONE);//隐藏这个提示

        teacherAdapter = new TeacherAdapter(this);
        listView.setAdapter(teacherAdapter);

    }


    private static final int REQUEST_CODE = 10;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_teacher:
                //跳转去添加教师的界面
                Intent intent = new Intent(this, AddTeacherActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                //跳转去下一个界面，并且设置请求码，如果是从下一个界面关闭并且有带回参数的话，是从onActivityResult那里获取的
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {//是不是上面跳转添加教师界面的请求码，如果是的话做以下操作
            if (resultCode == 10) {//从AddTeacherActivity中设置的返回码
                //获取数据
                Teacher teacher = (Teacher) data.getSerializableExtra("bean");//传的是一个序列化过的Teacher
                //正常的话是 data.getString(),或者是data.getInt()之类的
                //添加teacher去集合里面
                teacherAdapter.addTeacher(teacher);
                tvHint.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //点击列表某一条item的时候会调用这个方法，点击item弹出一个dialog，这个dialog是自定义的。

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        return false;
    }
}