# Java并发编程



## 一、进程与线程



### 1.进程与线程

**进程**

■ 程序由指令和数据组成,但这些指令要运行,数据要读写,就必须将指令加载至CPU,数据加载至内存。在指令运行过程中还需要用到磁盘、网络等设备。进程就是用来加载指令、管理内存、管理IO的。

■ 当一个程序被运行,从磁盘加载这个程序的代码至内存,这时就开启了一个进程。

■ 进程就可以视为程序的一个实例。大部分程序可以同时运行多个实例进程(例如记事本、画图、浏览器
等),也有的程序只能启动一个实例进程(例如网易云音乐、360安全卫士等)。



**线程**

■ 一个进程之内可以分为一到多个线程。

■ 一个线程就是一个指令流,将指令流中的一条条指令以一定的顺序交给CPU执行。

■ Java中,线程作为最小调度单位,进程作为资源分配的最小单位。在windows中进程是不活动的,只是
作为线程的容器。



**二者对比**

■ 进程基本上相互独立的,而线程存在于进程内,是进程的一个子集。
■ 进程拥有共享的资源,如内存空间等,供其内部的线程共享。
■ 进程间通信较为复杂：

​	同一台计算机的进程通信称为IPC(Inter-process communication)。

​	不同计算机之间的进程通信,需要通过网络,并遵守共同的协议,例如HTTP。
■ 线程通信相对简单,因为它们共享进程内的内存,一个例子是多个线程可以访问同一个共享变量。
■ 线程更轻量,线程上下文切换成本一般上要比进程上下文切换低。





### 2.并行与并发

**并发**

单核cpu下,线程实际还是`串行执行`的。操作系统中有一个组件叫做任务调度器,将cpu的时间片(windows下时间片最小约为15毫秒)分给不同的线程使用,只是由于cpu在线程间(时间片很短)的切换非常快,人类感觉是同时运行的。总结为一句话就是:`微观串行,宏观并行`。

一般会将这种 `线程轮流使用CPU` 的做法称为并发,concurrent。

![image-20250820092816182](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250820092816182.png)

![image-20250820092617795](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250820092617795.png)



**并行**

多核cpu下,每个核(core)都可以调度运行线程,这时候线程可以是并行的。

![image-20250820092959962](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250820092959962.png)

![image-20250820093157591](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250820093157591.png)





### 3.同步与异步

从方法调用的角度来讲,如果：

​	■ 需要等待结果返回,才能继续运行就是`同步`。

​	■ 不需要等待结果返回,就能继续运行就是`异步`。

注意:同步在多线程中还有另外一层意思,是让多个线程步调一致。

**1)设计**

多线程可以让方法执行变为异步的(即不要巴巴干等着)比如说读取磁盘文件时,假设读取操作花费了5秒钟,如果没有线程调度机制,这5秒调用者什么都做不了,其代码都得暂停…

**2)结论**

■ 比如在项目中,视频文件需要转换格式等操作比较费时,这时开一个新线程处理视频转换,避免阻塞主线程。

■ tomcat的异步servlet也是类似的目的,让用户线程处理耗时较长的操作,避免阻塞tomcat的工作线程。
■ ui 程序中,开线程进行其他操作,避免阻塞ui线程。





### 4.查看进程线程的方法

**windows**

​	■ 任务管理器可以查看进程和线程数,也可以用来杀死进程
​	■ tasklist 查看进程

​	■ taskkill 杀死进程

**linux**

​	■ ps -fe 查看所有进程

​	■ ps -fT -p<PID> 查看某个进程(PID)的所有线程
​	■ kill 杀死进程

​	■ top按大写H切换是否显示线程
​	■ top-H -p<PID> 查看某个进程(PID)的所有线程

**Java**

​	■ jps 命令查看所有 Java进程

​	■ jstack<PID> 查看某个Java进程(PID)的所有线程状态

​	■ jconsole 来查看某个Java进程中线程的运行情况(图形界面)





### 5.线程运行的原理

**（1）栈与栈帧**

Java Virtual Machine Stacks (Java虚拟机栈)

我们都知道JVM中由`堆、栈、方法区`所组成,其中栈内存是给谁用的呢?其实就是线程,`每个线程启动后,虚拟机就会为其分配一块栈内存`。

■ 每个栈由多个栈帧(Frame)组成,对应着每次方法调用时所占用的内存
■ 每个线程只能有一个活动栈帧,对应着当前正在执行的那个方法

