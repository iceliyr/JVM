package com.itheima.jvmoptimize.controller;

import com.itheima.jvmoptimize.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class OOMController {
    private static Map<Long,UserEntity> userCache = new HashMap<>();

    @PostConstruct
    public void init(){
        userCache.put(0L,new UserEntity(0L,"张三"));
    }

    //根据id获取用户信息
    @GetMapping("/{id}")
    public UserEntity user(@PathVariable("id") Long id){
        return userCache.get(id);
    }

    //批量创建缓存
    @GetMapping("/createCache")
    public void createCache()
    {
        for (long i = 0; i < 10000000L; i++) {
            userCache.put(i,new UserEntity(i,String.valueOf(i)));
        }
    }
}
