package com.github.yanzheshi.threadlocal;

import java.util.Random;

/**
 * ThreadLocal示例
 * 初始值为一个随机数字
 * @author shiyanzhe
 */
public class ThreadLocalDemo {

    //初始值为1
    private static ThreadLocal<Integer> connectionHolder
            = ThreadLocal.withInitial(() -> {
        Random random = new Random();
        return random.nextInt(10);
    });


    public static Integer getValue(){
        return connectionHolder.get();
    }

    public static void setValue(int value) {
        connectionHolder.set(value);
    }
}
