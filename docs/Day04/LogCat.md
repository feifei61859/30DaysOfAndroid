## Android中的System.out.println
通过这几天的学习，我们知道了如何在App上显示一行字符串，使用TextView就可以快速实现。但是，我们如何在AndroidStudio中打印一行字符串呢?那就要知道Log(日志)的概念了。
使用Android.util.log类能够打印日志，这对我们要跟踪一些东西很有用处。我在写App的时候最喜欢用的是Log.d(...)来打印日志:
```java
public static int d(String tag,String msg)
```
第一个参数是日志的TAG,第二个参数是日志的内容，打印的日志都会在LogCat中(Android SDK中的日志查看器)。
```java
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	Log.d("MainActivity", "onCreate");
}
```
点击运行后，我们在AndroidStudio的底部看见LogCat里面输出各种花里胡哨的东西:  
```
W/KeyCharacterMap( 130): No keyboard for id 0
W/KeyCharacterMap( 130): Using default keymap: /system/usr/keychars/qwerty.kcm.bin
I/ActivityManager( 52): Displayed activity com.android.contacts/.DialtactsContactsEntryActivity: 983 ms
I/ARMAssembler( 52): generated scanline__00000077:03545404_00000A04_00000000 [ 29 ipp] (51 ins) at [0x25c978:0x25ca44] in 1764174 ns
I/ARMAssembler( 52): generated scanline__00000077:03515104_00000001_00000000 [ 46 ipp] (65 ins) at [0x25d1c8:0x25d2cc] in 776789 ns
D/dalvikvm( 130): GC freed 834 objects / 81760 bytes in 63ms
D/dalvikvm( 52): GC freed 10588 objects / 425776 bytes in 94ms
```
为了方便查找，我们点击LogCat右上角的Show only selected application。我们要创建过滤设置，选择Edit Filter Configuration选项。点击绿色+按钮，在Filter Name中输入MainActivity,Log Tag也输入MainActivity.  
![Activity-life](https://github.com/stepfencurryxiao/30DaysOfAndroid/tree/master/docs/Day04/image/LogCat.png)  
再次点击运行，看到输出结果:  
```java
D/MainActivity: onCreate
```
当然还有其它的日志记录方法:  
* Log.v(String, String) 详细(verbose)
* Log.d(String, String) 调试(debug)
* Log.i(String, String) 信息(information)
* Log.w(String, String) 警告(warning)
* Log.e(String, String) 错误(error)