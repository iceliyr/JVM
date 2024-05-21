package com.itheima.jvmoptimize.matdemo;

import org.openjdk.jol.info.ClassLayout;

public class StringSize {
    public static void main(String[] args) {
        //使用JOL打印String对象
        System.out.print(ClassLayout.parseClass(String.class).toPrintable());
    }
}