注意：`不同线程的栈内存是相互独立的`，每个线程都拥有自己独立的栈空间，用于存放自己的栈帧。`不同线程的栈之间互不干扰`！

![image-20250820115953771](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250820115953771.png)



**（2）线程上下文切换(Thread Context Switch)**

因为以下一些原因导致cpu不再执行当前的线程,转而执行另一个线程的代码：

■ 线程的cpu时间片用完

■ 垃圾回收（暂停当前所有的工作线程，开启垃圾回收线程）

■ 有更高优先级的线程需要运行
■ 线程自己调用了 sleep、yield、wait、join、park、synchronized、lock 等方法

当 Context Switch 发生时,需要由操作系统`保存当前线程的状态`,并`恢复另一个线程的状态`。Java中对应的概念就是程序计数器(Program Counter Register),它的作用是记住下一条jvm指令的执行地址,是线程私有的。

■ 状态包括程序计数器、虚拟机栈中每个栈帧的信息,如局部变量、操作数栈、返回地址等
■ Context Switch 频繁发生会影响性能





### 6.java线程中常见的方法

![image-20250820144328541](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250820144328541.png)

![image-20250820144905981](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250820144905981.png)

![image-20250820184216524](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250820184216524.png)





### 7.主线程与守护线程

默认情况下,Java进程需要`等待所有线程都运行结束`,才会结束。

有一种特殊的线程叫做`守护线程`,只要其它非守护线程运行结束了,即使守护线程的代码没有执行完,也会强制结束。

注意：

​	■ 垃圾回收器线程就是一种守护线程

​	■ Tomcat中的Acceptor和Poller线程都是守护线程,所以Tomcat接收到shutdown命令后,不会等待它们处理完当前请求





### 8.线程状态

**（1）操作系统层面的线程状态（五种）**

​	■【初始状态】：仅是在语言层面创建了线程对象,还未与操作系统线程关联。
​	■【可运行状态】：(就绪状态)指该线程已经被创建(与操作系统线程关联),可以由CPU调度执行。
​	■【运行状态】：指获取了CPU时间片运行中的状态；当CPU时间片用完,会从【运行状态】转换至【可运行状态】,会导致线程的上下文切换。
​	■【阻塞状态】：如果调用了阻塞API,如BIO读写文件,这时该线程实际不会用到CPU,会导致线程上下文切换,进入【阻塞状态】；等BIO操作完毕,会由操作系统唤醒阻塞的线程,转换至【可运行状态】；与【可运行状态】的区别是,对【阻塞状态】的线程来说只要它们一直不唤醒,调度器就一直不会考虑调度它们。
​	■【终止状态】：表示线程已经执行完毕,生命周期已经结束,不会再转换为其它状态。

![image-20250820191424415](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250820191424415.png)



**（2）Java API 层面的线程状态（六种）**

根据 Thread.State 枚举,Java线程分为六种状态。

​	■ NEW：线程刚被创建,但是还没有调用start()方法。
​	■ RUNNABLE：当调用了start()方法之后。注意,Java API层面的RUNNABLE状态涵盖了操作系统层面的【可运行状态】、【运行状态】和部分【阻塞状态】(由于BIO导致的线程阻塞,在Java里无法区分,仍然认为是可运行)。

​	■ BLOCKED、WAITING、TIMED_WAITING：都是Java API层面对【阻塞状态】的细分,后面会在状态转换一节详述。
​	■ TERMINATED：当线程代码运行结束。

![image-20250820193328058](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250820193328058.png)







## 二、共享模型之管程



### 1.基本概念

**（1）管程是什么？（学术定义）**

​	管程的英文是 `Monitor`，中文也常翻译为`监视器`。它的定义可以追溯到上世纪70年代的操作系统理论，由 Per Brinch Hansen 和 Tony Hoare 提出。

​	核心思想：管程是一种用于`多线程互斥访问共享资源`的同步机制。你可以把它想象成一个`包含了共享数据和对这些数据操作的方法的类`，但这个类被设计成一次只允许一个线程执行其中的方法。

