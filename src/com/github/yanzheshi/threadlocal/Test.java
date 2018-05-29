package com.github.yanzheshi.threadlocal;

/**
 * ThreadLocal测试类
 * @author shiyanzhe
 */
public class Test {


    public static void main(String[] args) {

        //运行三个线程
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        thread1.start();
        thread2.start();
        thread3.start();

        //从输出结果中可以看到每个线程都持有者自己的那个值， 线程直接互不影响。
    }
}

/**
 * 自定义线程
 * 循环对ThreaLocal的值输出并自增1
 */
class MyThread extends Thread {

    @Override
    public void run() {
        while (true) {

            Integer current = ThreadLocalDemo.getValue();
            System.out.println(getName() + "当前值为：" + current);

            current++;
            ThreadLocalDemo.setValue(current);

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
