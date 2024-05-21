package com.itheima.jvmoptimize.btrace;

import java.io.File;

public class FileCreator {

    public static void main(String[] args) throws Exception{
        for(int i = 0; i < 250; i++) {
            File file = new File("D://jvm//" + i);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            Thread.sleep(10000);
        }
    }
}