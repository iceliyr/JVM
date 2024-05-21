package com.itheima.jvmoptimize.performance.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class UserDetails {
    private Long id;
    private LocalDateTime register;
    private Date register2;
}
