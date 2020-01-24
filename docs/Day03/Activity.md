## 开始编写MainActivity.java
![Java](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day03/image/java.jpg)

我们打开app/src/main/java/com/example/loginapp/MainActivity.java,输入以下代码  
```java
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
//导入各种包
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                //如果密码和用户的输入框没有内容(长度为0)
                if(InputPassword.length() == 0 || InputUser.length() == 0){
                    //显示失败Toast
                    Toast.makeText(MainActivity.this, "登录失败!", Toast.LENGTH_SHORT).show();
                }
                //密码和用户的输入框都有内容
                else{
                    //显示成功Toast
                    Toast.makeText(MainActivity.this, "登录成功!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
```  
点击运行，我们的App就开发完成了!
