package com.itheima.springboot3nativedemo.practice.dao;

import com.itheima.springboot3nativedemo.practice.entity.UserDetails;

import java.util.List;

public interface UserDao {
    List<UserDetails> findUsers();
}
