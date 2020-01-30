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
