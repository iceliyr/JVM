package com.itheima.jvmoptimize.fullgcdemo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/fullgc")
public class Demo2Controller {

    private Cache cache = Caffeine.newBuilder().weakKeys().softValues().build();
    private List<Object> objs = new ArrayList<>();

    private static final int _1MB = 1024 * 1024;

    //FULLGC测试
    //-Xms8g -Xmx8g -Xss256k -XX:MaxMetaspaceSize=512m  -XX:+DisableExplicitGC -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/test.hprof  -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
    //ps + po 50并发 260ms  100并发 474  200并发 930
    //cms -XX:+UseParNewGC -XX:+UseConcMarkSweepGC 50并发 157ms  200并发 833
    //g1 JDK11 并发200 248
    @GetMapping("/1")
    public void test() throws InterruptedException {
        cache.put(RandomStringUtils.randomAlphabetic(8),new byte[10 * _1MB]);
    }

}
