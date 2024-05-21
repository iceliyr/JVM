package com.itheima.jvmoptimize.fullgcdemo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/bigobj")
public class Demo1Controller {
    private Cache cache = Caffeine.newBuilder().expireAfterWrite(Duration.ofSeconds(10)).build();
    private static final int _1MB = 1024 * 1024;
    private static final List list = new ArrayList<>();
    //-Xmn2g -Xms8g -Xmx8g -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=20m -XX:MaxTenuringThreshold=15  -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseParNewGC -XX:+UseConcMarkSweepGC

    @GetMapping("/1")
    public void test() throws InterruptedException {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            objects.add(new byte[3 * _1MB]);
        }

//        Thread.sleep(new Random().nextInt(200));
    }

    //-Xms8g -Xmx8g  -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
    @SneakyThrows
    @GetMapping("/2")
    public void test2(){
        cache.put(new Random().nextInt(1000),new byte[ 3 * _1MB]);
        Thread.sleep(new Random().nextInt(200));
    }

    @SneakyThrows
    @GetMapping("/3")
    public void test3(){
        byte[] bytes = new byte[6 * _1MB];
    }

    //-XX:+DisableExplicitGC
    @SneakyThrows
    @GetMapping("/4")
    public void test4(){
        System.gc();
    }
}
