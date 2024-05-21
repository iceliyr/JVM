package com.itheima.jvmoptimize.fullgcdemo;

public class Demo1 {
    private static final int _1MB = 1024 * 1024;
    //1、频繁创建大对象 JDK8
    //-Xmn10m -Xms20m -Xmx20m -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3m -XX:MaxTenuringThreshold=15  -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseParNewGC -XX:+UseConcMarkSweepGC

    //-XX:+PrintFlagsInitial
    //-XX:PretenureSizeThreshold= 默认都进入年轻代 -XX:+PrintFlagsInitial
    public static void main(String[] args) {
//        byte[] b1 = new byte[2 * _1MB];
//        byte[] b2 = new byte[3 * _1MB];

        //-Xmn2g -Xms8g -Xmx8g -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=300m -XX:MaxTenuringThreshold=15  -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseParNewGC -XX:+UseConcMarkSweepGC
        new Thread(() -> {
            while (true){
                byte[] b2 = new byte[30 * _1MB];
            }
        }).start();
        while (true){
            byte[] b2 = new byte[512 * _1MB];
        }

    }
}
