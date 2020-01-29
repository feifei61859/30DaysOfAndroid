## Activity与Layout的基本概念
最基本的Android应用是由Activity(活动)和Layout(布局)构成的。  
![ActivityAndLayout](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day02/image/LayoutAndActivity.png)
## Activity
官方解释:  
* Activity 表示具有用户界面的单一屏幕。例如，电子邮件应用可能具有一个显示新电子邮件列表的 Activity、一个用于撰写电子邮件的 Activity 以及一个用于阅读电子邮件的 Activity。 尽管这些 Activity 通过协作在电子邮件应用中形成了一种紧密结合的用户体验，但每一个 Activity 都独立于其他 Activity 而存在。 因此，其他应用可以启动其中任何一个 Activity（如果电子邮件应用允许）。 例如，相机应用可以启动电子邮件应用内用于撰写新电子邮件的 Activity，以便用户共享图片。 
* 每创建一个Activity都要在AndroidManifest.xml文件中声明。
## Layout
* Layout 定义了一系列用户界面对象以及它们显示在屏幕上的位置。这些用户对象就叫做组件(widget),例如，WeChat上面的输入框和按钮.每一个组件都是View类或其子类(如TextView和Button)的一个具体实例。  
* 组成Layout的定义保存在XML文件中