> ​	可以把管程看作一个建筑模型，这个建筑里有一个特殊的房间：
>
> ​		①房间（Monitor Object）：房间里有一些共享数据（共享变量）和操作这些数据的方法。
>
> ​		②锁（Lock）：房间门口有一把锁。任何时候，只有一个线程能拿到这把锁并进入房间。
>
> ​		③入口等待队列（Entry Set）：如果房间有人（即有线程持有锁），其他想进来的线程必须在门口的队列里排队等待。
>
> ​		④条件变量与等待集合（Condition Variables & Wait Set）：房间里的线程有时发现某些条件不满足（比如任务队列为空），它可以选择暂时释放锁，然后去房间里的一个“休息室”（等待集合）等待。这样其他线程就可以进入房间了。当房间里的线程改变了条件（比如往任务队列里放了一个任务），它可以通知（notify）休息室里的线程：“条件可能满足了，你们可以起来再试试了”。被通知的线程会离开休息室，但不会立即执行，而是回到入口队列重新竞争锁。



**（2）Java 中的管程实现**

​	Java 语言在设计之初就选择了管程作为其主要的并发同步机制。Java 中的每一个对象（即所有从 Object 类派生出来的对象）都自带一个管程（一把锁和等待集合）。

​	Java 主要通过两种方式让开发者使用这个内置的管程：

> ​		**方式一：synchronized 关键字（互斥）**
>
> ​			synchronized 关键字实现了管程的互斥特性。
>
> ​				①修饰实例方法：锁是当前实例对象 (this)。
>
> ​				②修饰静态方法：锁是当前类的 Class 对象。
>
> ​				③修饰代码块：锁是指定的对象。
>
> ​			当一个线程进入 synchronized 保护的代码块或方法时，它就获取了该对象管程的锁。其他线程再尝试进入任何被同一个锁保护的同步块时，就会被阻塞，并在入口等待队列（Entry Set） 中排队。

———————————————

> ​		**方式二：wait(), notify(), notifyAll()（同步）**
>
> ​			这三个方法（定义在 Object 类中）实现了管程的同步特性，用于线程间的协作。它们必须在 synchronized 代码块内部使用，因为它们操作的是当前锁对象关联的“休息室”（等待集合）。
>
> ​				①wait(): 当前线程释放已持有的锁，并进入该锁的等待集合（Wait Set） 中休眠，等待被唤醒。
>
> ​				②notify(): 随机唤醒该锁的等待集合中的一个线程。被唤醒的线程会从等待集合移到入口队列，重新去竞争锁。注意：它不会立即释放锁，而是要等到退出同步块后才会释放。
>
> ​				③notifyAll(): 唤醒该锁的等待集合中的所有线程。
>
> ​			为什么必须在 synchronized 内部使用？——因为这三个方法需要操作“锁”和“等待集合”之间的关系。线程必须先持有锁，才能释放它并进入与之对应的等待集合。



**（3）临界区 Critical Section**

​	多线程访问共享资源的问题：一个程序运行多个线程本身是没有问题的，问题出在多个线程访问共享资源；多个线程读共享资源其实也没有问题，但是在`多个线程对共享资源读写操作时发生指令交错`,就会出现问题！
​	一段代码块内如果存在`对共享资源的多线程读写操作`,则称这段代码块为`临界区`。

![image-20250821102142958](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821102142958.png)



**（4）竞态条件 Race Condition**

多个线程在临界区内执行,由于代码的执行序列不同而导致结果无法预测,称之为发生了竞态条件。





### 2.synchronized互斥锁

应用之互斥：为了避免临界区的竞态条件发生,有多种手段可以达到目的。

​	■ 阻塞式的解决方案:synchronized,Lock

​	■ 非阻塞式的解决方案:原子变量

synchronized,俗称【对象锁】。它采用互斥的方式让同一时刻至多只有一个线程能持有【对象锁】,其它线程再想获取这个【对象锁】时就会阻塞住。这样就能保证拥有锁的线程可以安全的执行临界区内的代码,不用担心线程上下文切换。

注意：虽然java中互斥和同步都可以采用synchronized关键字来完成,但它们还是有区别的:

​	■ 互斥是保证临界区的竞态条件发生,同一时刻只能有一个线程执行临界区代码

​	■ 同步是由于线程执行的先后、顺序不同、需要一个线程等待其它线程运行到某个点

思考：synchronized实际是用对象锁保证了临界区内代码的原子性,临界区内的代码对外是不可分割的,不会被线程切换所打断。





### 3.管程 Monitor

**（1）Java 对象头**

![image-20250821154317272](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821154317272.png)



![image-20250821154553015](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821154553015.png)



**（2）管程**

管程介绍：

![image-20250821154953712](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821154953712.png)

![image-20250821161341766](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821161341766.png)

———————————————

