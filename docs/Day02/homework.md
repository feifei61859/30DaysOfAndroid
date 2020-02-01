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
