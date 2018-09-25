package com.github.yanzheshi.scheduledTask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Java 中创建定时任务
 * @author shiyanzhe
 * @date 2018/9/25
 */
public class ScheduledTask {

    /**
     * 使用Timer创建定时任务
     * @deprecated  Timer执行多个定时任务时， 只要有一个没有捕获异常， 其他任务变自动终止
     */
    @Deprecated
    public void scheduleRun1() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hehe1");
            }
        }, 3000, 3000);
    }

    /**
     * 推荐的定时任务执行方式
     */
    public void scheduleRun2() {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(2);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("hehe2"),
            0, 3, TimeUnit.SECONDS);
    }

    /**
     * scheduleAtFixedRate 与 scheduleWithFixedDelay 对比
     * 1. scheduleAtFixedRate： 按照固定频率执行任务。
     *  假如上一个任务执行时刻为0， 那么后面的执行时间依次为 0 + 1 * period， 0 + 2 * period；
     *  但如果一个任务执行时间超过了period，即下一个（或多个）任务无法按照计划时间执行，那么下一个（或多个）任务就在这个任务执行后立刻执行，
     *  不影响其他任务的执行时间
     *
     * 2. scheduleWithFixedDelay： 按照固定间隔执行任务。下一个任务总是在前一个任务执行后的 period时间后执行
     * 推荐的定时任务执行方式
     */
    public void scheduleRun3(){
        int count1 = 0;
        int count2 = 0;
        long startTime = System.currentTimeMillis();
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(2);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
                System.out.println(System.currentTimeMillis() / 1000 + " hehe1_" + count1);
                if (System.currentTimeMillis() < startTime + 10 * 1000) {
                    System.out.println("sleep");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },
            0, 3, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(() -> {
                System.out.println(System.currentTimeMillis() / 1000 + " hehe2_" + count2);
                if (System.currentTimeMillis() < startTime + 10 * 1000) {
                    System.out.println("sleep");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },
            0, 3, TimeUnit.SECONDS);
    }
}
