package com.itheima.jvmoptimize.performance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/performance")
public class PerformanceController {

    private Object obj1 = new Object();
    private Object obj2 = new Object();
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Random random = new Random();

    @GetMapping("/1")
    public void test1(){
        while (true){

        }
    }

    @GetMapping("/deadlock1")
    public String test2() throws InterruptedException {
//        synchronized (obj1){
//            Thread.sleep(5000);
//            synchronized (obj2){
//                return "返回成功";
//            }
//        }

        boolean b1 = lock1.tryLock(1, TimeUnit.SECONDS);
        if(b1){
            try {
                Thread.sleep(5000);
                boolean b2 = lock2.tryLock(1, TimeUnit.SECONDS);
                if(b2){
                    try{
                        return "返回成功";
                    }
                    finally {
                        lock2.unlock();
                    }
                }
            }finally {
                lock1.unlock();
            }
        }
        return "处理失败";
    }

    @GetMapping("/deadlock2")
    public String test3() throws InterruptedException {
        boolean b1 = lock2.tryLock(1, TimeUnit.SECONDS);
        if(b1){
            try {
                Thread.sleep(5000);
                boolean b2 = lock1.tryLock(1, TimeUnit.SECONDS);
                if(b2){
                    try{
                        return "返回成功";
                    }
                    finally {
                        lock1.unlock();
                    }
                }
            }finally {
                lock2.unlock();
            }
        }
        return "处理失败";
    }

    @GetMapping("/slow")
    public void a(int i) throws InterruptedException {
        if(i <= 0){
            return;
        }
        Thread.sleep(random.nextInt(2000));
        b();
    }

    private void b() throws InterruptedException {
        Thread.sleep(random.nextInt(1000));
    }

    @GetMapping("/slow2")
    public void slow2() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            random.nextInt(1000);
        }
    }


    @GetMapping("/profile1")
    public void test6() throws InterruptedException {
        ArrayList<Integer> objects = new ArrayList<>();
        for (Integer i = 0; i < 20000000; i++) {
            objects.add(i);
        }
    }

    @GetMapping("/profile2")
    public void test7() throws InterruptedException {
        ArrayList<Integer> objects = new ArrayList<>(20000000);
        for (Integer i = 0; i < 20000000; i++) {
            objects.add(i);
        }
    }

}
