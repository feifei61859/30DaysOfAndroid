## 总结
* 最基本的Android应用是由Activity和Layout构成的。Activity负责管理用户与界面的交互，Layout负责定义用户界面.
* 新建一个Activity都要在AndroidManifest.xml中声明.
* android:text的属性的字符串应该在string.xml中定义.
* 所以资源ID都以整形存放在R.java中
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
