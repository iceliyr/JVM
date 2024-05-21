package com.itheima.jvmoptimize.controller;

import com.itheima.jvmoptimize.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leak")
public class LeakController {
    private static Map<Long,UserEntity> userCache = new HashMap<>();
    private static List<byte[]> bigheap = new ArrayList<>();

    /**
     * 大量数据 + 处理慢
     */
    @GetMapping("/test")
    public void test1() throws InterruptedException {
        byte[] bytes = new byte[1024 * 1024 * 100];//100m
        Thread.sleep(10 * 1000L);
    }

    /**
     * 登录接口 传递名字和id,放入hashmap中
     */
    @PostMapping("/login")
    public void login(String name,Long id){
        userCache.put(id,new UserEntity(id,name));
    }


    @GetMapping("/bigheap")
    public void bigheap(){
        //3g
        for (int i = 0; i < 1024; i++) {
            bigheap.add(new byte[1024 * 1024 * 3]);
        }

    }
}
