package com.itheima.springboot3nativedemo.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserDetails {
    private Long id;
    private Date register;
}
