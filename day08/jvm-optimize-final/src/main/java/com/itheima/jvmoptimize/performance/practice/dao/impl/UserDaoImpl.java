package com.itheima.jvmoptimize.performance.practice.dao.impl;

import com.itheima.jvmoptimize.performance.practice.dao.UserDao;
import com.itheima.jvmoptimize.performance.practice.entity.UserDetails;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    //提前准备好数据
    private List<UserDetails> users = new ArrayList<>();

    @PostConstruct
    public void init(){
        //初始化时生成数据
        for (int i = 1; i <= 10000; i++) {
            users.add(new UserDetails((long) i, LocalDateTime.now(),new Date()));
        }
    }

    /*
       模拟下数据库查询接口，主要目的是只优化Java代码，屏蔽SQL相关的内容
     */
    @Override
    public List<UserDetails> findUsers() {
        return users;
    }
}