如下，为”上锁“、”争抢锁“的底层原理：

> 使用synchronized上锁，锁对象为obj。
>
> —当上锁时，obj对象的对象头中MarkWord字段指向Monitor管程锁。
>
> —当Thread-2线程成功争抢到锁，则Monitor的Owner主人字段指向Thread-2。
>
> —线程Thread-1、Thread-3争抢锁失败，则进入BLOCKED阻塞状态，并链入Monitor的等待队列EntryList。

![image-20250821155848855](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821155848855.png)



**（3）synchronized锁优化**

**<3.1>锁优化的小故事**

![image-20250821163935635](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821163935635.png)

![image-20250821164039897](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821164039897.png)



**<3.2>轻量级锁**

​	`轻量级锁`的使用场景：如果一个对象虽然有多线程访问,但多线程访问的时间是错开的(也就是没有竞争),那么可以使用轻量级锁来优化。

​	注意：轻量级锁对使用者是透明的,即语法仍然是synchronized。

![image-20250821164702715](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821164702715.png)

以上代码，其轻量级锁的加锁、解锁流程分析如下：

![image-20250821165008459](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821165008459.png)

![image-20250821165035593](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821165035593.png)

![image-20250821165201077](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821165201077.png)

![image-20250821165427745](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821165427745.png)

![image-20250821165743791](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821165743791.png)



**<3.3>锁膨胀**

​	如果在尝试加轻量级锁的过程中,CAS操作无法成功,这时一种情况就是有其它线程为此对象加上了轻量级锁(`有竞争`),这时需要进行`锁膨胀`,`将轻量级锁变为重量级锁`。

![image-20250821170622584](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821170622584.png)

以上代码，其锁膨胀流程分析如下：

![image-20250821170742441](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821170742441.png)

![image-20250821171138942](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821171138942.png)



**<3.4>偏向锁**

​	轻量级锁在没有竞争时(就自己这个线程),每次`重入`仍然需要执行CAS操作。

​	Java 6中引入了【`偏向锁`】来做进一步优化：只有第一次使用CAS将线程ID设置到对象的Mark Word头,之后发现这个线程ID是自己的就表示没有竞争,不用重新CAS。以后只要不发生竞争,这个对象就归该线程所有。

![image-20250821172752691](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821172752691.png)

偏向状态：

![image-20250821173320306](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821173320306.png)

​	注意：只有仅存在单个线程获取锁时，锁才会优化为偏向锁。若出现多个线程交错使用锁，则偏向锁会升级为轻量级锁；若多个线程相互争抢锁，则轻量级锁会膨胀为重量级锁。



**（4）wait & notify**

​	`wait方法`：当争抢到锁的线程调用wait()方法，则变为WAITING等待状态，进入WaitSet等待集合，并释放锁。

​	`notify方法`：当调用notify()方法，则唤醒WAITING等待状态的线程，使其进入EntryList准备下次争抢锁。

![image-20250821193947606](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250821193947606.png)

​	■ obj.wait()：让进入object监视器的线程到waitSet等待

​	■ obj.notify()：在object上正在waitSet等待的线程中随机挑一个唤醒

​	■ obj.notifyAll()：让object上正在waitSet等待的线程全部唤醒

注意：它们都是线程之间进行协作的手段,都属于Object对象的方法。必须获得此对象的锁,才能调用这几个方法。

> ​	sleep和wait的区别：
>
> ​		■ sleep是Thread方法,而wait是Object的方法
>
> ​		■ sleep不需要强制和synchronized配合使用,但wait需要和synchronized一起用
>
> ​		■ sleep在睡眠的同时,不会释放对象锁的,但wait在等待的时候会释放对象锁



**（5）park & unpark**

```
1.基本概念
 park和unpark：基于“许可(permit)”的阻塞和唤醒。（注意：wait和notify是基于“管程锁”）。
 这两个方法是Java并发包（java.util.concurrent.locks）中LockSupport类的核心静态方法，该包提供了比传统wait()/notify()更灵活、更可靠的线程阻塞与唤醒机制。它们是构建高级同步工具（如锁、屏障等）的基石。

2.功能
 ①park()：意为“停车”。
     ——它的作用是阻塞当前线程，使其进入等待状态（WAITING或TIMED_WAITING），直到获取一个“许可”（permit）。
 ②unpark(Thread thread)：意为“让停着的车开走”。
     ———它的作用是为指定的线程提供一个“许可”，如果该线程正因park()而阻塞，则立即唤醒它。

3.特点
 park&unpark 对比 wait&notify:
     ①wait,notify和notifyAll必须配合Object Monitor一起使用；而park,unpark不必。
     ②park&unpark是以线程为单位来阻塞和唤醒线程；而notify只能随机唤醒一个等待线程,notifyAll是唤醒所有等待线程,就不那么精确。
     ③park&unpark可以先unpark；而wait&notify不能先notify。
```

