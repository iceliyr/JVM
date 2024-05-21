package com.itheima.jvmoptimize.performance.practice.service;

import com.itheima.jvmoptimize.performance.practice.entity.User;
import com.itheima.jvmoptimize.performance.practice.entity.UserDetails;
import com.itheima.jvmoptimize.performance.practice.vo.UserVO;

import java.util.List;

public interface UserService {
    List<UserDetails> getUserDetails();

    List<User> getUsers();
}
