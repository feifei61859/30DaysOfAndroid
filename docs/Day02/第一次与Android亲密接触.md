## Activity与Layout的基本概念
最基本的Android应用是由Activity(活动)和Layout(布局)构成的。  
![ActivityAndLayout](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day02/image/LayoutAndActivity.png)
## Activity
我初学Android的时候对Activity是这样理解的，Activity就代表着用户的活动，当用户要登录的时候，启动了登录的活动(LoginActivity)，打电话的时候，启动了打电话的活动(CallActivity)。至于你想要在Activity上显示什么，那就要看你的Layout了。  
最后看一下官方解释吧:  
* Activity 表示具有用户界面的单一屏幕。例如，电子邮件应用可能具有一个显示新电子邮件列表的 Activity、一个用于撰写电子邮件的 Activity 以及一个用于阅读电子邮件的 Activity。 尽管这些 Activity 通过协作在电子邮件应用中形成了一种紧密结合的用户体验，但每一个 Activity 都独立于其他 Activity 而存在。 因此，其他应用可以启动其中任何一个 Activity（如果电子邮件应用允许）。 例如，相机应用可以启动电子邮件应用内用于撰写新电子邮件的 Activity，以便用户共享图片。 
* 每创建一个Activity都要在AndroidManifest.xml文件中声明。  

为什么Activity都要在AndroidManifest.xml文件中声明？这里先剧透一下，只有声明过了，App在运行时才能找到这个Activity，并执行所写的代码。关于更详细的我们以后会提到，我们新建一个Activity的时候AndroidStudio会自动添加在AndroidManifest.xml文件中。AndroidManifest.xml不仅仅只有这个功能，里面还有更多好玩的东西。  

## Layout
Layout这个英文单词的中文意思是"布局"，没错，就是那个"布局"，比如说家具中的布局就是家具的摆放位置。而Android中的布局表示的是组件的位置而已。  
* Layout 定义了一系列用户界面对象以及它们显示在屏幕上的位置。这些用户对象就叫做组件(widget),例如，WeChat上面的输入框和按钮.每一个组件都是View类或其子类(如TextView和Button)的一个具体实例。  
* 组成Layout的定义保存在XML文件中

为什么组成Layout的定义要保存在XML文件中？我们以后会讲到Layout是如何画在Activity的时候你就会明白了。  
有了上面的基础知识后，接下来我们来开发第一个App!让我们开始吧!  

## 我与Android的第一次亲密接触
今天，我们来编写第一个App.
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
![image](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day02/image/think.jpg)  
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
我们新建一个类，名为Character.java。
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
上述代码中包含了MVC设计模式的运用，至于什么是MVC设计模式，我们会在后面深入探究，读者现在暂时不用理解，只需跟着我一步一步地敲代码。  
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
我们的第一个App就编写完毕了.我们可以在模拟器或连接usb在手机上运行，查看运行效果。


## TextView(文本框)
这是我收集的一些TextView比较常用的属性，你可以自己在xml文件中使用这些属性并查看它们的效果。现在不需要记忆，用多了你就自然记住了。  
#### 必须要的属性:
```java
android:layout_width = "wrap_content"
android:layout_height = "wrap_content"
```  
* match_parent:视图与其父视图大小相同  
* wrap_content:自动调整大小  
#### 常用属性:  
设置文本内容:    
```java
android:text = "Hello"
android:text = "@string/Hello"
```  
设置文字大小:    
```java
android:Textsize = "10sp"
```  
设置对齐方式:  
```java
android:gravity="center"
android:gravity="bottom" 
android:gravity="left" 
android:gravity="right" 
android:gravity="center_horizontal"  
android:gravity="fill_horizontal"  
```  
设置背景颜色:  
```java
android:background="#000"
android:background="@Color/black"
```  
设置颜色:    
```java
android:textColor = "#000"
android:textColor = "@color/black"
```  
只显示单行(不显示为false):  
```java
android:singleLine="true"
```  
行数设置:  
```java
android:lines="2"
android:maxLines="2"
```  
省略号显示  
```java
android:ellipsize="middle"
android:lines="1"
```  
跑马灯:  
```java
android:singleLine="true"
android:ellipsize="marquee"
android:marqueeRepeatLimit="marquee_forever"
```


## 总结
* 最基本的Android应用是由Activity和Layout构成的。Activity负责管理用户与界面的交互，Layout负责定义用户界面.
* 新建一个Activity都要在AndroidManifest.xml中声明.
* android:text属性的字符串应该在string.xml中定义.
* 所有资源ID都以整形存放在R.java中
* 通过资源ID找到组件用findViewById(int layoutResId)方法.
* 为按钮设置监听事件(使用内部类的方式):
```java
 mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //做一些事情
            }
        });
```
* 弹出一个消息提醒用Toast.makeText(...).show()方法.


## 练习
![image](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day04/image/summarize.png)  

1,简述Activity与Layout的作用。  
2,改变toast的显示位置，使它在屏幕居中的位置显示. 
提示:  
```java
Toast toast = Toast.makeText(this, "press!", Toast.LENGTH_LONG);
toast.setGravity(Gravity.CENTER, 0, 0);
toast.show();
```  
3,添加一个按钮，内容为"nothing",为它设置一个监听事件:弹出一个内容为"nothing"的toast.内容要在字符串资源string.xml中定义. 