![image-20250822115720916](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822115720916.png)

![image-20250822115913000](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822115913000.png)

![image-20250822120011537](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822120011537.png)





### 4.线程的状态转换

![image-20250822120456558](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822120456558.png)

①WAITING：无时限等待

![image-20250822121452212](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822121452212.png)

![image-20250822121347184](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822121347184.png)

②TIMED_WAITING：有时限等待

![image-20250822122028969](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822122028969.png)

![image-20250822122143301](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822122143301.png)

③BLOCKED：阻塞等待争抢锁

![image-20250822122429947](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822122429947.png)





### 5.活跃性

①死锁

​	有这样的情况：一个线程需要同时获取多把锁,这时就容易发生死锁。

​	如：t1 线程 获得A对象 锁,接下来想获取B对象的锁；t2 线程获得B对象 锁,接下来想获取A对象的锁。

![image-20250822135700691](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822135700691.png)

②活锁

​	活锁出现在两个线程互相改变对方的结束条件,最后谁也无法结束。

③饥饿

​	很多教程中把饥饿定义为：一个线程由于优先级太低,始终得不到CPU调度执行,也不能够结束,饥饿的情况不易演示,讲读写锁时会涉及饥饿问题。





### 6.可重入锁 ReentrantLock

> 对比synchronized和ReentrantLock：
>
> ​	相对于synchronized锁，可重入锁ReentrantLock具备如下特点：
>
> ​		■ 可重入（synchronized也可重入）
>
> ​		■ 可中断
>
> ​		■ 可以设置超时时间
>
> ​		■ 可以设置为公平锁	
>
> ​		■ 支持多个条件变量
>
> 选择建议：
>
> ​	对于绝大多数简单的同步需求，使用 `synchronized`，代码更简洁，不易出错。
>
> ​	当需要可中断、超时、公平性、多个等待条件等高级功能时，毫不犹豫地选择 `ReentrantLock`。



**（1）可重入性 (Reentrancy)**

​	是什么？——可重入性是指**同一个线程可以多次获取同一把锁**而不会导致死锁。

​	为什么需要？——考虑一个递归调用或一个同步方法内部调用另一个同步方法的情况，如果锁不可重入，线程在第二次尝试获取自己已持有的锁时就会被阻塞，从而造成死锁。

​	ReentrantLock 可重入的实现？——`ReentrantLock` 内部维护了一个计数器（`hold count`）来跟踪锁被重入的次数。



**（2）可中断的锁获取 (Interruptible Lock Acquisition)**

​	是什么？——指一个线程在等待获取锁的过程中**可以响应中断**。如果线程在等待时被其他线程调用了 `interrupt()`，它会停止等待并抛出 `InterruptedException`。

​	为什么需要？——`synchronized` 在获取锁时是无法被中断的，这可能导致线程长时间无响应地等待，难以实现优雅的线程取消或系统关闭。`ReentrantLock` 的 `lockInterruptibly()` 方法解决了这个问题。



**（3）锁超时 (Timed Lock Acquisition)**

​	是什么？——指线程尝试获取锁时，可以**设置一个超时时间**。如果在规定时间内没有获得锁，线程不会无限期等待，而是放弃并返回 `false`。

​	为什么需要？——这可以有效避免死锁，或者用于实现“尝试锁”逻辑（“如果锁可用我就用，不可用我就先做别的事”）。



**（4）公平锁 (Fair Lock)**

​	是什么？——公平性是指锁的获取遵循**先来后到**（FIFO）的原则。等待时间最长的线程将优先获得锁。

​	如何设置？——通过在构造函数中传入 `true` 来创建一个公平锁。`ReentrantLock fairLock = new ReentrantLock(true);`

​	公平 vs 非公平：

​		公平锁：保证了顺序，避免了线程饥饿（某个线程永远拿不到锁）。但**性能开销较大**，因为需要维护队列和唤醒特定线程。

