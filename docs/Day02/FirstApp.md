## 我与Android的第一次亲密接触

我们的第一个APP叫做Press Me(点击我),里面包括一个内容为"Press Me"的Button(按钮),每当用户点击这个按钮的时候，按钮上面的字符串都会被改变，效果图:  
![image](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day02/image/1579491468011.gif)

### 开始创建你的第一个项目
打开AndroidStudio，我们看到了欢迎界面，点击新建项目:
![image](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day02/image/NewProject00.png)
点击Next,它会让我们选择Activity,我们选择一个空Activity(EmityActivity).
接下来我们输入应用的名称Press Me,第二个是公司域名，第三个是项目存储位置.(根据自己的喜好所定)，最后一个肯定是Java啦!
![image](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day02/image/NewProject.png)  
Finish后，AndroidStudio会帮我们自动构建项目(等待...)

# 设计用户界面

## 分析Press Me中的布局(Layout)
Press Me的用户界面需要下面的组件:  
* 一个垂直的LinearLayout组件(线性布局)  
* 一个要显示字符串的TextView组件(文本框)  
* 一个Button组件(按钮)    
![image](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day02/image/Layout.jpg)    
下面我们就在activity_main中定义这些组件.  

我们打开app/res/layout/activity_main.xml文件。  
![image](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day02/image/001.png)  
删去默认的代码，输入下面的代码：    
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/myText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="24dp"
        android:textSize="40dp"
        android:text="@string/Android"/>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/PressMeBtn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/app_name"
            android:textAllCaps="false"
        />
        </LinearLayout>

</LinearLayout>
```  
(上述代码不理解没有关系，在后面会进行详细的讲解)  
android:id属性指的是这个组件(View)的id,它们都是Int类型的,存放在R.java的id类中。(android:id属性值前面有一个+标志，意思是创建一个ID)  
你发现TextView中的android:text属性报错了，原因是text属性中的内容没有在string.xml(字符串资源文件)声明。你可以直接将它改为android:text = "Android",但Android项目开发中不是很提倡这种做法。(如果有一天你的App火遍全球，要支持多种语言,你可以将多国语言文字内容放在string.xml中，就可以很方便地引用它们)    
我们找到app/res/values/string.xml，发现有一段默认的代码:  
```xml
<resources>
    <string name="app_name">Press Me</string>
</resources>
```
##### 声明一个string的语法为:  
```xml
  <string name = "字符串的名字(标签)">字符串内容</string>
```
你只要引用字符串的名字(标签)后，你就可以把字符串直接将它显示在Android界面中.  
加入一行代码后,错误就消失了:  
```xml
<resources>
    <string name="app_name">Press Me</string>
    <string name="Android">Android</string>
</resources>
```
点击预览(preview),就可以看到Press Me的初始界面了!  

## 接下来？喝咖啡(Java)
我们似乎构建了一个很简单而优美的用户界面，但单单只有界面是不够的，我们的App需要与用户们一起互动，那什么负责管理用户与应用界面的交互呢?  
![image]()  
答案是Activity!  
我们找到我们的MainActivity.java文件,打开后默认的代码应该是这个样子:
```java
package com.caesar.pressme;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } 
}
```  
我们根据代码来分析，MainActivity类继承自AppCompatActivity类，并且重写了父类的onCreate方法。onCreate(Bundle)是Activity生命周期中的一个状态，意思是当这个Activity在创建的时候要执行的代码。  
我们继续往下看，这个Activity创建的时候执行了setContentView(R.layout.activity_main)方法，它的主要意思是获取该Activity的用户界面。该方法的原型是: 
```java
public void setContentView(int layoutResID)
```
为什么它的参数layoutResID是Int类型的?我们之前稍微提到过，资源ID都是以int类型的方式存放在R.java中。(具体你可以打开目录app/build/generated/source/r/debug找到R.java)  
既然我们获取了该Activity的用户界面，又得到了资源ID.我们就可以在MainActivity中引用组件(View)。代码可以这么写:  
```java
package com.caesar.pressme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButton;     //声明Button组件
    private TextView mTextView;  //声明TextView组件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   //获得Activity对应的用户界面
        
        //通过资源ID找到组件
        mButton = (Button) findViewById(R.id.PressMeBtn);
        mTextView = (TextView) findViewById(R.id.myText);
    }
}
```  
(在AndroidStudio中，如果遇到错误，你可以用Alt+Enter自动帮你导入包。)  
下面我们为按钮设置一个监听事件:
```java
package com.caesar.pressme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.PressMeBtn);
        mTextView = (TextView) findViewById(R.id.myText);
        
        //设置监听事件
        mButton.setOnClickListener(new View.OnClickListener() {
            //当按钮被按下的时候要执行的代码
            @Override
            public void onClick(View v) {
                //弹出一个Toast
                Toast.makeText(MainActivity.this,
                        R.string.press,            
                        Toast.LENGTH_SHORT).show();   //想要显示就不要忘记调用show方法
            }
        });
    }

}
```  
Toast是一个提醒消息，使用makeText方法.show()可以弹出一个消息提醒.  
```java
public static Toast makeText(Context context,int resId,int duration)
```
## 编写逻辑
我们的需求是:每按下按钮，上面的字符串(TextView)都会被改变。这个只需要用一个setText()就可以实现.  
我们新建一个类，名为Character.java.  
Character.java  
```java
package com.caesar.pressme;

public class Character {
    private int mTextResId;

    public Character(int TextResId){
        mTextResId = TextResId;
    }

    public int getTextResId() {
        return mTextResId;
    }
    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }
}
```  
MainActivity.java  
```java
package com.caesar.pressme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;

    private int Index = 0;   //索引，数组的索引都是从0开始的

    //用一个数组来存放字符串内容
    private Character[] mCharacters = new Character[]{
        new Character(R.string.Android),
            new Character(R.string.is),
            new Character(R.string.cool),
            new Character(R.string.and),
            new Character(R.string.awesome),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.PressMeBtn);
        mTextView = (TextView) findViewById(R.id.myText);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        R.string.press,
                        Toast.LENGTH_SHORT).show();
                Index = Index + 1;   //显示下一个字符串
                if(Index > 4){
                    Index = 0;
                }
                update();
            }
        });
    }

    private void update(){
        //获得当前字符串的内容
        int character = mCharacters[Index].getTextResId();
        //重新设置TextView，实现了更新的效果
        mTextView.setText(character);
    }
}
```
