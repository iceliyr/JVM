package com.itheima.jvmoptimize.leakdemo.demo5;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo5_1 {
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            new Thread(() -> {
                threadLocal.set(new byte[1024 * 1024 * 10]);
            }).start();
            Thread.sleep(10);
        }


    }
}
