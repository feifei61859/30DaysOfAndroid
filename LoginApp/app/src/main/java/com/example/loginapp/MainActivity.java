package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    //声明各种组件
    private Button LoginBtn;
    private EditText InputPassword;
    private EditText InputUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //在Activity创建的时候找到组件
        LoginBtn = findViewById(R.id.LoginBtn);
        InputUser = findViewById(R.id.UserInput);
        InputPassword = findViewById(R.id.PasswordInput);

        //为按钮设置监听事件
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(InputPassword.length() == 0 || InputUser.length() == 0){
                    Toasty.error(MainActivity.this, "登录失败!", Toast.LENGTH_SHORT, true).show();
                }
                else{
                    //显示成功Toast
                    Toasty.success(MainActivity.this, "登录成功!", Toast.LENGTH_SHORT, true).show();
                }
            }
        });
    }
}
