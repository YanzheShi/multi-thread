#如何创建线程

创建线程的方式
- 继承 Thread 重写 run 方法， 调用 start 方法启动线程
- 通过 Runnable 接口实现类构造Thread
- 通过 Callable 接口实现类构造Thread， 支持带有返回值的线程