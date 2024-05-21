package com.itheima.jvmoptimize.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserEntity {
    private Long id;
    private String name;
    //每个对象增加1MB的额外内存，让溢出来的更快一些
    //private byte[] bytes = new byte[1024 * 1024];

    public UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
