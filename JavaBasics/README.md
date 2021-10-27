# JAVA 基础学习之路

## Java线程学习之路（ThreadLearning包）

### 线程调度

#### 分时调度

​	所有线程轮流使用CPU的使用权，平均分配每个线程占用CPU的时间

#### 抢占式调度

​	优先让优先级高的线程使用CPU，如果线程的优先级相同，那么会随机选择一个，java使用的为抢占式调度

### 线程创建

####  1.Thread

```java
 * @Description * 多线程创建，
 *    方法一：继承Thread类
 *  1.创建一个类于Thread类的子类
 *  2.重写Thread类的run（）方法
 *  3.创建Thread类的子类的对象
 *  4.通过此对象调用start（）启动
 * 例子：遍历100以内的所有的偶数
     
 * start() //导致此线程开始执行; Java虚拟机调用此线程的run方法。
 * run() 	//如果此线程是使用单独的Runnable运行对象构造的，则调用该Runnable对象的run方法; 否则，此方法不执行任何操作并返回
 
     
 *创建thread匿名子类
     new Thread（）{
      public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
 }.start();

 *Thread方法
     currentThread()：//静态方法，返回当前代码的线程
     getName()：//获取当前线程名字
     setName()：//设置当前线程名字
     yield()://向调度程序提示当前线程是否愿意产生其当前使用的处理器。 调度程序可以忽略此提示。
	 join()://在线程a中调用线程b的join方法，此时线程a进入阻塞状态，直到线程b执行完毕
	 stop()：//已过时，当执行此方法，强制结束当前线程
     sleep(long millitime)：//线程睡眠，其实就是阻塞 指定毫秒时间内
     isAlive()://测试此线程是否存活。 


*线程的优先级
    Max_PRIORITY:10
    MIN_PRIORITY:1
    NORM_PRIORITY:5 
    *涉及的方法
        getPriority()://返回线程优先值
		setPriority(int newPriority)://改变线程的优先级
```



#### 2.Runnable

```java
```



