package com.itheima.springboot3nativedemo.practice.service.impl;

import com.itheima.springboot3nativedemo.practice.dao.UserDao;
import com.itheima.springboot3nativedemo.practice.entity.User;
import com.itheima.springboot3nativedemo.practice.entity.UserDetails;
import com.itheima.springboot3nativedemo.practice.service.UserService;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, InitializingBean {

    private List<User> users = new ArrayList<>();

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDetails> getUserDetails() {
        return userDao.findUsers();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //初始化时生成数据
        for (int i = 1; i <= 10; i++) {
            users.add(new User((long) i, RandomStringUtils.randomAlphabetic(10)));
        }
    }
}
