package com.itheima.jvmoptimize;

import com.itheima.jvmoptimize.leakdemo.demo7.TestLazy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

//-Xmx100m -Xms100m  -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/jvm/heapdemo.hprof
@SpringBootApplication
@EnableScheduling
public class JvmOptimizeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JvmOptimizeApplication.class, args);
    }

}
