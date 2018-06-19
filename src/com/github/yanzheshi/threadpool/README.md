#线程池

## Java 中的 ThreadPoolExecutor

构造参数：
- corePoolSize(线程池的基本大小)： 当提交一个任务到线程池时，线程池会创建一个线程
来执行任务， 即使其他空闲的基本线程能够执行新任务也会创建线程， 等到需要执行的任务
数大于线程池基本大小时就不再创建。如果调用了线程池的 prestartAllCoreThreads 方法，
线程池会提前创建并启动所有的基本线程。
- maximumPoolSize：线程池允许创创建的最大线程数
- keepAliveTime：表示线程没有任务执行时，如果一个线程空闲的时候达到keepAliveTime，
则会终止， 直到线程池中的线程数不超过corePoolSize， 但是如果调用了
allowCoreThreadTimeOut(boolean)方法， 在线程池中的线程不大于 corePoolSize 时，
keepAliveTime 参数也会起作用， 直到线程池中的线程数为0
- unit：参数keepAliveTime的时间单位
- workQueue： 一个阻塞队列， 用来存储等待执行的任务。
- threadFactory：线程工厂，主要用来创建线程
- handler：表示当拒绝处理任务时的策略

## 线程池实例
Executors 工具类提供生成线程池实例的方法。
1.8之前：

- newCachedThreadPool: 创建一个可缓存的线程池， 如果线程池长度超过处理需要，可
灵活回收空闲线程， 若无可回收，则新建线程
- newFixedThreaPool: 创建一个人定长线程池， 可控制线程最大并发数，超出的线程会在
队列中等待。
- newScheduledThreadPool: 创建一个定长线程池， 支持定时及周期任务执行
- newSingleThreadExecutor: 创建一个单线程化的线程池， 它只会用唯一的工作线程来
执行任务， 保证所有线程按照FIFO执行
- newSingleThreadScheduledExecutor: 创建一个单线程话的线程池， 定期或者延时
执行任务

newScheduledThreadPool 和 newSingleThreadScheduledExecutor 是
ScheduledThreadPoolExecutor的一个实现， 该类是对 ThreadPoolExecutor 的扩展
其他的线程池时直接对 ThreadPoolExecutor 的一个实现

1.8之后
- newWorkStealingPool：创建持有足够线程的线程池来支持给定的并行级别，
并通过使用多个队列，减少竞争，它需要穿一个并行级别的参数，如果不传，则被设定为
默认的CPU数量。  底层是ForkJoinPool的一个实现










---
###参考文档

[深入理解Java线程池](https://www.cnblogs.com/exe19/p/5359885.html)