​		非公平锁（默认）：允许“插队”。当一个线程释放锁时，恰好另一个新线程来请求，新线程可能会抢先获得锁，而不理会等待队列中的老线程。**吞吐量更高**，但可能导致某些线程等待时间过长。

​	如何选择？——在绝大多数情况下，使用**非公平锁**（默认）即可。



**（5）条件变量 (Condition)**

​	是什么？——条件变量 `Condition` 实现了 `wait/notify` 的线程等待/唤醒机制，但与之相比，**一个 `ReentrantLock` 可以关联多个 `Condition`**，从而实现更精细的线程控制。

​	为什么需要？——`Object` 的 `wait()` 和 `notify()`/`notifyAll()` 必须和 `synchronized` 一起使用，并且只有一个等待队列。`Condition` 的 `await()`/`signal()`/`signalAll()` 必须和 `Lock` 一起使用，但可以创建多个等待队列，只唤醒特定类型的线程，减少不必要的唤醒。







## 三、共享模型之内存



### 1.Java内存模型

**（1）基本概念**

​	JMM即 Java Memory Model,它定义了主存、工作内存抽象概念,底层对应着CPU寄存器、缓存、硬件内存、CPU指令优化等。

​	JMM体现在以下几个方面：

​		■ 原子性——保证指令不会受到线程上下文切换的影响

​		■ 可见性——保证指令不会受cpu缓存的影响

​		■ 有序性——保证指令不会受cpu指令并行优化的影响



**（2）可见性**

![image-20250822172002706](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822172002706.png)

![image-20250822172157961](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822172157961.png)

![image-20250822172248785](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822172248785.png)

 ![image-20250822172354829](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822172354829.png)

解决方法：volatile(易变关键字)

​	volatile可以用来修饰成员变量和静态成员变量,他可以避免线程从自己的工作缓存中查找变量的值,必须到主存中获取它的值,线程操作volatile变量都是直接操作主存。

其它解决方案：synchronized加锁（最安全，但重量级）



**（3）有序性**

什么是有序性？

![image-20250822221933099](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822221933099.png)

指令重排带来的问题：

![image-20250822223051607](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822223051607.png)

![image-20250822223113327](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250822223113327.png)

问题原因：num=2; 和 ready=true; 这两条语句发生了指令重排序。

解决方法：为成员变量 ready 添加 volatile 易变关键字。（底层添加了写屏障，防止赋值语句 ready=true; 之前的代码被重排序）

其它解决方案：synchronized加锁（最安全，但重量级）





### 2.volatile原理

**volatile易变关键字**：可以保证共享变量的**可见性**和**有序性**。

volatile的底层实现原理是**内存屏障**,Memory Barrier(Memory Fence)

​	■ 对 volatile 变量的写指令后会加入写屏障

​	■ 对volatile 变量的读指令前会加入读屏障

①volatile读写屏障 如何保证可见性？

​	■ 写屏障(sfence)保证在该屏障之前的,对共享变量的改动,都同步到主存当中

​	■ 而读屏障(lfence)保证在该屏障之后,对共享变量的读取,加载的是主存中最新数据

![image-20250823105936459](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250823105936459.png)

②volatile读写屏障 如何保证有序性？

​	■ 写屏障会确保指令重排序时,不会将写屏障之前的代码排在写屏障之后

​	■ 读屏障会确保指令重排序时,不会将读屏障之后的代码排在读屏障之前

![image-20250823110214397](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250823110214397.png)







## 四、共享模型之无锁（乐观锁）



### 1.CAS（Compare And Set）

案例如下：

![image-20250823133615222](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250823133615222.png)

其中的关键是compareAndSet,它的简称就是**CAS**(也有Compare And Swap的说法),它必须是**原子操作**。

![image-20250823135559778](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20250823135559778.png)

**CAS的特点**：

结合CAS和volatile可以实现无锁并发，适用于线程数少、多核CPU的场景下。

​	■ CAS是基于乐观锁的思想：最乐观的估计,不怕别的线程来修改共享变量,就算改了也没关系,我吃亏点再重试呗。

​	■ synchronized是基于悲观锁的思想：最悲观的估计,得防着其它线程来修改共享变量,我上了锁你们都别想改,我改完了解开锁,你们才有机会。

​	■ CAS体现的是无锁并发、无阻塞并发，请仔细体会这两句话的意思：因为没有使用synchronized,所以线程不会陷入阻塞,这是效率提升的因素之一；但如果竞争激烈,可以想到重试必然频繁发生,反而效率会受影响。