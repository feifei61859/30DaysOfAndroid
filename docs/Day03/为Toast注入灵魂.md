## 编写你的第二个App
今天，我们来做一个简单的登录界面，效果图:  
![效果](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day03/image/1579827883851.gif)  
通过这个App,你能学到:  
* 第三方库的调用  
* Toast与Toasty的使用方法  
* EditText(输入框)的基本属性  
* 如何防止鬼畜的Toast  
##### 下面就让我们开始吧!  
![image](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day03/image/accepted.png)  

## 编写登录界面
我们新建一个项目,项目名称为LoginApp。  
我们需要定义一些App所需要的字符串资源,打开app/src/main/res/values/strings.xml文件,输入以下代码:  
```xml
<resources>
    <string name="app_name">LoginApp</string>
    <string name="Login">登录成功!</string>
    <string name="LoginFail">登录失败!</string>
    <string name="User">User</string>
    <string name="Password">Password</string>
    <string name="LoginBtn">Login</string>
</resources>
```
我们的登录界面的布局应该是这样的:  
![layout](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day03/image/Layout.png)  
找到app/src/main/res/layout/activity_main.xml,删掉默认的代码,敲进以下的代码:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">


    <EditText
        android:id="@+id/UserInput"
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:hint="@string/User"
        />

    <EditText
        android:id="@+id/PasswordInput"
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:hint="@string/Password"
        android:inputType="textPassword"/>

    <Button
        android:id="@+id/LoginBtn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/LoginBtn"
        />

</LinearLayout>
```

### 分析activity_main.xml  
* 我们来逐行分析xml文件的内容,第一行代码是声明了xml的版本和xml的编码形式,采用的是utf-8.我们不难发现这个界面是一个LinearLayout(线性布局)，
它的高度和宽度都是match_parent(与父视图的大小相同),至于什么是线性布局，
我们会在以后详细讲解,现在你只需知道它就是一种布局，里面包含了2个EditText(输入框)和一个Button,并规定了它们的排列顺序.    
* LinearLayout中还有一个android:orientation="vertical"属性，它决定了在LinearLayout上的组件是水平放置还是垂直放置,我们这里使用了垂直放置(vertical).
* android:hint="@string/Password"是EditText的暗示语(默认提醒输入)，它的属性值引用了我们的字符串资源.  
* android:inputType="textPassword"由单词意思可以知道，它是EditText的输入类型,这里我们定义为textPassword(密文),当然，它的类型有很多，下面是我在csdn
上面找到的输入类型:
```Java
    android:inputType="none"//输入普通字符
    android:inputType="text"//输入普通字符
    android:inputType="textCapCharacters"//输入普通字符
    android:inputType="textCapWords"//单词首字母大小
    android:inputType="textCapSentences"//仅第一个字母大小
    android:inputType="textAutoCorrect"//前两个自动完成
    android:inputType="textAutoComplete"//前两个自动完成
    android:inputType="textMultiLine"//多行输入
    android:inputType="textImeMultiLine"//输入法多行（不一定支持）
    android:inputType="textNoSuggestions"//不提示
    android:inputType="textUri"//URI格式
    android:inputType="textEmailAddress"//电子邮件地址格式
    android:inputType="textEmailSubject"//邮件主题格式
    android:inputType="textShortMessage"//短消息格式
    android:inputType="textLongMessage"//长消息格式
    android:inputType="textPersonName"//人名格式
    android:inputType="textPostalAddress"//邮政格式
    android:inputType="textPassword"//密码格式
    android:inputType="textVisiblePassword"//密码可见格式
    android:inputType="textWebEditText"//作为网页表单的文本格式
    android:inputType="textFilter"//文本筛选格式
    android:inputType="textPhonetic"//拼音输入格式
 
 
    //数值类型
    android:inputType="number"//数字格式
    android:inputType="numberSigned"//有符号数字格式
    android:inputType="numberDecimal"//可以带小数点的浮点格式
    android:inputType="phone"//拨号键盘
    android:inputType="datetime"//日期+时间格式
    android:inputType="date"//日期键盘
    android:inputType="time"//时间键盘

