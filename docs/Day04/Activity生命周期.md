## Activity的生命周期
万物都有生命，我们也一样，从出生到死亡，这就是我们的生命周期。Activity也不例外，它的生命周期就是从它被创造到它被销毁的过程。  

从开始学习那天到现在，我们已经开发了2个App了，不知你有没有发现，我们每一个MainActivity.java文件中都有一个onCreate(bundle)方法，之前我也粗略地提到过它是Activity生命周期的一种状态，接下来我们就来详细讲解一下Activity的生命周期。  

这是Google官方对Activity生命周期的解释:  
在生命周期回调方法中，您可以声明用户离开和再次进入 Activity 时 Activity 的行为方式。例如，如果您正在构建流式视频播放器，
则当用户切换至另一应用时，您可能要暂停视频并终止网络连接。当用户返回时，您可以重新连接到网络，并允许用户从同一位置继续播放视频。
换言之，每个回调都支持您执行适合给定状态变更的特定作业。在合适的时间执行正确的作业，并妥善处理转换，这将提升应用的稳健性和性能。
例如，良好的生命周期回调实现有助于确保您的应用避免：  
* 当用户在使用应用时接听来电，或切换至另一应用时崩溃。
* 当用户未积极使用它时，消耗宝贵的系统资源。
* 当用户离开应用并在稍后返回时，丢失用户的进度。
* 当屏幕在横向和纵向之间旋转时，崩溃或丢失用户的进度.   

来自[Android文档](https://developer.android.google.cn/guide/components/activities/activity-lifecycle.html)  
上面Google官方的解释可能有点不好理解，我在这里简洁地讲解一下。例如，我们要退出一个App,我们按下手机下方的退出键的时候，我们正在销毁一个Activity(执行了
onDestroy(Bundle)方法),何为销毁一个Activity？就是Activity在内存中消失了，我们再次打开这个App的时候，这个Activity又重新被创建(执行了onCreate(Bundle)方法)
而这时有一位朋友来打电话手机显示来电消息的时候，这个Activity可能执行了onPause(Bundle)方法，则Activity处于停止的状态中，通话完毕后，又调用了onResume(Bundle)方法
，恢复Activity原来的状态。  
Android允许我们可以覆盖Activity每一个生命周期的方法。比如说，onCreate(Bundle)前面都有一个@Override注解，其实我们覆盖了父类的onCreate(bundle)方法。所以说，我们可以在Activity达到各种状态时去写该状态下要执行的代码。至于要写什么样的代码，那就要看你的需求了。不过我们要知道Activity什么时候到达什么状态，才能覆盖Activity生命周期的方法，下面就来了解一下Activity的各种状态:  
下面一图也是从Android文档上弄下来的，展示了Activity的各个生命周期:  
![Activity-life](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day04/image/Activity-life.png)  
我们来分析Activity的每一种状态吧，首先从我们平时接触最多的onCreate(Bundle)状态开始:
这是在LoginApp的MainActivity.java中onCreate方法的代码:  
我们在onCreate(Bundle)中都做了些什么?
* 调用了setContentView(R.layout.activity_main)方法让Activity显示该Activity的用户界面
* 通过资源id找到组件
* 为按钮设置了监听事件
```java
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //在Activity创建的时候找到组件
        LoginBtn = findViewById(R.id.LoginBtn);
        InputUser = findViewById(R.id.UserInput);
        InputPassword = findViewById(R.id.PasswordInput);

        //为按钮设置监听事件
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(InputPassword.length() == 0 || InputUser.length() == 0){
                    Toasty.error(MainActivity.this, "登录失败!", Toast.LENGTH_SHORT, true).show();
                }
                else{
                    //显示成功Toast
                    Toasty.success(MainActivity.this, "登录成功!", Toast.LENGTH_SHORT, true).show();
                }
            }
        });
    }
}
```
所以我们可以得出结论，当Activity调用onCreate(Bundle)方法时处于创建状态，该方法里面包括了Activity被创建的时候要执行的代码。  
### onStart(Bundle)
执行完onCreate(Bundle)方法之后，Activity进入“已开始”状态,此时调用了onStart()方法,onStart()是activity界面被显示出来的时候执行的，用户可见但不可以
与它交互。  
### onResume(Bundle)
之后，Activity会马上进入“已恢复”状态,此时调用了onResume(Bundle)方法,正如上面所说的一样，应用会一直保持这种状态直到某些事件发生。此类事件包括接到来电、用户导航到另一个 Activity，或设备屏幕关闭。
### onPause(Bundle)
在app的运行的时候，Activity有时可能会被打断(例如接到电话)，然后进入pause状态。然后调用onPause(Bundle)方法，这个Activity会暂停一会儿，用户可能会再次回到这个Activity，此时这个Activity
在内存中其实并没有被销毁。
### onStop(Bundle)
当Activity不可见时，Activity处于Stopped状态。此时调用了onStop(Bundle)方法。
### onDestroy(Bundle)
在Activity被销毁之前，系统会调用 onDestroy(Bundle)方法。  

## Layout是怎么画在Activity上的？
我们之前说过在Activity中调用setContentView(...)方法能将Layout画在Activity上。这个方法其实是将xml文件的内容转变为View对象的。它是通过一个叫LayoutInflater
的类实例化xml文件中的每一个View对象:
![LayoutToActivity](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day04/image/LayoutToActivity.png)  
最后，通过aapt将xml文件打包在.apk文件中，这样，打开手机App,Layout就显示在Activty上了。


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
![Log](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day04/image/LogCat.png)  
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


## 作业
![summarize](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day04/image/summarize.png)  
1,简述一下Activity的各种生命周期。  
2,回忆Layout是如何画在Activity上的？  
3,尝试使用Log不同的方式输出日志，查看是否能得到以下结论:  
```
verbose 输出颜色为黑色    Log.v(...);
debug   输出颜色为蓝色    Log.d(...);
info    输出颜色为绿色    Log.i(...);
warn    输出颜色为橘黄色  Log.w(...);
error   输出颜色为红色    Log.e(...);
```
4,新建一个项目，根据下面代码编写一个Activty，分析运行效果  
```java
...
public class MainActivity extends AppCompatActivity {
    private static string TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.d(TAG, "调用onCreate()");
     }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "调用onStart()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "调用onPause()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "调用onResume()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "调用onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "调用onDestroy()");
    }
}
```
