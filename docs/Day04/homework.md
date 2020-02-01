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
