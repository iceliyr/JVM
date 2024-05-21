package com.itheima.springboot3nativedemo.practice.service;

import com.itheima.springboot3nativedemo.practice.entity.User;
import com.itheima.springboot3nativedemo.practice.entity.UserDetails;

import java.util.List;

public interface UserService {
    List<UserDetails> getUserDetails();

    List<User> getUsers();
}
