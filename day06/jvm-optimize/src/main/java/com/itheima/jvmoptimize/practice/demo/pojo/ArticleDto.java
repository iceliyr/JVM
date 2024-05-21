package com.itheima.jvmoptimize.practice.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDto {
    private Long id;
    /* 标题
     */
    private String title;
    /* 内容
     */
    private String content;
}
