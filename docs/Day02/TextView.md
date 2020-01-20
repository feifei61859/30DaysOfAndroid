## TextView(文本框)
#### 必须要的属性:
```xml
android:layout_width = "wrap_content"
android:layout_height = "wrap_content"
```  
* match_parent:视图与其父视图大小相同  
* wrap_content:自动调整大小  
#### 常用属性:  
设置文本内容:    
```xml
android:text = "Hello"
android:text = "@string/Hello"
```  
设置文字大小:    
```xml
android:Textsize = "10sp"
```  
设置对齐方式:  
```xml
android:gravity="center"
android:gravity="bottom" 
android:gravity="left" 
android:gravity="right" 
android:gravity="center_horizontal"  
android:gravity="fill_horizontal"  
```  
设置背景颜色:  
```xml
android:background="#000"
android:background="@Color/black"
```  
设置颜色:    
```xml
android:textColor = "#000"
android:textColor = "@color/black"
```  
只显示单行(不显示为false):  
```xml
android:singleLine="true"
```  
行数设置:  
```xml
android:lines="2"
android:maxLines="2"
```  
省略号显示  
```xml
android:ellipsize="middle"
android:lines="1"
```  
跑马灯:  
```xml
android:singleLine="true"
android:ellipsize="marquee"
android:marqueeRepeatLimit="marquee_forever"
```
