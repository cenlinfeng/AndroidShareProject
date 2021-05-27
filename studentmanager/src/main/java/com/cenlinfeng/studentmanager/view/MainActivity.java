package com.cenlinfeng.studentmanager.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cenlinfeng.studentmanager.R;
import com.cenlinfeng.studentmanager.bean.Manager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAccount;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //进来先登录
        findView();

    }

    private void findView() {
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        String account = etAccount.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入账号和密码", Toast.LENGTH_SHORT).show();
            return;
        }
        //管理员登录
        if (Manager.getAccount().equals(account)) {
            if (!Manager.getPassword().equals(password)) {
                Toast.makeText(this, "管理员账号登录：密码不正确", Toast.LENGTH_SHORT).show();
                return;
            }
            //管理员账号登录，跳转管理员界面
            return;
        }
        //老师登录，查询教师列表



        //学生登录，查询学生列表


    }
}