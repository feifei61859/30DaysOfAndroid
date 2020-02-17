## 前言
说到Android开发，我也算是一个爱好者吧！我在周末时也读过很多关于Android开发的书，家里也放了几本Android开发的书。这些书上的教程大部分都写得很好，但是它们绝大
部分都是教你如何使用Java在Android平台上编程，并没有说到软件设计的方法，何为软件设计的方法？就是说你不仅要会写App,还要考虑怎么编写一个软件的效率最高，要设计
什么样的界面才能够吸引用户等等，我会在这个教程中为大家提供思路，这就是我写这个教程的原因。  
![Android](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/Android.jpg)  

## 为什么学习Android
说起Android,大家应该都很熟悉吧！(不然你怎么会点进来看教程)。现在你在大街上，地铁上，都存在着低头族。而且很多人都是使用Android系统的(当然还有IOS)，所以
你不用担心你学了Android没有用途了!妈妈再也不会担心我找不到工作了！   
如果你不是计算机专业，学习Android后，你可以去一些网站上接项目，那也可以获得报酬。  
![image](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/fuck.jpg)  

## 给读者的一些建议
本教程是一个快餐教程，每天只要抽出15分钟就能读完。但是，读完后一定要练习，我接触过很多学习编程的(包括我)，在学习之后不愿意练习，感觉自己已经OK了。但事实
上不是的:学编程就像是在挖井，你挖得越深，得到的水就越多。你练习得越多，获得的知识就越多。所以:  
练习很重要！练习很重要！练习很重要！  

每学一周后都会有一个Android挑战:就是用已学的知识发挥自己的想像写一个App.我每月都会评选出优秀的App,你将登上我们的排名榜，让更多的人认识你！  


## 这个教程打算怎么玩?
先来看看我们要学习什么吧！  
* Android基础
* H5开发
* Android多线程
* Android网络
* NDK开发
  ...  
这个教程是不会结束的，我做完30天教程后中还会更新一些其它对Android深入研究的文章发在Github上，所以希望大家持续关注，共同学习！    

## Android的历史
我们乘坐时光机回到2008年9月23日，Google发布了Android1.0系统，这是Android系统中的最早版本。  
随后，又在2009年4月发布了Android1.5版本，并命名为Cupcake(纸杯蛋糕)。后来几年，Android系统不断更新，Bug也不断修复。直到快要发布开发版的Android11.
![各个版本](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/version.jpg)  
不过，Android还有一个非常强大的竞争对手 -- ios系统.ios系统和windows phone系统(微软出的手机系统，现在退出市场)一样，都是闭源的。但是ios要比Android流畅，
我在这里简单地讲一下是为什么吧！是因为安卓要运行虚拟机(处理器的核心部分)，而iOS系统只需要保证几款iPhone、ipad等苹果自己的移动设备上的运行体验即可。不过
我还是喜欢写Android的最重要的原因是:  
* 没钱：IOS开发要在Mac系统上的xcode开发，不支持windows。  
* 开源: 这个没什么好说了，毕竟开源的东西你能够研究它的源代码嘛 

## 工欲善其事，必先利其器
关于Android开发用什么工具，干移动开发的都会想到eclipse和AndroidStudio。如果你使用eclipse，那么就证明你是个老鸟，现在eclipse应该没什么人用来开发Android
了。所以我还是建议初学者安装AndroidStudio.  
First,我们要安装就要找到下载地址吧！AndroidStudio安装地址:https://developer.android.google.cn/studio  
打开这个页面我们就看到下载键了，点击下载  
下载完后开始安装:  
![001](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/001.png)  
一路next,真爽！
![002](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/002.png)  
![003](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/003.png)  
我建议不要安装到C盘，因为这个软件有点大，C盘占用空间太大会影响电脑的运算:  
![004](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/004.png)  
继续next:  
![005](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/005.png)  
![006](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/006.png)  
完事了，点击Finish:  
![007](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/007.png)  
然后突然弹出一个警告,点击取消cancel:  
![008](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/008.png)  
![009](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/009.png)  
![010](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/010.png)  
![011](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/011.png)  
![012](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/012.png)  
![013](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/013.png)  
![014](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/014.png)  
![015](https://github.com/stepfencurryxiao/30DaysOfAndroid/blob/master/docs/Day01/image/015.png)  
耐心等待5分钟，安装完毕！  

## 总结
我们完美地搭建了一个Android开发环境，下一篇文章带大家写第一个App.  