```
点击预览就可以看到我们的登录界面了:  
![preview](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day03/image/preview.png)


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
以上代码应该很好理解，主要是为登录Button设置了一个监听事件判断用户是否输入用户名和密码.  
点击运行，我们的App就开发完成了!


## 使用Toasty
### 什么是Toasty?
Toasty可以说是Toast的加强版，它是由一位Github大神[GrenderG](https://github.com/GrenderG)开发的一个组件，目前已有5.6k的star.项目地址:https://github.com/GrenderG/Toasty  
![ToastAndToasty](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day03/image/ToastAndToasty.png)

### 注入Toasty
由于Android自身没有Toasty,所以我们要导入这个组件.我们在App目录下发现有2个bulid.gradle文件，我们找到Project中的build.gradle文件（不是我们的Module的build.gradle文件），添加一行代码:
```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```  
我们打开另一个build.gradle文件,添加一行代码注入Toasty:
```gradle
dependencies {
	...
  implementation 'com.github.GrenderG:Toasty:1.3.0'
}
```

### 使用Toasty--为App注入灵魂
我们只需修改两行代码,方法的参数与Toast相同:  
```java
//为按钮设置监听事件
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(InputPassword.length() == 0 || InputUser.length() == 0){
                    //显示错误Toast
                    Toasty.error(MainActivity.this, "登录失败!", Toast.LENGTH_SHORT, true).show();
                }
                else{
                    //显示成功Toast
                    Toasty.success(MainActivity.this, "登录成功!", Toast.LENGTH_SHORT, true).show();
                }
            }
        });
    }
```
### 总结方法
```java
//显示错误Toast
Toasty.error(yourContext, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
//显示成功Toast
Toasty.success(yourContext, "Success!", Toast.LENGTH_SHORT, true).show();
//显示信息Toast
Toasty.info(yourContext, "Here is some info for you.", Toast.LENGTH_SHORT, true).show();
//显示警告Toast
Toasty.warning(yourContext, "Beware of the dog.", Toast.LENGTH_SHORT, true).show();
//显示一般的Toast
Toasty.normal(yourContext, "Normal toast w/o icon").show();
//显示带图标的常规Toast
Toasty.normal(yourContext, "Normal toast w/ icon", yourIconDrawable).show();
//自定义Toast
Toasty.custom(yourContext, "I'm a custom Toast", yourIconDrawable, tintColor, duration, withIcon, 
shouldTint).show();
```  
![Toasty](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day03/image/Toasty.png)
### 一个小问题
连续点击登录按钮然后退出，仔细观察Toast,你发现了什么?


## 没有总结的总结
今天我们做了一个简单的登录界面，通过这个App,我们学习了输入框的使用，学会了如何导入第三方组件，学会了如何使用Toasty，我想市面上一些Android的书籍都不会讲Toasty吧！不过我讲Toasty的原因是想告诉你平时你可以学习更多的组件，
它们大部分都开源在github上并且都带有文档。如果我们把Android中的每一个第三方组件都讲一遍的话，那这个教程要写多长啊！毕竟这些组件每天都在更新版本。所以我们要学会在github或Google上自行搜索组件来学习。  
当然，我们的App有很多不足的地方。其中一个最失败的地方是我们只有一个Activity,我们平时使用手机可以发现，一个App不可能总是停留在登录Activity，都是由
登录Activity跳转到另一个Activity.下一篇文章我将从Activity的生命周期出发，学习Activity之间的跳转与数据传递。

## 练习
![image](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day04/image/summarize.png)  
1,自己使用Edit不同的inputType属性，查看预览效果  
2,在Login按钮下添加一个注册按钮，点击后弹出一个Toasty.(内容自定义)  
