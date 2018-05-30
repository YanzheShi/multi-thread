package com.github.yanzheshi.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author shiyanzhe
 */
public class CreateThread2 {
    public static void main(String[] args) {
        Mythread3 mythread3 = new Mythread3();
        FutureTask<Integer> futureTask = new FutureTask<>(mythread3);


        Thread thread3 = new Thread(futureTask);
        thread3.start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Mythread3 implements Callable<Integer> {
    @Override
    public Integer call() {
        int i;
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }

        return i;
    }
}


