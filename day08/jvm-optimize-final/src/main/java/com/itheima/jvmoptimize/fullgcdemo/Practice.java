package com.itheima.jvmoptimize.fullgcdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

//实战
//参数： -Xms1g -Xmx1g -Xss256k    -XX:MaxMetaspaceSize=256m  -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDateStamps  -XX:+PrintGCDetails -XX:+DisableExplicitGC -Xloggc:D:/test.log
// -Xms2g -Xmx2g    -XX:MaxMetaspaceSize=256m -XX:MetaspaceSize=256m   -XX:+DisableExplicitGC -Xlog:gc*:file=D:/test.log
@RestController
@RequestMapping("/gcpractice")
public class Practice {

    private static final int _1MB = 1024 * 1024;

    @GetMapping
    public void test(){
        Random random = new Random();
        new Thread(() -> {
            final byte[] bytes = new byte[2 * _1MB];
            try {
                Thread.sleep(random.nextInt(2500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
