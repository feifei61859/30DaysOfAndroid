## 使用Toasty
### 什么是Toasty?
Toasty可以说是Toast的加强版，它是由一位Github大神[GrenderG](https://github.com/GrenderG)开发的一个组件，目前已有5.6k的star.项目地址:https://github.com/GrenderG/Toasty

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
我们只需修改两行代码:
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
