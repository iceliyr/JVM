package com.itheima.jvmoptimize.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component
public class UserTask {
    private static final int _1MB = 1024 * 1024;
    
    @Scheduled(fixedRate = 200L)
    public void processUserData(){
        Random random = new Random();
        for (int i = 0; i < random.nextInt(10); i++) {
            new Thread(() -> {
                final byte[] bytes = new byte[20 * _1MB];
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
