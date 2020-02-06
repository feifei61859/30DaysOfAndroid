## Activity的跳转与数据传递
今天是2020年的2月3日，我已经写了两个星期的教程了(从1月19日开始写)，现在才更新到第五天，我为我的进度感到担心。之前一直在开发教程后面要学习的App,所以没有
什么时间来更新。不知是幸还是不幸，由于新型病毒的影响假期延长了，所以我会抓紧机会努力更新文章。不过也要祝大家身体健康，百病不侵！  
我们先来学习Activity的跳转，我们知道之前写的都是只有一个MainActivity的App,我们今天就来修改一下之前写的LoginApp,让MainActivity跳转到第二个Actvitiy,
我们点击登录按钮，它跳转到了第二个Activity,并弹出了一个"欢迎回来<用户名>"的Toasty.  
效果图:  
![APP](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day05/image/App.gif)  
## Intent是神马
日常操作，先看一下官方解释:  
Intent 分为两种类型：  
* 显式 Intent：通过提供目标应用的软件包名称或完全限定的组件类名来指定可处理 Intent 的应用。
 通常，您会在自己的应用中使用显式 Intent 来启动组件，这是因为您知道要启动的 Activity 或服务的类名。
 例如，您可能会启动您应用内的新 Activity 以响应用户操作，或者启动服务以在后台下载文件。
* 隐式 Intent ：不会指定特定的组件，而是声明要执行的常规操作，从而允许其他应用中的组件来处理。
 例如，如需在地图上向用户显示位置，则可以使用隐式 Intent，请求另一具有此功能的应用在地图上显示指定的位置。  
 

官网上面的解释讲得太详细(抽象)了，intent是一种媒介工具。简单地说，显式Intent就是在同一个应用中Activity的跳转，隐式Intent就是不同应用之间Activity的跳转(
我们可以用隐式Intent使App跳转到另一个应用的Activity(例如，跳转到打电话界面)，不过要在AndroidManifest.xml中声明权限)。
我们之后就要用到显式Intent,隐式Intent我们在Day12会讲到。
我们可以用收快递的故事来描述Activity之间的跳转，假如你是BActivity,那么快递员就是AActivity,快递就是intent.  
## Coding时间
下面就来跟我一行一行地敲代码，慢慢来理解这个过程。  
我们打开LoginApp,在App目录下新建一个Activity，名字为SecondActivity:  
![NewClass](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day05/image/NewClass.png)   
我们要从将递员(MainActivity)的快递(intent)送到你(SecondActivity)的手上,首先要把快递(intent)包装好:
```java
 Intent intent = new Intent(MainActivity.this,SecondActivity.class);
```  
可知Intent(...)方法的第一个参数是Context类型的，第二个参数是Class类型的:
```java
public Intent(Context packageContext,class<?> cls)
```  
接下来就要开始运送了，来一个startActivity(Intent)方法:  
```java
startActivity(intent);
```  
我们要在登录之后才能跳转到SecondActivity,所以说完整的MainActivity代码应该是这样的:  
```java
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        LoginBtn = (Button) findViewById(R.id.LoginBtn);
        InputUser = (EditText) findViewById(R.id.UserInput);
        InputPassword = (EditText) findViewById(R.id.PasswordInput);

        user = InputUser.getText().toString();
        //为按钮设置监听事件
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(InputPassword.length() == 0 || InputUser.length() == 0) {
                    Toasty.error(MainActivity.this, "登录失败!", Toast.LENGTH_SHORT, true).show();
                }
                else{
                    user = InputUser.getText().toString();
                    //显示成功Toast
                    Toasty.success(MainActivity.this, "登录成功!", Toast.LENGTH_SHORT, true).show();

                    //跳转到第二个Activity
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    //启动第二个Activity
                    startActivity(intent);
                }
            }
        });
    }
}

```  
运行一下，输入后点击登录，由于我们没有定义SecondActivity的用户界面，所以我们的SecondActivity界面是一片空白:  
![AppTwo](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day05/image/AppTwo.png)  
在SecondActivity上面画点什么吧!一个什么都没有的Activity似乎不是很好。我们就在上面画一个按钮，点击它会调用finish()方法:  
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    tools:context=".SecondActivity">

    <Button
        android:id="@+id/Finishbtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/SecondActivityBtn"
        />
</LinearLayout>
```  
字符串资源string.xml:  
```xml
<resources>
          ...
<string name="SecondActivityBtn">调用finish()</string>
          ...
</resources>
```  
调用finish()方法可以把我们的Activity结束掉，所以给按钮设置监听事件，那么SecondActivity.java就这么写:  
```java
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

import static com.example.loginapp.R.*;

public class SecondActivity extends AppCompatActivity {

    //声明按钮
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_second);

        //找到Button的id
        mButton = findViewById(id.Finishbtn);
        //为按钮设置监听事件
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //完成Activity
                finish();
                Toasty.normal(SecondActivity.this,"Activity被finish",Toast.LENGTH_LONG).show();
            }
        });
    }
}

