

# Netty学习

## ***Netty框架***

| ![](../images/image-20211101181207739.png) |
| ------------------------------------------ |

### **Netty工作流程**

```shell

	1）Netty抽象出两组线程池BossGroup专门负责接受客户端的连接，WorkGroup专门负责网络的读写
	2）BossGroup和WorkGroup类型都是NioEventLoopGroup
	3）NioEventLoop相当于一个事件循环组，这个组中含有多个时间循环，每一个事件循环是NioEventLoop
	4）NioEventLoop表示一个不断循环的执行处理任务的线程，每个NioEventLoop都有一个selector，用于监听绑定在其上的socket的网络通讯
	5）NioEventLoopGroup可以有多个线程，即可以含有多个NioEventLoop
	6）每个BossNioEventLoop执行的步骤有3步
		1.轮训accpet事件
		2.处理accpet事件，与client建立连接，生成NioSocketChannel，并将其注册到某个workerNioEventloop上的selector
		3.处理任务队列的任务，即runAllTasks
	7）每个workerNioEvent循环执行的步骤
		1.轮询read，write事件
		2.处理i/o事件，即read，write事件，在对应nioSocketchanne处理
		3.处理任务队列的任务，runAllTasks
	8）每个WorkNioEventLoop处理业务时，会使用pipeline（管道）。
```

### **Netty线程模型**

#### **单Reactor单线程**



![image-20211102180758871](../images/Netty/image-20211102180758871.png)

```shell
#Reactor模式可划分为三种模型1.单Reactor单线程、2.单Reactor多线程、3.主从Reactor多线程

#概念
	1.Reactor模式，通过一个或多个输入同时传递给服务器的模式（基于事件驱动）
	2.服务器端程序处理传入的多个请求，并将它们同步分派到相应的处理线程，因此Reactor模式也叫Dispatcher（分发者）模式
	3.Reactor模式使用Io复用监听事件，收到事件后，分发给某个线程（进程），这点就是网络服务器高并发处理的关键

```

#### **单Reactor多线程**

![image-20211102180825023](../images/Netty/image-20211102180825023.png)

```shell
#方案说明
	1）Reactor对象通过select监控客户端请求事件，收到事件后，通过dispatch进行分发
	2）如果建立连接请求，则右Acceptor通过accept处理连接请求，然后创建一个Handler对象处理完成连接后的各种事件
	3）如果不是连接请求，则由Reactor分发调用连接对应的handler来处理
	4）handler只负责响应事件，不做具体的业务处理，通过read读取数据后，会分发给后面的worker线程吃的某个线程处理业务
	5）work线程池会分配独立的线程完成真正的业务，并将结果返回给handler
	6）handler收到响应后，通过send将结果返回给client
```



#### **主从Reactor多线程**

![image-20211102180901111](../images/Netty/image-20211102180901111.png)

```shell

```



## ***Netty应用实例***

### **群聊系统**

```shell
#实例要求
1）编写一个netty群聊系统，实现服务器端和客户端之间的数据简单通讯
```

