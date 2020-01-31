## Activity与Layout的基本概念
最基本的Android应用是由Activity(活动)和Layout(布局)构成的。  
![ActivityAndLayout](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day02/image/LayoutAndActivity.png)
## Activity
我初学Android的时候对Activity是这样理解的，Activity就代表着用户的活动，当用户要登录的时候，启动了登录的活动(LoginActivity)，打电话的时候，启动了打电话的活动(CallActivity)。至于你想要在Activity上显示什么，那就要看你的Layout了。  
最后看一下官方解释吧:  
* Activity 表示具有用户界面的单一屏幕。例如，电子邮件应用可能具有一个显示新电子邮件列表的 Activity、一个用于撰写电子邮件的 Activity 以及一个用于阅读电子邮件的 Activity。 尽管这些 Activity 通过协作在电子邮件应用中形成了一种紧密结合的用户体验，但每一个 Activity 都独立于其他 Activity 而存在。 因此，其他应用可以启动其中任何一个 Activity（如果电子邮件应用允许）。 例如，相机应用可以启动电子邮件应用内用于撰写新电子邮件的 Activity，以便用户共享图片。 
* 每创建一个Activity都要在AndroidManifest.xml文件中声明。  
为什么Activity都要在AndroidManifest.xml文件中声明？这个以后我们会说到，我们新建一个Activity的时候AndroidStudio会自动添加在AndroidManifest.xml文件中。  

## Layout
Layout这个英文单词的中文意思是"布局"，没错，就是那个"布局"，比如说家具中的布局就是家具的摆放位置。而Android中的布局表示的是组件的位置而已。  
* Layout 定义了一系列用户界面对象以及它们显示在屏幕上的位置。这些用户对象就叫做组件(widget),例如，WeChat上面的输入框和按钮.每一个组件都是View类或其子类(如TextView和Button)的一个具体实例。  
* 组成Layout的定义保存在XML文件中

为什么组成Layout的定义要保存在XML文件中？我们以后会讲到Layout是如何画在Activity的时候你就会明白了。  
有了上面的基础知识后，接下来我们来开发第一个App!让我们开始吧!  
