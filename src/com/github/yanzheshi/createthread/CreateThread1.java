package com.github.yanzheshi.createthread;

/**
 * 创建线程方式一
 * 实现Runnable接口
 * 或者继承Thread （Runnable的内置实现类， 于实现Runnable本质相同）
 * @author shiyanzhe
 */
public class CreateThread1 {
    public static void main(String[] args) {
        //线程1
        MyThread1 myThread1 = new MyThread1();
        //使用Runnable来构造一个Thread
        Thread thread1 = new Thread(myThread1);
        //启动线程
        thread1.start();


        //线程2
        MyThread2 myThread2 = new MyThread2();
        //启动线程
        myThread2.start();

    }
}


class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("myThread1: " + i);
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("myThread2: " + i);
        }

    }
}