```  
点击运行，结果是这样的:  
![ActivityFinish](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day05/image/ActivityFinish.gif)   
我们看到SecondActivity返回了登录Activity,所以说Activity调用finish()方法可以把我们的Activity结束掉，返回上一个Activity.当然你也可以用intent的方法来返回上
登录Activity，运行效果都是一样的:  
```java
Intent intent = new Intent(SecondActivity.this,MainActivity.class);
startActivity(intent);
```  
  
## 内部做了些什么?
在Android操作系统里面有一个ActivityManager,顾名思义，它负责管理Activity。ActivityManager会根据startActivity(Intent)方法的Intent参数来找到要
跳转的Activity。所以说intent的地位还是挺重要的。  
不过ActivityManager还有其它功能，比如判断应用是否在前台运行，应用是否在运行等等。  
下面一图展现了从MainActivity到SecondActivity的过程:  
![AndroidSystem](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day05/image/AndroidSystem.png)    
intent里面包含了一个叫component的东西，它指向了要跳转的Activity,当然这里肯定是指向SecondActivity。intent还有其它组成:Action,Data,Category,Flags,Extras.
其中Extras就是我们接下来要讲的，它与Activity的数据传递有关。Action顾名思义是指Intent要完成的动作，Data是执行Action的数据，
Category通过一个字符串来表示启动窗口时符合的类别，比如说我们可以用CATEGORY_APP_CONTACTS来启动联系人应用程序。哎呀！不小心讲到隐式intent了!又剧透了，哈哈。    

## Activity的数据传递
好了，我们讲讲数据传递吧！继续从我们送快递的故事讲起。快递(intent)里面肯定要包含你想要的宝贝，比如说是最近新出的英伟达Quadro GPU,我们把这个GPU看成是Extras.
这个GPU(Extras)就是通过快递(intent)送(put)到你的手上。在Activity的数据传递中我们可用putExtra(...)方法:  
```java
public Intent putExtra(String name,String value)
```    
这个方法有两个参数:其实Activity数据传递中传递的数据都是键值(Key - Value)结构的，什么是键值结构呢？就像是Java里面的hashMap,或者是python中的dict(Python乱入)等
，所以说第一个参数是Key,第二个参数是Value(也就是真正要传递的数据)。  
我们要把用户的数据传递到SecondActivity,完整的MainActivity.java可以这么写:    
```java
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    public static final String Data = "The User Data";
    private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //在Activity创建的时候找到组件
        LoginBtn = (Button) findViewById(R.id.LoginBtn);
        InputUser = (EditText) findViewById(R.id.UserInput);
        InputPassword = (EditText) findViewById(R.id.PasswordInput);
		//获得EditView输入的值，转化为一个String类型
        user = InputUser.getText().toString();
        //为按钮设置监听事件
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(InputPassword.length() == 0 || InputUser.length() == 0) {
                    Toasty.error(MainActivity.this, "登录失败!", Toast.LENGTH_SHORT, true).show();
                }
                else{
                    user = InputUser.getText().toString();
                    //显示成功Toast
                    Toasty.success(MainActivity.this, "登录成功!", Toast.LENGTH_SHORT, true).show();

                    //跳转到第二个Activity
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    //传递数据，把用户名传递给下一个Activity
                    intent.putExtra(Data,user);
                    //启动第二个Activity
                    startActivity(intent);
                }
            }
        });
    }
}

```  
既然传递了数据给SecondActivity,那么我们就要在SecondActivity中获得数据:  
```java
package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

import static com.example.loginapp.R.*;

public class SecondActivity extends AppCompatActivity {

    //声明一个Toasty控件
    private Toast mToast;
    //声明按钮
    private Button mButton;

    private static String Welcome = "欢迎回来";
	
    //用于在弹出Toasty的时候显示用户名
    private String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_second);
        //获得数据，首先要获得intent,然后再获得数据(因为intent里包含Extras(数据)嘛)
        userName = this.getIntent().getStringExtra(MainActivity.Data);
        //弹出一个Toasty
        Toasty.info(SecondActivity.this, Welcome + userName, Toast.LENGTH_LONG, true).show();

        //找到Button的id
        mButton = findViewById(R.id.Finishbtn);
        //为按钮设置监听事件
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //完成Activity
                finish();
                //弹出一个Toasty
                Toasty.normal(SecondActivity.this,"Activity被finish",Toast.LENGTH_LONG).show();
            }
        });
    }
}
```  
其实我们还可以用Bundle的形式来传递数据的，因为Bundle其实也是一种键值(Key - Value)结构，你有没有留意到:经常提到的onCreate(Bundle)方法的参数就是一种键值
结构，它保存的是该状态(onCreate)下的数据。  
```java
//传递数据
Bundle bundle=new Bundle();
bundle.putString(Data,user);
//获得数据
Bundle bundle=getIntent().getExtras();
String userName=bundle.getString(MainActivity.Data);
```  
## 总结
今天介绍了Activity的跳转和数据传递的方法，这一部分的内容一定要好好掌握。这是在Android开发中经常要用到的技能，当然还有Fragment的跳转和数据传递,这个在week2
会讲到。希望大家能get到。  
后面我们会学习RecyclerView和MVC模型，读者们敬请期待。  
