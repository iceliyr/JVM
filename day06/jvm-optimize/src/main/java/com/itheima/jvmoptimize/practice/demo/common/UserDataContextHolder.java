package com.itheima.jvmoptimize.practice.demo.common;

public class UserDataContextHolder {
    public  static ThreadLocal<UserData> userData = new ThreadLocal<>();

    public static class UserData{
        byte[] data = new byte[1024 * 1024 * 10]; //模拟保存10m的用户数据
    }
}

