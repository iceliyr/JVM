package com.itheima.jvmoptimize.leakdemo.demo2;

import java.util.HashMap;
import java.util.Map;

public class Demo0 {
    public static long count = 0;
    public static void main(String[] args) throws InterruptedException {
        while (true){
            Student student = new Student();
            student.setId(1);
            student.setName("张三");
        }
    }
}
