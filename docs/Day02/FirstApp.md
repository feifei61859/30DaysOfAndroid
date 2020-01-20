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

### 设计用户界面
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
