package com.itheima.jvmoptimize.controller;

import com.itheima.jvmoptimize.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leak2")
public class LeakController2 {

    private Map<Long,Object> userCache = new HashMap<>();


    /**
     * 登录接口 id,放入hashmap中
     */
    @GetMapping("/login")
    public void login(Long id){
        userCache.put(id,new byte[ 1024 * 1024 * 300]);
    }


    /**
     * 登出接口，删除缓存的用户信息
     */
    @GetMapping("/logout")
    public void logout(Long id){
        userCache.remove(id);
    }
}
