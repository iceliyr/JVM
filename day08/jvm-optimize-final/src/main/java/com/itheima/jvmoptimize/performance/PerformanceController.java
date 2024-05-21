package com.itheima.jvmoptimize.performance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
@RequestMapping("/performance")
public class PerformanceController {

    private Object obj1 = new Object();
    private Object obj2 = new Object();
    private Random random = new Random();

    @GetMapping("/1")
    public void test1(){
        while (true){

        }
    }

    @GetMapping("/deadlock1")
    public String test2() throws InterruptedException {
        synchronized (obj1){
            Thread.sleep(5000);
            synchronized (obj2){
                return "返回成功";
            }
        }
    }

    @GetMapping("/deadlock2")
    public String test3() throws InterruptedException {
        synchronized (obj2){
            Thread.sleep(5000);
            synchronized (obj1){
                return "返回成功";
            }
        }
    }

    @GetMapping("/slow")
    public void test4(int i) throws InterruptedException {
        if(i <= 0){
            return;
        }
        Thread.sleep(random.nextInt(2000));
        test5();
    }

    private void test5() throws InterruptedException {
        Thread.sleep(random.nextInt(1000));
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
