package com.itheima.jvmoptimize.btrace;

import com.itheima.jvmoptimize.entity.UserEntity;

public class UserEntityTest {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            UserEntity userEntity = new UserEntity(1L, "123");
            userEntity.setId(2L);
            Thread.sleep(1000L);
        }
    }
}
