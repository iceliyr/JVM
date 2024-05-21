package com.itheima.jvmoptimize.performance.practice.dao;

import com.itheima.jvmoptimize.performance.practice.entity.UserDetails;

import java.util.List;

public interface UserDao {
    List<UserDetails> findUsers();
}
