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
