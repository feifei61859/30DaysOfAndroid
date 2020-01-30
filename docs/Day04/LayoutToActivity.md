## Layout是怎么画在Activity上的？
我们之前说过在Activity中调用setContentView(...)方法能将Layout画在Activity上。这个方法其实是将xml文件的内容转变为View对象的。它是通过一个叫LayoutInflater
的类实例化xml文件中的每一个View对象:
![LayoutToActivity](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day04/image/LayoutToActivity.png)  
最后，通过aapt将xml文件打包在.apk文件中，这样，打开手机App,Layout就显示在Activty上了。
