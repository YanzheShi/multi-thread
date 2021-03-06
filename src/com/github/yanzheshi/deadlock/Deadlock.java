package com.github.yanzheshi.deadlock;

import java.util.LinkedList;
import java.util.List;

/**
 * 写一个必然死锁的程序
 * 死锁原因，两个线程都在等待另一个线程去给list添加元素。
 * @author shiyanzhe
 */
public class Deadlock {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();

        MyThread thread2 = new MyThread();


        List list = new LinkedList();

        thread1.list = list;
        thread2.list = list;

        thread1.start();
        thread2.start();
    }

}

class MyThread extends Thread {

    /**
     * 锁
     */
    public Object lock = getClass();

    public List list;



    @Override
    public void run() {
        synchronized (lock) {
            if (list.size() == 0) {
                try {
                    //等待其他线程在list里面添加元素
                    //注意， wait/notify必须是由锁对象来调用
                    //否则导致 IllegalMonitorStateException
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            notifyAll();
        }
    }
}
